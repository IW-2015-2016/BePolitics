<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">	
	<div id="nuevo">
		<div id="titulo">
			<h1>Crear Politico</h1>
		</div>
		<div id="formNuevo">
			<!-- Formulario registro -->
		    <form action="${prefix}crearPol" method="POST">
		    	<div class="nick-pass"> <label> Nombre </label><input type="text" name="nombre"> </div>
		        <div class="nick-pass"><label>Cita</label> <input type="text" name="cita"></div>
		        <div class="nick-pass"><label>Precio</label><input type="number" name="precio" step= "00.01">&euro;
		         </div>     
		      	<div class="nick-pass"><label>Honestidad</label><input type="number" name="honestidad" min="1" max="100"></div>     
		       	<div class="nick-pass"><label>Carisma</label><input type="number" name="carisma" min="1" max="100"></div>     
		       	<div class="nick-pass"><label>Elocuencia</label><input type="number" name="elocuencia" min="1" max="100"></div>     
		       	<div class="nick-pass"><label>Popularidad</label><input type="number" name="popularidad" min="1" max="100"></div>     

		  		<div class="crea-cuenta"> 
		  		<input name="submit"  value="Crear politico" type="submit"> 	  
		  		<input type="reset">
		  		</div>
		  	</form>
	  	</div>
	</div>	
</div>	
	<%@ include file="../fragments/footer.jsp" %>
