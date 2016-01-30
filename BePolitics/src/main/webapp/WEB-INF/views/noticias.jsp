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
</script>
<div id="divCentro">
	<div id="titulo">
		<h1>Noticias</h1>
	</div>
	<c:forEach items="${noticias}" var="b">
		<div id="${b.id}" class="popup-position">
			<div id="popup-wrapper">
				<p>
					<a href="javascript:void(0)" onclick="toggle_visibility('${b.id}')"><i
						class="fa fa-times"></i></a>
				</p>
				<div id="popup-container">
					<div>
						<h2>${b.titulo}</h2>
					</div>
					${b.cuerpo}
				</div>
			</div>
		</div>
	</c:forEach>

	<div id="listaEventos">
		<ul>
			<c:forEach items="${noticias}" var="b">
				<li class="evento"><i class="fa fa-newspaper-o"></i><a
					href="javascript:void(0)" onclick="toggle_visibility('${b.id}')">
						${b.titulo} <i class="fa fa-plus-circle"></i>
				</a></li>
			</c:forEach>

		</ul>
	</div>

</div>

<%@ include file="../fragments/footer.jsp"%>