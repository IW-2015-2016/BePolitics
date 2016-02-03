<%@ include file="../fragments/header.jsp"%>

<%@ include file="../fragments/menu.jsp"%>
<script type="text/javascript">
	function visitaUrl(id, edificio) {
		alert("subeNivel/" + id + "/" + edificio);
		window.location = "subeNivel/" + id + "/" + edificio;
	}
</script>
<div id="divCentro">
	<div id="container" class="auxProduccion">
		<div id="superior">
			<!-- CADA MINISTERIO -->
			<table>
				<tr style="border: 1px solid black;">
					<td>
						<h3>Tus recursos</h3>
					</td>
					<td></td>
				</tr>
				<tr>
					<td style="border: 1px solid black;">PIB:${recursos.resources[0]}</td>
					<td style="border: 1px solid black;">Apoyo
						popular:${recursos.resources[1]}</td>
					<td style="border: 1px solid black;">Energ&iacute;a:${recursos.resources[2]}</td>
					<td style="border: 1px solid black;">Poblaci&oacute;n:${recursos.resources[3]}</td>
					<td style="border: 1px solid black;"><a class="linkHeader"
									href="${prefix}/producir/">Producir</a></td>
				</tr>
			</table>
			<c:forEach begin="0" end="7" varStatus="loop">
				<div id="">
					<table id="construccion${loop.index}">
						<!-- TITULO TABLA -->
						<thead>
							<!--  <form action="./subeNivel/${rol.id}/${loop.index}" method="POST"><input name="submit" value="Sube nivel" type="submit"></form> -->
							<tr>
								<td><h2>${construcciones.nombres[loop.index]}</h2></td>
								<td></td>
								<td><a class="linkHeader"
									href="${prefix}/subeNivel/${rol.id}/${loop.index}">Mejorar
										edificio</a></td>
							</tr>
						</thead>
						<!-- CUERPO DE LA TABLA -->
						<tbody>
							<tr>
								<td>Tipo</td>
								<td>Coste de mejora</td>
								<td>Producci&oacute;n</td>
							</tr>
							<tr>
								<td>P.I.B.</td>
								<td>${construcciones.coste[loop.index][0]}</td>
								<td>${construcciones.produccion_hora[loop.index][0]}</td>
							<tr>
							<tr>
								<td>Apoyo popular</td>
								<td>${construcciones.coste[loop.index][1]}</td>
								<td>${construcciones.produccion_hora[loop.index][1]}</td>
							<tr>
							<tr>
								<td>Energ&iacute;a</td>
								<td>${construcciones.coste[loop.index][2]}</td>
								<td>${construcciones.produccion_hora[loop.index][2]}</td>
							<tr>
							<tr>
								<td>Poblaci&oacute;n</td>
								<td>${construcciones.coste[loop.index][3]}</td>
								<td>${construcciones.produccion_hora[loop.index][3]}</td>
								<td>Nivel del edificio: ${construcciones.nivel[loop.index]}</td>
							<tr>
						</tbody>

					</table>
				</div>
			</c:forEach>
			<!-- 
						<c:forEach begin="0" end="4" varStatus="loop2">
							[${loop.index},${loop2.index}]
						</c:forEach>						
						 -->
		</div>

	</div>



</div>
<!-- 
    <%@ include file="../fragments/footer.jsp"%>
 -->