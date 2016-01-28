<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<script type="text/javascript">
	
</script>
<div id="divCentro">
	<div id="titulo">
		<h1>Añadir Evento</h1>
	</div>
	<form action="${prefix}crearEven" method="POST">
		<div id="parteUno" class="addevento">
			<input type="text" name="nombreEvento" value="nombre evento">
			<select name="tipo">
				<option>GUERRA</option>
				<option>COMUNIDAD_ECONOMICA</option>
				<option>EVENTO_REGULAR</option>
			</select> <input name="submit" value="Publicar" type="submit"> <input
				type="reset">
		</div>
		<div id="parteDos" class="addevento">
			<h3>Descripcion</h3>
			<textarea type="text" name="descripcion" id="textarea1" rows="10"></textarea>
		</div>
		<div id="parteTres" class="addevento">
			<div id="opUno" Class="opcion">

				<input type="text" name="nombreOpcion1" value="Nombre Opción 1">
				<h3>Recurso 1</h3>
				<select name="tipoRecurso1">
					<option>PIB</option>
					<option>APOYO_POPULAR</option>
					<option>ENERGIA</option>
					<option>POBLACION</option>
				</select> 
				<label>Modificador </label><input type="number" name="modificador1" min="-100"
						max="100">
			</div>
			<div id="opDos" class="opcion">

				<input type="text" name="nombreOpcion2" value="Nombre Opción 2">

				<h3>Recurso 2</h3>
				<select name="tipoRecurso2">
					<option>PIB</option>
					<option>APOYO_POPULAR</option>
					<option>ENERGIA</option>
					<option>POBLACION</option>
				</select> 
				<label>Modificador </label><input type="number" name="modificador2" min="-100"
						max="100">
			</div>
			<div id="parteCuatro" class="addevento">
				<h3>Fecha de Activacion:</h3>
				<input type="date" name="fechaActivacion">
			</div>
		</div>
	</form>
</div>
<%@ include file="../fragments/footer.jsp"%>