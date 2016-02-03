<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>



<script type="text/javascript">
	$(function() {
		$("button.ministryButton").click(function() {
			var id = $(this).attr("id").substring("r_".length);
			var row = $("#r_" + id).parent();
			$.ajax({
				url : "${prefix}rendirse/" + id,
				type : "GET",
				success : function(d) {
					console.log("ok - this worked");
					$("#re_" + id).remove();
					location.href = "guerras";

				}
			})
		});
		$("button.ministryButtonDos").click(function() {
			var id = $(this).attr("id").substring("i_".length);
			var row = $("#i_" + id).parent();
			$.ajax({
				url : "${prefix}guerra/" + id,
				type : "GET",
				success : function(i) {
					console.log("ok - this worked");
					$("#ot_" + id).remove();
					location.href = "guerras";

				}
			})
		})
	})
</script>









<div id="divCentro">
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group" checked="checked" />
		<!--<label for="tab-1">Pol&iacute;ticos</label>  -->
		<label for="tab-1">Guerras</label> <input id="tab-1" type="radio"
			name="tab-group" />


		<div id="content">


			<div id="arriba">
				<c:choose>
					<c:when test="${not empty misEnemigos}">
						<table>
							<thead>
								<tr>
									<th>Pa&iacute;s</th>
									<th>Eventos</th>
									<th>Eventos ganados</th>
									<th>Eventos empatados</th>
									<th>Duración</th>
									<th>Recursos perdidos</th>
									<th>Daño al enemigo</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${misEnemigos}" var="b">
								 <tr id="re_${b.id}" >
									<td>${b.nombre}</td>
									<td>15</td>
									<td>7</td>
									<td>1</td>
									<td>4 D&iacute;as</td>
									<td>-14.060 PIB<br> +3% Corr<br> -53% Pop
									</td>
									<td>-7.403 PIB<br> +12% Corr<br> -61% Pop
									</td>
									<td><button class="ministryButton" id="r_${b.id}">Rendirse</button></td>
									
								<tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
							<h4>Tu país esta en paz</h4>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div id="abajo">
				<table>
					<thead>
						<tr>
							<h1>Otros Países para entrar en Guerra</h1>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${enPaz}" var="o">
						<tr id="ot_${o.id}">
							<td>${o.nombre}</td>
							<td><button class="ministryButtonDos" id="i_${o.id}">Guerra</button></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			
			
			</div>
			
		</div>
	</div>
</div>


<%@ include file="../fragments/footer.jsp"%>