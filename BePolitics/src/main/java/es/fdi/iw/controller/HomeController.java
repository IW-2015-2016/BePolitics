package es.fdi.iw.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import es.fdi.iw.ContextInitializer;
import es.fdi.iw.model.Author;
import es.fdi.iw.model.Book;
import es.fdi.iw.model.Genero;
import es.fdi.iw.model.User;
import es.fdi.iw.model.modificadores.ModificadorProduccion;
import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.pais.Recursos;
import es.fdi.iw.model.pais.construcciones.Construcciones;
import es.fdi.iw.model.politicos.ExceptionPolitico;
import es.fdi.iw.model.politicos.Politico;
import es.fdi.iw.model.usuario.ExceptionUsuario;
import es.fdi.iw.model.usuario.Rol;
import es.fdi.iw.model.usuario.TipoLider;
import es.fdi.iw.model.usuario.Usuario;

/**
 * Una aplicación de ejemplo para IW.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Intercepts login requests generated by the header; then continues to load normal page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Transactional
	public String login(
			@RequestParam("login") String formLogin,
			@RequestParam("pass") String formPass,
			@RequestParam("source") String formSource,
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session) {
		
		logger.info("Login attempt from '{}' while visiting '{}'", formLogin, formSource);
		
		// validate request
		if (formLogin == null || formLogin.length() < 4 || formPass == null || formPass.length() < 4) {
			model.addAttribute("loginError", "usuarios y contraseñas: 4 caracteres mínimo");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			User u = null;
			try {
				u = (User)entityManager.createNamedQuery("userByLogin")
					.setParameter("loginParam", formLogin).getSingleResult();
				if (u.isPassValid(formPass)) {
					logger.info("pass was valid");				
					session.setAttribute("user", u);
					// sets the anti-csrf token
					getTokenForSession(session);
				} else {
					logger.info("pass was NOT valid");
					model.addAttribute("loginError", "error en usuario o contraseña");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			} catch (NoResultException nre) {
				if (formPass.length() == 4) {
					// UGLY: register new users if they do not exist and pass is 4 chars long
					logger.info("no-such-user; creating user {}", formLogin);				
					User user = User.createUser(formLogin, formPass, "user");
					entityManager.persist(user);				
					session.setAttribute("user", user);
					// sets the anti-csrf token
					getTokenForSession(session);					
				} else {
					logger.info("no such login: {}", formLogin);
				}
				model.addAttribute("loginError", "error en usuario o contraseña");
			}
		}
		
		// redirects to view from which login was requested
		return "redirect:" + formSource;
	}
	
	/**
	 * Delete a user; return JSON indicating success or failure
	 */
	@RequestMapping(value = "/delUser", method = RequestMethod.POST)
	@ResponseBody
	@Transactional // needed to allow DB change
	public ResponseEntity<String> bookAuthors(@RequestParam("id") long id,
			@RequestParam("csrf") String token, HttpSession session) {
		if ( ! isAdmin(session) || ! isTokenValid(session, token)) {
			return new ResponseEntity<String>("Error: no such user or bad auth", 
					HttpStatus.FORBIDDEN);
		} else if (entityManager.createNamedQuery("delUser")
				.setParameter("idParam", id).executeUpdate() == 1) {
			return new ResponseEntity<String>("Ok: user " + id + " removed", 
					HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error: no such user", 
					HttpStatus.BAD_REQUEST);
		}
	}			
	
	/**
	 * Logout (also returns to home view).
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("User '{}' logged out", session.getAttribute("user"));
		session.invalidate();
		return "home2";
	}

	/**
	 * Uploads a photo for a user
	 * @param id of user 
	 * @param photo to upload
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("photo") MultipartFile photo,
    		@RequestParam("id") String id){
        if (!photo.isEmpty()) {
            try {
                byte[] bytes = photo.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(
                        		new FileOutputStream(ContextInitializer.getFile("user", id)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + id + 
                		" into " + ContextInitializer.getFile("user", id).getAbsolutePath() + "!";
            } catch (Exception e) {
                return "You failed to upload " + id + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload a photo for " + id + " because the file was empty.";
        }
    }

	/**
	 * Displays user details
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(HttpSession session, HttpServletRequest request) {		
		return "user";
	}	

	/**
	 * Displays single-book details
	 */
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public String book(@PathVariable("id") long id, HttpServletResponse response, Model model) {
		Book b = entityManager.find(Book.class, id);
		if (b == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			logger.error("No such book: {}", id);
		} else {
			model.addAttribute("book", b);
		}
		model.addAttribute("prefix", "../");
		return "book";
	}	
	
	/**
	 * Delete a book
	 */
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	@Transactional
	@ResponseBody
	public String rmbook(@PathVariable("id") long id, HttpServletResponse response, Model model) {
		try {
			Book b = entityManager.find(Book.class, id);
			for (Author a : b.getAuthors()) {
				a.getWritings().remove(b);
				entityManager.persist(a);
			}
			entityManager.remove(b);
			response.setStatus(HttpServletResponse.SC_OK);
			return "OK";
		} catch (NoResultException nre) {
			logger.error("No such book: {}", id, nre);
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return "ERR";
		}
	}		
	
	/*
	 * List all books
	 */
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@Transactional
	public String books(Model model) {
		model.addAttribute("books", entityManager.createNamedQuery("allBooks").getResultList());
		model.addAttribute("owners", entityManager.createNamedQuery("allUsers").getResultList());
		model.addAttribute("authors", entityManager.createNamedQuery("allAuthors").getResultList());
		return "books";
	}	
	
	/*
	 * Add a book
	 */
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	@Transactional
	public String book(@RequestParam("owner") long ownerId,
			@RequestParam("authors") long[] authorIds,
			@RequestParam("title") String title,
			@RequestParam("description") String description, Model model) {
		Book b = new Book();
		b.setTitle(title);
		b.setDescription(description);
		for (long aid : authorIds) {
			// adding authors to book is useless, since author is the owning side (= has no mappedBy)
			Author a = entityManager.find(Author.class, aid);
			a.getWritings().add(b);
			entityManager.persist(a);
		}
		b.setOwner(entityManager.getReference(User.class, ownerId));
		entityManager.persist(b);
		entityManager.flush();
		logger.info("Book " + b.getId() + " written ok - owned by " + b.getOwner().getLogin() 
				+ " written by " + b.getAuthors());
		
		return "redirect:book/" + b.getId();
	}	
	/**
	 * Load book authors for a given book via post; return as JSON
	 */
	@RequestMapping(value = "/bookAuthors")
	@ResponseBody
	@Transactional // needed to allow lazy init to work
	public ResponseEntity<String> bookAuthors(@RequestParam("id") long id, HttpServletRequest request) {
		try {
			Book book = (Book)entityManager.find(Book.class, id);
			List<Author> authors = book.getAuthors();
			StringBuilder sb = new StringBuilder("[");
			for (Author a : authors) {
				if (sb.length()>1) sb.append(",");
				sb.append("{ "
						+ "\"id\": \"" + a.getId() + "\", "
						+ "\"familyName\": \"" + a.getFamilyName() + "\", "
						+ "\"lastName\": \"" + a.getLastName() + "\"}");
			}
			return new ResponseEntity<String>(sb + "]", HttpStatus.OK);
		} catch (NoResultException nre) {
			logger.error("No such book: {}", id, nre);
		}
		return new ResponseEntity<String>("Error: libro no existe", HttpStatus.BAD_REQUEST);		
	}			
	
	/**
	 * Displays author details
	 */
	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
	public String author(@PathVariable("id") long id, Model model) {		
		try {
			model.addAttribute("author", entityManager.find(Author.class, id));
		} catch (NoResultException nre) {
			logger.error("No such author: {}", id, nre);
		}
		model.addAttribute("prefix", "../");
		return "author";
	}	
	
	/**
	 * Returns a users' photo
	 * @param id id of user to get photo from
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/user/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] userPhoto(@RequestParam("id") String id) throws IOException {
	    File f = ContextInitializer.getFile("user", id);
	    InputStream in = null;
	    if (f.exists()) {
	    	in = new BufferedInputStream(new FileInputStream(f));
	    } else {
	    	in = new BufferedInputStream(
	    			this.getClass().getClassLoader().getResourceAsStream("unknown-user.jpg"));
	    }
	    
	    return IOUtils.toByteArray(in);
	}
	
	/**
	 * Toggles debug mode
	 */
	@RequestMapping(value = "/debug", method = RequestMethod.GET)
	public String debug(HttpSession session, HttpServletRequest request) {
		String formDebug = request.getParameter("debug");
		logger.info("Setting debug to {}", formDebug);
		session.setAttribute("debug", 
				"true".equals(formDebug) ? "true" : "false");
		return "redirect:/";
	}

    @RequestMapping(value = "/s", method = RequestMethod.GET)
	public String poniendoSesion(Locale locale, Model model, HttpSession session) {
    	//session.setAttribute("user", "juan");
		return "home";
	}
   


    
   
	@RequestMapping(value = "/vistaAdminEditor", method = RequestMethod.GET)
   	public String vistaAdminEditor(Locale locale, Model model, HttpSession session) {
<<<<<<< HEAD
=======
		//model.addAttribute("admin", "pedro");
		
>>>>>>> origin/master
		model.addAttribute("editores", entityManager.createNamedQuery("allUsuarioRol").setParameter("rolParam", Rol.Editor).getResultList());
		return "vistaAdminEditor";
   	}
    @RequestMapping(value = "/vistaAdminUsuario", method = RequestMethod.GET)
   	public String vistaAdminUsuario(Locale locale, Model model, HttpSession session) {
    	model.addAttribute("usuarios", entityManager.createNamedQuery("allUsuarioRol").setParameter("rolParam", Rol.UsuarioRegistrado).getResultList());
   		return "vistaAdminUsuario";
   	}
    @RequestMapping(value = "/vistaAdminNoticias", method = RequestMethod.GET)
   	public String vistaAdminNoticias(Locale locale, Model model, HttpSession session) {
    	//model.addAttribute("admin", "pedro");
   		return "vistaAdminNoticias";
   	}
    @RequestMapping(value = "/vistaAdminEventos", method = RequestMethod.GET)
   	public String vistaAdminEventos(Locale locale, Model model, HttpSession session) {
    	model.addAttribute("admin", "pedro");
   		return "vistaAdminEventos";
   	}
    @RequestMapping(value = "/vistaAdminPoliticos", method = RequestMethod.GET)
   	public String vistaAdminPoliticos( Model model, HttpSession session) {
    	
    	model.addAttribute("politicos", entityManager.createNamedQuery("allPoliticos").getResultList());
    	
   		return "vistaAdminPoliticos";
   	}

    



	@RequestMapping(value = "/w", method = RequestMethod.GET)
	public String poniendoModelo(Locale locale, Model model, HttpSession session) {
    	//model.addAttribute("anterior", session.getAttribute("user"));
		model.addAttribute("user", "pedro");
		return "home2";
	}


	
	@RequestMapping(value = "/pru", method = RequestMethod.GET)
	public String prueba2(Locale locale, Model model, HttpSession session) {
    	//model.addAttribute("anterior", session.getAttribute("user"));
		model.addAttribute("test", "pedro");
		return "home2";
	}
	
	
	@RequestMapping(value = "/o", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {
		return "home2";
	}
	public String algo(Locale locale, Model model, HttpSession session) {
		return "redirect:logout";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String empty(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("pageTitle", "BePolitics");

		return "home2";
	}	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return empty(locale, model);
	}	

	/**
	 * A not-very-dynamic view that shows an "about us".
	 */
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	@Transactional
	public String about(Locale locale, Model model) {
		logger.info("User is looking up 'about us'");
		@SuppressWarnings("unchecked")
		List<User> us = (List<User>)entityManager.createQuery("select u from User u").getResultList();
		System.err.println(us.size());
		model.addAttribute("users", us);
		model.addAttribute("pageTitle", "IW: Quienes somos");
		return "about";
	}
	
	
	/**
	 * Checks the anti-csrf token for a session against a value
	 * @param session
	 * @param token
	 * @return the token
	 */
	static boolean isTokenValid(HttpSession session, String token) {
	    Object t=session.getAttribute("csrf_token");
	    return (t != null) && t.equals(token);
	}
	
	/**
	 * Returns an anti-csrf token for a session, and stores it in the session
	 * @param session
	 * @return
	 */
	static String getTokenForSession (HttpSession session) {
	    String token=UUID.randomUUID().toString();
	    session.setAttribute("csrf_token", token);
	    return token;
	}
	
	/** 
	 * Returns true if the user is logged in and is an admin
	 */
	static boolean isAdmin(HttpSession session) {
		User u = (User)session.getAttribute("user");
		if (u != null) {
			return u.getRole().equals("admin");
		} else {
			return false;
		}
	}
	

	/** 
	 * Returns true if the user is logged in and is an admin
	 */
	static boolean esAdministrador(HttpSession session) {
		Usuario u = (Usuario)session.getAttribute("rol");
		if (u != null) {
			return u.getRol().toString().equals(Rol.Administrador.toString());
		} else {
			return false;
		}
	}
	/**
	 * Lleva a la pag de login
	 */

	
	@RequestMapping(value = "/iniciarSesion", method = RequestMethod.GET)
	@Transactional
	public String iniciarsesion(Locale locale, Model model) {
		
		model.addAttribute("pageTitle", "Iniciar Sesión");
		return "iniciarSesion";
	}
	
	//TODO crear el pais despues de crear al usuario
	
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
	@Transactional
	public String nuevaCuenta(
			@RequestParam("nombre") String formNombre,
			@RequestParam("apellidos") String formApellidos,
			@RequestParam("correo") String formCorreo,
			@RequestParam("genero") String formGenero,
			@RequestParam("edad") String formEdad,
			@RequestParam("nick") String formNick,
			@RequestParam("contra") String formContra,
			@RequestParam("pais") String formPais,
			@RequestParam("lider") String formLider,
			@RequestParam("rol") String formRol,
<<<<<<< HEAD
			@RequestParam("source") String formSource,
			
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session){

			Pais p = null;
			if(formRol.isEmpty()){
				formRol = "UsuarioRegistrado";
			}		
			
		int edad = Integer.parseInt(formEdad);
		Usuario u = null;
	    
		boolean isLoggedIn = session.getAttribute("rol") != null;
		
		try {
			formRol = formRol.toLowerCase();
			if (formRol.equals("administrador") || formRol.equals("editor")) {
				// agujero gordo si !isAdmin pero especifica rol admin			
				
				Rol r = formRol.equals("editor") ? Rol.Editor : Rol.Administrador;
				u = new Usuario(formNombre, formApellidos, formCorreo, Genero.valueOf(formGenero), edad,
						formNick,p, TipoLider.valueOf(formLider),formContra,
						r);
			} else {
				System.out.println("entro aqui?");
=======
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session){

	
			if(formRol.isEmpty()){
				formRol = "UsuarioRegistrado";
			}
			System.out.println(formRol);
		
		
		
		int edad = Integer.parseInt(formEdad);
		Usuario u = null;
	    
		try {	
			//TODO cambiar los roles de la funciones 
			if(formRol.equalsIgnoreCase("Administrador")){
				u = new Usuario(formNombre, formApellidos, formCorreo, Genero.valueOf(formGenero), edad,
						formNick,null, TipoLider.valueOf(formLider),formContra,Rol.Administrador);
			}
			else if(formRol.equalsIgnoreCase("Editor")){
				u = new Usuario(formNombre, formApellidos, formCorreo, Genero.valueOf(formGenero), edad,
						formNick,null, TipoLider.valueOf(formLider),formContra,Rol.Editor);
			}
			else{
>>>>>>> origin/master
				Construcciones c= new Construcciones(" ");
				entityManager.persist(c);
				Recursos r = new Recursos();
				entityManager.persist(r);
<<<<<<< HEAD
				p = new Pais(c,formPais,r);
=======
				Pais p = new Pais(c,formPais,r);
>>>>>>> origin/master
				entityManager.persist(p);
				u = new Usuario(formNombre, formApellidos, formCorreo, Genero.valueOf(formGenero), edad,
						formNick,p, TipoLider.valueOf(formLider),formContra,Rol.Administrador);
			}
<<<<<<< HEAD
			
			entityManager.persist(u);
			//entityManager.flush(); // <- implicito al final de la transaccion
			
			String rol = u.getRol().toString();
			System.out.println(rol);
			if (!esAdministrador(session)){
				session.setAttribute("rol", u);
				getTokenForSession(session);
			} else{
				//String formSource = request.getParameter("formSource");
				return "redirect:" + formSource;
			}
	
		
=======
			entityManager.persist(u);
			//entityManager.flush(); // <- implicito al final de la transaccion
			System.out.println(u.getId());
			System.out.println(u.getNick());
			System.out.println(u.getRol());
			String rol = u.getRol().toString();
			//model.addAttribute(rol, u);
			session.setAttribute(rol, u);
			getTokenForSession(session);
			if(rol == "Editor"){
				return "redirect:" + "vistaAdminEditor";
			}
>>>>>>> origin/master
		} catch (ExceptionUsuario e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "home2";
		
	}
	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	@Transactional
	public String nuevaSesion(
			@RequestParam("nick") String formNick,
			@RequestParam("contra") String formContra,
			@RequestParam("source") String formSource,
			HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session){
		
		logger.info("Login attempt from '{}' while visiting '{}'", formNick, formSource);

		// validate request
		if (formNick == null || formContra == null|| formContra.length() < 6  ) {
			model.addAttribute("loginError", "Rellene el campo Nick \n Contraseña : 6 caracteres mínimo");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}  
		else{
		System.out.println(formNick);	
		Usuario u = new Usuario();
		//http://alejandroayala.solmedia.ec/?p=947 (Para que sirve el try catch)
		try{
			u = (Usuario)entityManager.createNamedQuery("usuarioByLogin").setParameter("loginParam", formNick).getSingleResult();
			System.out.println(u.getNick());
		} catch (NoResultException nre) {
		}
		return "home2";
		}
		return "home2";
	}
	@RequestMapping(value = "/eventosEditor", method = RequestMethod.GET)
   	public String eventosEditor(Locale locale, Model model, HttpSession session) {
       	//session.setAttribute("user", "juan");
	 session.setAttribute("test", "pedro");
   		return "eventosEditor";
   	}
	@RequestMapping(value = "/noticiasEditor", method = RequestMethod.GET)
   	public String noticiasEditor(Locale locale, Model model, HttpSession session) {
       	//session.setAttribute("user", "juan");
	 session.setAttribute("test", "pedro");
   		return "noticiasEditor";
   	}
	
	 @RequestMapping(value = "/crearCuenta", method = RequestMethod.GET)
	   	public String crearCuenta(Locale locale, Model model, HttpSession session) {
	   		return "crearCuenta";
	   	}
	 @RequestMapping(value = "/eventos", method = RequestMethod.GET)
	   	public String eventos(Locale locale, Model model, HttpSession session) {
	       	//session.setAttribute("user", "juan");
		 session.setAttribute("user", "pedro");
	   		return "eventos";
	   	}
	 @RequestMapping(value = "/guerras", method = RequestMethod.GET)
	   	public String guerras(Locale locale, Model model, HttpSession session) {
	       	//session.setAttribute("user", "juan");
		 session.setAttribute("user", "pedro");
	   		return "guerras";
	   	}
	 @RequestMapping(value = "/produccion", method = RequestMethod.GET)
	   	public String produccion(Locale locale, Model model, HttpSession session) {
	       	//session.setAttribute("user", "juan");
		 session.setAttribute("user", "pedro");
	   		return "produccion";
	   	}
	 @RequestMapping(value = "/ministerios", method = RequestMethod.GET)
	   	public String ministerios(Locale locale, Model model, HttpSession session) {
	       	//session.setAttribute("user", "juan");
		 session.setAttribute("user", "pedro");
	   		return "ministerios";
	   	}
	 @RequestMapping(value = "/cupulaDeGobierno", method = RequestMethod.GET)
	   	public String cupulaDeGobierno(Locale locale, Model model, HttpSession session) {
	       	//session.setAttribute("user", "juan");
		 session.setAttribute("user", "pedro");
	   		return "cupulaDeGobierno";
	   	}
	 @RequestMapping(value = "/mercado", method = RequestMethod.GET)
	   	public String mercado(Locale locale, Model model, HttpSession session) {
	       	//session.setAttribute("user", "juan");
		 session.setAttribute("user", "pedro");
	   		return "mercado";
	   	}
	 @RequestMapping(value = "/alianzas", method = RequestMethod.GET)
	   	public String alianzas(Locale locale, Model model, HttpSession session) {
	       	
		 session.setAttribute("user", "pedro");//session.setAttribute("user", "juan");
	   		return "alianzas";
	   	}
	 @RequestMapping(value = "/ranking", method = RequestMethod.GET)
		public String ranking(Locale locale, Model model, HttpSession session) {
		 session.setAttribute("user", "pedro");	
		 return "ranking";
		}
	    @RequestMapping(value = "/noticias", method = RequestMethod.GET)
	    
	   	public String noticias(Locale locale, Model model, HttpSession session) {
	       	session.setAttribute("user", "pedro");
	    	//model.addAttribute("anterior", session.getAttribute("user"));
	   		return "noticias";
	   	}
 
	    @RequestMapping(value = "/crearPolitico", method = RequestMethod.GET)
	   	public String crearPolitico(Locale locale, Model model, HttpSession session) {
<<<<<<< HEAD
=======
	       	//session.setAttribute("user", "pedro");
	    	//model.addAttribute("politicos", entityManager.createNamedQuery("allPoliticos").getResultList());

	    	//model.addAttribute("anterior", session.getAttribute("user"));
>>>>>>> origin/master
	   		return "crearPolitico";
	   	}
	    
	    @RequestMapping(value = "/crearPol", method = RequestMethod.POST)
	    @Transactional
		public String nuevoPolitico(
				@RequestParam("nombre") String formNombre,
				@RequestParam("cita") String formCita,
				@RequestParam("honestidad") String formHonestidad,
				@RequestParam("carisma") String formCarisma,
				@RequestParam("elocuencia") String formElocuencia,
				@RequestParam("popularidad") String formPopularidad,
				HttpServletRequest request, HttpServletResponse response, 
				Model model, HttpSession session) throws ExceptionPolitico{
	    	
			int honestidad = Integer.parseInt(formHonestidad);
			int carisma = Integer.parseInt(formCarisma);
			int elocuencia = Integer.parseInt(formElocuencia);
			int popularidad = Integer.parseInt(formPopularidad);
			System.out.println(honestidad);
			System.out.println(carisma);
			System.out.println(elocuencia);
			System.out.println(popularidad);
		    
			try {
				Politico p = new Politico(carisma,elocuencia,honestidad,formNombre, popularidad, formCita);
				entityManager.persist(p);
				entityManager.flush();
				return "redirect:" + "vistaAdminPoliticos";
<<<<<<< HEAD
			
=======
				
				/*model.addAttribute("politicos", entityManager.createNamedQuery("allPoliticos").getResultList());
				return "vistaAdminPoliticos";*/
				//entityManager.flush(); // <- implicito al final de la transaccion
				/*System.out.println(u.getId());
				System.out.println(u.getNick());
				System.out.println(u.getRol());
				session.setAttribute("Editor", u);*/
>>>>>>> origin/master
			} catch (ExceptionPolitico e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
<<<<<<< HEAD
		
=======
			
			
			//model.addAttribute("politicos", entityManager.createNamedQuery("allPoliticos").getResultList());
>>>>>>> origin/master
			return "redirect:" + "vistaAdminPoliticos";
			
		}
	    
	    
	/**
	 *Inicio sesion Admin
	 */
	@RequestMapping(value = "/vistaAdmin", method = RequestMethod.GET)
	public String vistaAdmin(Locale locale, Model model, HttpSession session) {
    	model.addAttribute("anterior", session.getAttribute("user"));
		model.addAttribute("admin", "pedro");
		return "home2";
	}
	/**
	 *Inicio sesion Editor
	 */
	@RequestMapping(value = "/vistaEditor", method = RequestMethod.GET)
	public String vistaEditor(Locale locale, Model model, HttpSession session) {
    	//model.addAttribute("anterior", session.getAttribute("user"));
		model.addAttribute("test", "pedro");
		return "home2";
	}
	/**
	 *Inicio sesion Jugador
	 */
	@RequestMapping(value = "/vistaJugador", method = RequestMethod.GET)
	public String vistaJugador(Locale locale, Model model, HttpSession session) {
    	//model.addAttribute("anterior", session.getAttribute("user"));
		model.addAttribute("user", "pedro");
		return "home2";
	}
	
	
	
	@RequestMapping(value = "/poli/{id}", method = RequestMethod.DELETE)
	@Transactional
	@ResponseBody
	public String rmPoli(@PathVariable("id") long id, HttpServletResponse response, Model model) {
		try {
			Politico b = entityManager.find(Politico.class, id);
			entityManager.remove(b);
<<<<<<< HEAD
			b = null;
			response.setStatus(HttpServletResponse.SC_OK);
=======
			response.setStatus(HttpServletResponse.SC_OK);
			//model.addAttribute("politicos", entityManager.createNamedQuery("allPoliticos").getResultList());
>>>>>>> origin/master
			return "OK";
		} catch (NoResultException nre) {
			logger.error("No existe ese politico: {}", id, nre);
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
<<<<<<< HEAD
			
			return "ERR";
		}
	}
	
	
	@RequestMapping(value = "/editor/{id}", method = RequestMethod.DELETE)
	@Transactional
	@ResponseBody
	public String rmEditor(@PathVariable("id") long id, HttpServletResponse response, Model model) {
		try {
			Usuario b = entityManager.find(Usuario.class, id);
			entityManager.remove(b);
			b = null;
			response.setStatus(HttpServletResponse.SC_OK);
			return "OK";
		} catch (NoResultException nre) {
			logger.error("No existe ese politico: {}", id, nre);
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			
			return "ERR";
		}
	}
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	@Transactional
	@ResponseBody
	public String rmUsuario(@PathVariable("id") long id, HttpServletResponse response, Model model) {
		try {
			Usuario b = entityManager.find(Usuario.class, id);
			entityManager.remove(b);
			b = null;
			response.setStatus(HttpServletResponse.SC_OK);
			return "OK";
		} catch (NoResultException nre) {
			logger.error("No existe ese politico: {}", id, nre);
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			
			return "ERR";
		}
	}
=======
			//model.addAttribute("politicos", entityManager.createNamedQuery("allPoliticos").getResultList());
			return "ERR";
		}
	}		
>>>>>>> origin/master
}

