<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">	
	<div id="nuevo">
		<div id="titulo">
			<h1>Registrate</h1>
		</div>
		<div id="formNuevo">
			<!-- Formulario registro -->
		    <form action="" method="POST">
		    	<div class="nick-pass"> <label> Nombre </label><input type="text" name="nombre"> </div>
			 	<div class="nick-pass"><label>Apellidos </label><input type="text" name="apellidos"> </div>
			 	<div class="nick-pass"><label>Correo</label> <input type="email" name="correo"></div>
			 
				<div class="nick-pass"><label>G&eacute;nero  </label> </div>
			 	<div class="nick-pass"><input type="radio" name="genero" value="mujer" checked> Mujer
			 	<input type="radio" name="genero" value="hombre"> Hombre </div>
		       	<div class="nick-pass"><label>Edad </label><input type="number" name="edad" min="18" max="65"></div>
		        <div class="nick-pass"><label>Nick</label> <input type="text" name="nick"></div>
		        <div class="nick-pass"><label>Contrase&ntilde;a</label> <input type="password" name="contra"></div>
		        <div class="nick-pass"><label>Nombre país</label> <input type="text" name="pais"></div>
		           	 
			 	<div class="nick-pass"><label>Tipo l&iacute;der  </label></div>
				<div class="nick-pass"><input type="radio" name="lider" value="presidente" checked> Presidente
				<input type="radio" name="lider" value="rey"> Rey </div>       
		  		<div class="crea-cuenta"> 
		  		<input type="submit">	  
		  		<input type="reset">
		  		</div>
		  	</form>
	  	</div>
	</div>	
</div>	
	<%@ include file="../fragments/footer.jsp" %>