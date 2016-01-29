<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

<script type="text/javascript">
	$(function() {

		$("#nota-informativa").delay(1000) // Tiempo del retraso en milisegundos antes de que aparezca el contenedor
		.show("bounce", {
			times : 3,
			distance : 100,
			direction : 'left'
		}, 2000); // Uso de .show, específicamente con bounce y algunos parámetros específicos de esta animación.
		/*.delay(12000) //Tiempo de duración del contenedor en la página
		.hide( "drop", { direction: "left" }, "slow" ); //Uso de .hide, con el efecto drop. */

		$("#handler-puff").click(function() { // PUFF
			$("#puff").show("puff", 1000);
			/*  .delay(2000)
			 .hide( "puff", 1000 );   */
		})
	})
</script>

<div id="divCentro">
	<div id="nuevo">
		<div id="titulo">
			<h1>Modificar Usuario</h1>
		</div>
		<div id="formNuevo">
			<!-- Formulario registro -->
			<c:if test="${not empty usuario}">
				<form action="${prefix}modificarUsu" method="POST">
				
					<input type="hidden" name="id" value="${usuario.id}"/>
						
					<div class="nick-pass">
						<label> Nombre </label><input type="text" name="nombre"
							value="${usuario.nombre}" />
					</div>
					<div class="nick-pass">
						<label>Apellidos </label><input id="otracosa" type="text"
							name="apellidos" value="${usuario.apellidos}">
					</div>
					<div class="nick-pass">
						<label>Correo</label> <input type="email" name="correo"
							value="${usuario.email}">
					</div>
					<div class="nick-pass">
						<label>G&eacute;nero </label>
					</div>
					<c:choose>
						<c:when test="${usuario.genero eq 'Mujer'}">
							<div class="nick-pass">
								<input type="radio" name="genero" value="Mujer" checked>
								Mujer <input type="radio" name="genero" value="Hombre">
								Hombre
							</div>
						</c:when>
						<c:otherwise>
							<div class="nick-pass">
								<input type="radio" name="genero" value="Mujer"> Mujer
								<input type="radio" name="genero" value="Hombre" checked>
								Hombre
							</div>
						</c:otherwise>
					</c:choose>
					<div class="nick-pass">
						<label>Edad </label><input type="number" name="edad" min="18"
							max="100" value="${usuario.edad}">
					</div>
					<div class="nick-pass">
						<label>Nick</label> <input type="text" name="nick"
							value="${usuario.nick}">
					</div>
					<div class="nick-pass">
						<label>Contrase&ntilde;a</label> <input type="password"
							name="contra">
					</div>
					<div class="nick-pass">
						<label>Nombre país</label> <input type="text" name="pais"
							value="${usuario.pais.getNombre()}">
					</div>
					<div class="nick-pass">
						<label>Tipo l&iacute;der </label>
					</div>
					<c:choose>
						<c:when test="${usuario.tipoLider eq 'PRESIDENTE'}">
							<div class="nick-pass">
								<input type="radio" name="lider" value="PRESIDENTE" checked>
								Presidente <input type="radio" name="lider" value="REY">
								Rey
							</div>
						</c:when>
						<c:otherwise>
							<div class="nick-pass">
								<input type="radio" name="lider" value="PRESIDENTE">
								Presidente <input type="radio" name="lider" value="REY" checked>
								Rey
							</div>
						</c:otherwise>
					</c:choose>
					<div class="crea-cuenta">
						<input name="submit" value="Modificar usuario" type="submit">
						<input type="reset">
					</div>
				</form>
			</c:if>
		</div>

	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>