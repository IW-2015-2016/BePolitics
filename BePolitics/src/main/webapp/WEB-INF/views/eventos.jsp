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

	$(function() {

		$("button.ministryButton").click(function() {
			var id = $(this).attr("id").substring("e_".length);
			var row = $("#e_" + id).parent();
			$.ajax({
				url : "${prefix}opcionUno/" + id,
				type : "GET",
				success : function(d) {
					console.log("ok - this worked");
					$("#e_" + id).remove();
				},
				error : function(d) {
					alert("");
				}
			})
		});

	})
</script>
<div id="divCentro">
	<div id="titulo">
		<h1>Eventos</h1>
	</div>

	<c:forEach items="${eventos}" var="ev">
			<div id="${ev.id}" class="popup-position">
				<div id="popup-wrapper">
					<p>
						<a href="javascript:void(0)"
							onclick="toggle_visibility('${ev.id}')"><i
							class="fa fa-times"></i></a>
					</p>
					<div id="popup-container">
						<div>
							<h2>${ev.titulo }</h2>
						</div>
						<p>${ev.descripcion }</p>
						<div class="popup-botones">
						<a class="linkHeader"
                  href="${prefix}opcionUno/${ev.id}">${ev.opcion1 }</a>
				<a class="linkHeader"
                  href="${prefix}/opcionDos/${ev.id}">${ev.opcion2 }</a>
							<button class="ministryButton" id="e_${ev.id}">${ev.opcion1 }</button>
							<button class="ministryButtonDos" id="e_${ev.id}">${ev.opcion2 }</button>
						</div>
					</div>

				</div>

			</div>
		
	</c:forEach>


	<div id="listaEventos">
		<ul>
		<c:forEach items="${eventos}" var="ev">
			<li class="evento"><i class="fa fa-bell"></i><a
				href="javascript:void(0)" onclick="toggle_visibility('${ev.id}')">
					${ev.titulo}<i
					class="fa fa-plus-circle"></i>
			</a></li>
		</c:forEach>
		</ul>

	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>
