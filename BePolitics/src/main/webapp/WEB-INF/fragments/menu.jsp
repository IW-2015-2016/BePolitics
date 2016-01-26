<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu">

	<c:choose>
	


	<c:when test="${not empty rol}">
	
	<c:choose>
		<c:when test="${rol.getRol() == 1}">
			<ul id="accordion" class="accordion">
				<li>
					<div class="link">
						<i class="fa fa-hand-peace-o"></i>
						Estado de la nación
						<i class="fa fa-chevron-down"></i>
					</div>
			
					<ul class="submenu">
						<li>
							<a href="eventos">Eventos</a>
						</li>
						<li>
							<a href="guerras">Guerras</a>
						</li>
						<li>
							<a href="produccion">Producción de recursos</a>
						</li>
					</ul>
			
				</li>
				<li>
					<div class="link">
						<i class="fa fa-university"></i>
						Infraestructuras
						<i class="fa fa-chevron-down"></i>
					</div>
			
					<ul class="submenu">
						<li>
							<a href="ministerios">Ministerios</a>
						</li>
			
					</ul>
			
				</li>
			
				<li>
					<div class="link">
						<i class="fa fa-users"></i>
						Equipo de gobierno
						<i class="fa fa-chevron-down"></i>
					</div>
			
					<ul class="submenu">
						<li>
							<a href="cupulaDeGobierno">Tú cúpula de gobierno</a>
						</li>
						<li>
							<a href="mercado">Mercado de ministros</a>
						</li>
					</ul>
			
				</li>
			
				<li>
					<div class="link">
						<i class="fa fa-industry"></i>
						Comunidad económica
						<i class="fa fa-chevron-down"></i>
					</div>
			
					<ul class="submenu">
						<li>
							<a href="alianzas">Alianzas</a>
						</li>
					</ul>
			
				</li>
			
			
				<li>
					<div class="link">
						<i class="fa fa-globe"></i>
						Global
						<i class="fa fa-chevron-down"></i>
					</div>
			
					<ul class="submenu">
						<li>
							<a href="ranking">Ranking</a>
						</li>
						<li>
							<a href="noticias">Noticias</a>
						</li>
						
					</ul>
			
				</li>
			</ul>
		</c:when>
		<c:when test="${rol.getRol() == 2}">">
					<ul id="accordion" class="accordion">
				<li>
					<div class="link">
						<i class="fa fa-users"></i>
						Gestionar usuarios BePolitics
						<i class="fa fa-chevron-down"></i>
					</div>
			
					<ul class="submenu">
						<li>
							<a href="vistaAdminEditor">Editores</a>
						</li>
						<li>
							<a href="vistaAdminUsuario">Jugadores</a>
						</li>
					</ul>
			
				</li>
				<li>
					<div class="link">
						<i class="fa fa-newspaper-o"></i>
						<a class = "anonimo" href="vistaAdminNoticias">Gestionar noticias</a>
					</div>	
				</li>
				<li>
					<div class="link">
						<i class="fa fa-bell"></i>
						<a class = "anonimo" href="vistaAdminEventos">Gestionar eventos</a>
					</div>	
				</li>
				<li>
					<div class="link">
						<i class="fa fa-btc"></i>
						<a class = "anonimo" href="vistaAdminPoliticos">Gestionar politicos</a>
					</div>	
				</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul id="accordion" class="accordion">
				<li>
					<div class="link">
						<i class="fa fa-bell"></i>
						<a class = "anonimo" href="eventosEditor">Gestionar eventos</a>
					</div>
					
				</li>
				<li>
				
					<div class="link">
						<i class="fa fa-newspaper-o"></i>
						<a class = "anonimo" href="noticiasEditor">Gestionar noticias</a>
					</div>
					
				</li>
				<li>
				
					<div class="link">
						<i class="fa fa-users"></i>
						<a class = "anonimo" href="vistaAdminPoliticos">Gestionar políticos</a>
					</div>
					
				</li>
			</ul>

		</c:otherwise>
	</c:choose>
	</c:when>
		<c:otherwise>
			<ul id="accordion" class="accordion">
				<li>
					<div class="link">
						<i class="fa fa-smile-o"></i>
						<a class = "anonimo" href="iniciarSesion">A jugar!</a>
					</div>
					
				</li>
				<li>
				
					<div class="link">
						<i class="fa fa-users"></i>
						<a class = "anonimo" href="crearCuenta">Únete!</a>
					</div>
					
				</li>
			</ul>
		</c:otherwise> 
	</c:choose>
	
</div>
	