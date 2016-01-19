<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">	
	<div id="nuevo">
		<div id="titulo">
			<h1>Registrate</h1>
		</div>
		<div id="formNuevo">
			<!-- Formulario registro -->
		    <form action="${prefix}crear" method="POST">
		    	<div class="nick-pass"> <label> Nombre </label><input type="text" name="nombre"> </div>
			 	<div class="nick-pass"><label>Apellidos </label><input type="text" name="apellidos"> </div>
			 	<div class="nick-pass"><label>Correo</label> <input type="email" name="correo"></div>
			 
				<div class="nick-pass"><label>G&eacute;nero  </label> </div>
			 	<div class="nick-pass"><input type="radio" name="genero" value="Mujer" checked> Mujer
			 	<input type="radio" name="genero" value="Hombre"> Hombre </div>
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