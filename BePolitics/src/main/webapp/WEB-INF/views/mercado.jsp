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

	$(
			function() {

				$("button.ministryButtonDos")
						.click(
								function() {
									var id = $(this).attr("id").substring(
											"m_".length);
									var row = $("#m_" + id).parent();
									$
											.ajax({
												url : "${prefix}contratarPoli/"
														+ id,
												type : "GET",
												success : function(d) {
													console
															.log("ok - this worked");
													$("#e_" + id).remove();
												},
												error : function(d) {
													alert("No se puede contratar a este político (Revisa tu PIB)");
												}
											})
								});

			})
</script>

<div id="divCentro">
	<div id="titulo">
		<h1>Mercado de políticos</h1>
	</div>
	<c:forEach items="${politicos}" var="b">
		<div id="${b.id}" class="popup-position">

			<div id="popup-wrapper">
				<p>
					<a href="javascript:void(0)" onclick="toggle_visibility('${b.id}')"><i
						class="fa fa-times"></i></a>
				</p>
				<div id="popup-container">
					<div>
						<h3>${b.nombre}</h3>
					</div>
					<div>
						<h4>Cita: ${b.cita}</h4>
					</div>

					<table>
						<thead>
							<tr>
								<th></th>
								<th colspan="4">Stats</th>
							</tr>
							<tr>
	
								<th>Honestidad</th>
								<th>Carisma</th>
								<th>Elocuencia</th>
								<th>Popularidad</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><progress value="${b.honestidad}" max="100"></progress>
									<h6>${b.honestidad}%</h6></td>
								<td><progress value="${b.carisma}" max="100"></progress>
									<h6>${b.carisma}%</h6></td>
								<td><progress value="${b.elocuencia}" max="100"></progress>
									<h6>${b.elocuencia}%</h6></td>
								<td><progress value="${b.popularidad}" max="100"></progress>
									<h6>${b.popularidad}%</h6></td>
							<tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</c:forEach>


	<div id="listaEventos">
		<ul>

			<c:forEach items="${politicos}" var="b">
				<li class="evento" id="e_${b.id}"><i class="fa fa-btc"></i> <a
					href="javascript:void(0)" onclick="toggle_visibility('${b.id}')">
						${b.nombre} </a> <a href="javascript:void(0)"
					onclick="toggle_visibility('${b.id}')"> Coste: ${b.precio}
						PIB</a>
					<div class="contratar">
						<button class="ministryButtonDos" id="m_${b.id}">Contratar</button>
					</div></li>
			</c:forEach>


		</ul>

	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>
