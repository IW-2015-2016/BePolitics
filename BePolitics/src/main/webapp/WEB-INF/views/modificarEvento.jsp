<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<script type="text/javascript">
	
</script>
<div id="divCentro">
	<div id="titulo">
		<h1>Modificar Evento</h1>
	</div>
	<c:if test="${not empty evento}">
	<form action="${prefix}modificarEven" method="POST">
					<input type="hidden" id="source" name="source"
						value="${evento.id}" />
		<div id="parteUno" class="addevento">
				<label> Nombre </label><input type="text" name="nombreEvento" value="${evento.titulo}">
						<label> Tipo Evento Antiguo: ${evento.tipoEvento} </label>
			<select name="tipo">
				<option>GUERRA</option>
				<option>COMUNIDAD_ECONOMICA</option>
				<option>EVENTO_REGULAR</option>
			</select> 
			<input name="submit" value="Publicar" type="submit"> <input
				type="reset">
		</div>
		<div id="parteDos" class="addevento">
			<label> Descripcion Antigua: ${evento.descripcion} </label>
			<h3>Descripcion Nueva</h3>
			<textarea name="descripcion" id="textarea1"  rows="10"></textarea>
			
		</div>
		<div id="parteTres" class="addevento">
			<div id="opUno" Class="opcion">
				<h3>Opcion uno</h3><input type="text" name="nombreOpcion1" value="${evento.opcion1}">
				<h3>Recurso 1</h3> <label>Antiguo: ${evento.rec1} </label>
				<select name="tipoRecurso1">
					<option>PIB</option>
					<option>APOYO_POPULAR</option>
					<option>ENERGIA</option>
					<option>POBLACION</option>
				</select> 
				<label>Modificador </label><input type="number" name="modificador1" value="${evento.porcentaje1}" min="-100"
						max="100">
			</div>
			<div id="opDos" class="opcion">
				<h3>Opcion uno</h3><input type="text" name="nombreOpcion2" value="${evento.opcion2}">
				<h3>Recurso 2</h3> <label>Antiguo: ${evento.rec2} </label>
				<select name="tipoRecurso2">
					<option>PIB</option>
					<option>APOYO_POPULAR</option>
					<option>ENERGIA</option>
					<option>POBLACION</option>
				</select> 
				<label>Modificador </label><input type="number" name="modificador2" value="${evento.porcentaje2}" min="-100"
						max="100">
			</div>
			<div id="parteCuatro" class="addevento">
				<h3>Fecha de Activacion:</h3>
				<input type="date" name="fechaActivacion" value="${evento.fecha}">
			</div>
		</div>
	</form>
	</c:if>
</div>
<%@ include file="../fragments/footer.jsp"%>