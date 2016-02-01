<%@ include file="../fragments/header.jsp"%>

<%@ include file="../fragments/menu.jsp"%>
<script type="text/javascript">
	function visitaUrl(id,edificio){
		alert("subeNivel/"+id+"/"+edificio);
		window.location = "subeNivel/"+id+"/"+edificio;
	}
	
</script>
<div id="divCentro">
	<div id="container">
		<div id="superior">


			<!-- CADA MINISTERIO -->

			<c:forEach begin="0" end="7" varStatus="loop">
				<div id="">
					<table id="construccion${loop.index}">
						<!-- TITULO TABLA -->
						<thead>
							<tr>
								<td><h2>${construcciones.nombres[loop.index]}</h2></td>
								<td><button class="ministryButtonUno" id="${rol.id}/${loop.index}" onclick="visitaUrl(${rol.id},${loop.index})">Mejorar edificio</button></td>
								<td><a class="linkHeader" href="subeNivel/${rol.id}/${loop.index}">Mejorar edificio</a></td>
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
								<td>${construcciones.coste[loop.index][1]}%</td>
								<td>${construcciones.produccion_hora[loop.index][1]}</td>
							<tr>
							<tr>
								<td>Energ&iacute;a</td>
								<td>${construcciones.coste[loop.index][2]}%</td>
								<td>${construcciones.produccion_hora[loop.index][2]}</td>
							<tr>
							<tr>
								<td>Poblaci&oacute;n</td>
								<td>${construcciones.coste[loop.index][3]}%</td>
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
		<!-- 
		<div id="inferior">
			<table>
				<thead>
					<tr>
						<td></td>
						<td><h3>Edificios</h3></td>
						<td></td>
						<td></td>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><h2>Ministerio de Industria</h2></td>
						<td><h2>Ministerio de educaci&oacute;n</h2></td>
						<td><h2>Bolsa de valores</h2></td>
						<td><h2>Ministerio de economia</h2></td>
					</tr>
					<tr>
						<td><a class="linkHeader" href="#">icono</a></td>
						<td><a class="linkHeader" href="#">icono</a></td>
						<td><a class="linkHeader" href="#">icono</a></td>
						<td><a class="linkHeader" href="#">icono</a></td>
					</tr>
					<tr>
						<td><h2>Ministerio de Justicia</h2></td>
						<td><h2>Promotoras inmobiliarias</h2></td>
						<td><h2>Ministerio de sanidad</h2></td>
						<td><h2>Conferencia episcopal</h2></td>
					</tr>
					<tr>
						<td><a class="linkHeader" href="#">icono</a></td>
						<td><a class="linkHeader" href="#">icono</a></td>
						<td><a class="linkHeader" href="#">icono</a></td>
						<td><a class="linkHeader" href="#">icono</a></td>
					</tr>
				</tbody>

			</table>


		</div>-->
	</div>



</div>
<%@ include file="../fragments/footer.jsp"%>