<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

<script type="text/javascript">
$(function() {

	$("#nota-informativa")
		.delay(1000) // Tiempo del retraso en milisegundos antes de que aparezca el contenedor
		.show( "bounce", { times:3, distance:100, direction:'left' }, 2000 ); // Uso de .show, específicamente con bounce y algunos parámetros específicos de esta animación.
		/*.delay(12000) //Tiempo de duración del contenedor en la página
		.hide( "drop", { direction: "left" }, "slow" ); //Uso de .hide, con el efecto drop. */

	$( "#handler-puff" ).click(function() { // PUFF
	    $( "#puff" ).show( "puff", 1000 )
	                    .delay(2000)
	                    .hide( "puff", 1000 );                  
	})
})
 
</script> 

<div id="divCentro">	
	<div id="nuevo">
		<div id="titulo">
				<c:choose>
				<c:when test="${not empty rol}">
					<h1>Crear cuenta</h1>	  
				</c:when>
				<c:otherwise>
					<h1>Registrate</h1>
				</c:otherwise>
				</c:choose>
				
			
		</div>
		<div id="formNuevo">
			<!-- Formulario registro -->
		    <form action="${prefix}crearUsuario" method="POST">
		    	<input type="hidden" id="source" name="source" 
				value="${requestScope['javax.servlet.forward.servlet_path']}"/>
		    	<c:choose>
				<c:when test="${not empty rol}">
					<c:if test="${rol.rol eq 'Administrador'}">
						<div id="nota-informativa" >
							<p id="puff">Si va crear un usuario de tipo editor no es necesario rellenar los siquientes campos:</br>
		  		 				...Nombre país</br>
		  		 				...Tipo Líder
		  		 			</p>
						</div>
					
						<div class="nick-pass"><label>Tipo de usuario  </label></div>
						<div class="nick-pass">
							<input type="radio" name="rol" value="Editor" id="handler-puff"> Editor
							<input type="radio" name="rol" value="UsuarioRegistrado"> Jugador
						</div>
					</c:if>    
				</c:when>
				<c:otherwise>
					<input type="hidden" name="rol" value="">
				</c:otherwise>
				</c:choose>
		    	<div class="nick-pass"> <label> Nombre </label><input type="text" name="nombre"> </div>
			 	<div class="nick-pass"><label>Apellidos </label><input id="otracosa" type="text" name="apellidos"> </div>
			 	<div class="nick-pass"><label>Correo</label> <input type="email" name="correo"></div>
			 
				<div class="nick-pass"><label>G&eacute;nero  </label> </div>
			 	<div class="nick-pass">
			 	<input type="radio" name="genero" value="Mujer" checked> Mujer
			 	<input  type="radio" name="genero" value="Hombre"> Hombre </div>
		       	<div class="nick-pass"><label>Edad </label><input type="number" name="edad" min="18" max="65"></div>
		        <div class="nick-pass"><label>Nick</label> <input type="text" name="nick"></div>
		        <div class="nick-pass"><label>Contrase&ntilde;a</label> <input type="password" name="contra"></div>
		        <div class="nick-pass"><label>Nombre país</label> <input type="text" name="pais"></div>
		           	 
			 	<div class="nick-pass"><label>Tipo l&iacute;der  </label></div>
				<div class="nick-pass"><input type="radio" name="lider" value="PRESIDENTE" checked> Presidente
				<input type="radio" name="lider" value="REY"> Rey </div>  
				
				
		  		<div class="crea-cuenta"> 
		  		<input name="submit"  value="Crear cuenta" type="submit"> 	  
		  		<input type="reset">
		  		</div>
		  	</form>
	  	</div>
	  
	</div>	
</div>	
	<%@ include file="../fragments/footer.jsp" %>