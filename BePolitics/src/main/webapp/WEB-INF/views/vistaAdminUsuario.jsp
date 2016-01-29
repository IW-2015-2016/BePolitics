<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>

<script type="text/javascript">
	$(function() {
		$("button.ministryButton").click(function() {
			var id = $(this).attr("id").substring("d_".length);
			var row = $("#d_" + id).parent();
			$.ajax({
				url : "${prefix}usuario/" + id,
				type : "DELETE",
				success : function(d) {
					console.log("ok - this worked");
					$("#e_" + id).remove();
				}
			})
		});
		$("button.ministryButtonDos").click(function(){
		var id = $(this).attr("id").substring("m_".length); 
		var row = $("#m_"+id).parent();
		location.href = "${prefix}modificarUsuario/"+id;
	})
	})
</script>



<div id="divCentro">
	<div id="titulo">
		<h1>Gestión Usuarios</h1>
	</div>

	<div id="Anadir">
		<a href="crearCuenta" class="ministryButton">Añadir usuario</a>
	</div>
	<div id="listaEventos">
		<ul>
			<c:forEach items="${usuarios}" var="b">
				<li class="evento" id="e_${b.id}">${b.nombre}
					<div class="contratar">
						<button class="ministryButton" id="d_${b.id}">Eliminar</button>
					</div>
					<div class="contratar">
						<button class="ministryButtonDos" id="m_${b.id}">Modificar</button>
					</div>
				</li>
			</c:forEach>

		</ul>
	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>
