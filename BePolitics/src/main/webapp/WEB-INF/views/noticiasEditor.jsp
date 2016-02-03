<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<script type="text/javascript">
	function toggle_visibility(id) {
		var e = document.getElementById(id);
		if (e.style.display == 'block')
			e.style.display = 'none';
		else
			e.style.display = 'block';
	}
	function mostrar_y_cargar(id) {
		toggle_visibility(id);

	}
	$(function() {
		$("button.ministryButtonUno").click(function() {
			var id = $(this).attr("id").substring("d_".length);
			var row = $("#d_" + id).parent();
			$.ajax({
				url : "${prefix}borraNoticia/" + id,
				type : "DELETE",
				success : function(d) {
					console.log("ok - this worked");
					$("#e_" + id).remove();
				}
			})
		});
		$("button.ministryButtonDos").click(function() {
			var id = $(this).attr("id").substring("m_".length);
			var row = $("#m_" + id).parent();
			$.ajax({
				url : "${prefix}noticias/" + id,
				type : "POST",
				data : "id=" + id,
				success : function(m) {
					console.log("ok - this worked");
					$.ajax({
						url : "${prefix}borraNoticia/" + id,
					})
				}
			})
		})
	})
</script>

<div id="divCentro">
	<div id="titulo">
		<h1>Noticias</h1>
	</div>

	<!-- POPUP DE CREACION DE NOTICIAS -->
	<div id="popup-box1" class="popup-position">
		<div id="popup-wrapper">
		<c:choose>
			<c:when
				test="${(rol.rol eq 'Administrador') or (rol.rol eq 'Editor')}">
				<form action="${prefix}crearNoticia" method="POST" id="formCreacion">
					<input type="hidden" id="source" name="source"
						value="${requestScope['javax.servlet.forward.servlet_path']}" />
					<div class="nick-pass2">
						<label> Titulo </label><input type="text" name="titulo">
					</div>
					<div class="nick-pass2">

						<label>Cuerpo</label>
						<textarea name="cuerpo" id="textoNoticia"></textarea>
					</div>
					<div class="crea-cuenta">
						<input name="submit" value="Crear Noticia" type="submit">
						<input type="reset">
					</div>
				</form>
				<a class="ministryButton" id="botonSalir" href="javascript:void(0)"
					onclick="toggle_visibility('popup-box1')">Salir</a>
			</c:when>
			<c:otherwise>
				<div id="sinPermisos">
					<h1>SIN PERMISOS</h1>
					<a class="ministryButton" id="botonSalir" href="javascript:void(0)"
						onclick="toggle_visibility('popup-box1')">Salir</a>
				</div>
			</c:otherwise>
		</c:choose>
		</div>
	</div>


	<!--  BOTON CREAR NOTICIA, modificar y busqueda-->
	<div id="listaEventos">
		<table>
			<tbody>
				<tr>
					<td><i class="ministryButton" href="javascript:void(0)"
						onclick="toggle_visibility('popup-box1')">Crear Noticia</i>
<!-- 					<td><input type="text" value="Introduce tu búsqueda"></td> -->
<!-- 					<td><a class="ministryButton">Buscar</a></td> -->
				</tr>
			</tbody>
		</table>


		<!-- LISTA DE NOTICIAS -->
		<ul>
			<c:forEach items="${noticias}" var="b">
				<li class="evento" id="e_${b.id}">${b.titulo}<c:choose>
						<c:when
							test="${(rol.rol eq 'Administrador') or (rol.rol eq 'Editor')}">
							<div class="contratar">
								<button class="ministryButtonUno" id="d_${b.id}">Eliminar</button>
							</div>
							<div class="contratar" href="javascript:void(0)"
								onclick="toggle_visibility('${b.id}2')">
								<i class="ministryButtonDos">Modificar</i>
							</div>
						</c:when>
						<c:otherwise>
							<div class="contratar" href="javascript:void(0)"
								onclick="alert('sin permisos')">
								<i class="ministryButtonDos">Eliminar</i>
							</div>
							<div class="contratar" href="javascript:void(0)"
								onclick="alert('sin permisos')">
								<i class="ministryButtonDos">Modificar</i>
							</div>
						</c:otherwise>
					</c:choose>
				</li>
				<!-- POPUP DE MODIFICACION DE NOTICIAS -->
				<div id="${b.id}2" class="popup-position">
				<div id="popup-wrapper">
					<c:choose>
						<c:when
							test="${(rol.rol eq 'Administrador') or (rol.rol eq 'Editor')}">
							<form action="${prefix}modificarNoticia" method="POST"
								id="${b.id}">
								<input type="hidden" id="id" name="id" value="${b.id}" />
								<div class="nick-pass2">
									<label>Titulo </label><input type="text" name="titulo"
										value="${b.titulo}">
								</div>
								<div class="nick-pass2">

									<label>Cuerpo</label>
									<textarea name="cuerpo" id="textoNoticia" placeholder="">${b.cuerpo}</textarea>
								</div>
								<div class="crea-cuenta">
									<input name="submit" value="Guardar cambios" type="submit">
									<!-- <input value="Borrar todo" type="reset"> -->
								</div>
							</form>
							<a class="ministryButton" id="botonSalir"
								href="javascript:void(0)"
								onclick="toggle_visibility('${b.id}2')">Salir</a>
						</c:when>
						<c:otherwise>
							<div id="sinPermisos">
								<a class="ministryButton" id="botonSalir"
									href="javascript:void(0)"
									onclick="toggle_visibility('popup-box1')">Salir</a>
							</div>
						</c:otherwise>
					</c:choose>
					</div>
				</div>
			</c:forEach>
		</ul>

	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>