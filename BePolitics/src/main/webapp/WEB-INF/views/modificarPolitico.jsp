<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<div id="divCentro">
	<div id="nuevo">
		<div id="titulo">
			<h1>Modificar Politico</h1>
		</div>
		<div id="formNuevo">
			<!-- Formulario registro -->
			<c:if test="${not empty politico}">
				<form action="${prefix}modificarPol" method="POST">
					<input type="hidden" id="source" name="source"
						value="${politico.id}" />
					<div class="nick-pass">
						<label> Nombre </label><input type="text" name="nombre"
							value="${politico.nombre}">
					</div>
					<div class="nick-pass">
						<label>Cita</label> <input type="text" name="cita"
							value="${politico.cita}">
					</div>
					<div class="nick-pass">
						<label>Precio</label><input type="number" name="precio"
							step="00.01" value="${politico.precio}">&euro;
					</div>
					<div class="nick-pass">
						<label>Honestidad</label><input type="number" name="honestidad"
							min="1" max="100" value="${politico.honestidad}">
					</div>
					<div class="nick-pass">
						<label>Carisma</label><input type="number" name="carisma" min="1"
							max="100" value="${politico.carisma}">
					</div>
					<div class="nick-pass">
						<label>Elocuencia</label><input type="number" name="elocuencia"
							min="1" max="100" value="${politico.elocuencia}">
					</div>
					<div class="nick-pass">
						<label>Popularidad</label><input type="number" name="popularidad"
							min="1" max="100" value="${politico.popularidad}">
					</div>

					<div class="crea-cuenta">
						<input name="submit" value="Modificar politico" type="submit">
						<input type="reset">
					</div>
				</form>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>
