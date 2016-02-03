<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>


<script type="text/javascript">
	$(function() {
		$("button.ministryButton").click(function() {
			var id = $(this).attr("id").substring("m_".length);
			var row = $("#m_" + id).parent();
			$.ajax({
				url : "${prefix}expulsar/" + id,
				type : "GET",
				success : function(d) {
					console.log("ok - this worked");
					$("#e_" + id).remove();
					location.href = "alianzas";
				}
			})
		});
		$("button.ministryButtonDos").click(function() {
			var id = $(this).attr("id").substring("i_".length);
			var row = $("#i_" + id).parent();
			$.ajax({
				url : "${prefix}invitar/" + id,
				type : "GET",
				success : function(i) {
					console.log("ok - this worked");
					$("#ot_" + id).remove();
					location.href = "alianzas";
				}
			})
// 			location.href = "${prefix}modificarPolitico/" + id;
		})
	})
</script>

<div id="divCentro">
	<div id="container">

		<input id="tab-1" type="radio" name="tab-group" checked="checked" />
		<label for="tab-1">Alianzas</label> <input id="tab-1" type="radio"
			name="tab-group" />


		<div id="content">


			<div id="arriba">
				<c:choose>
					<c:when test="${not empty miembros}">
						<table>
							<thead>
								<tr>
									<th><h1>Eres líder de esta comunidads</h1></th>
								</tr>
								<tr>

									<th>Pa&iacute;s</th>
									<th>Gestión</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${miembros}" var="b">
									<tr id="e_${b.id}">
										<td>${b.nombre}</td>
										<td><button class="ministryButton" id="m_${b.id}">Expulsar</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h4>No tiene miembros en su comunidad económica</h4>
					</c:otherwise>
				</c:choose>
			</div>



			<div id="abajo">
				<table>
					<thead>
						<tr>
							<h1>Otros Países</h1>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${otros}" var="o">
						<tr id="ot_${o.id}">
							<td>${o.nombre}</td>
							<td><button class="ministryButtonDos" id="i_${o.id}"> Invitar a la alianza</button></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>




			</div>




		</div>
	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>
