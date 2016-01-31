<%@ include file="../fragments/header.jsp"%>

<%@ include file="../fragments/menu.jsp"%>

<div id="divCentro">
	<div id="container">
		<div id="superior">


			<!-- CADA MINISTERIO -->
			<c:forEach begin="0" end="7" varStatus="loop">
				<table id="construccion${loop.index}">
					<!-- TITULO TABLA -->
					<thead>
						<tr>
							<td><h2>${construcciones.nombres[loop.index]}</h2></td>
							<td></td>
							<td><a class="linkHeader" href="#">Mejorar edificio</a></td>
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
					
					
					
						<c:forEach begin="0" end="4" varStatus="loop2">
							[${loop.index},${loop2.index}]
						</c:forEach>
			</c:forEach>
	
									<!--  -->
				<thead>
					<tr>
						<td><h2>Ministerio de industria</h2></td>
						<td></td>
						<!-- <td><h2>Político alojado: Jose Mar&iacute;a Aznar</h2></td> -->
						<td><a class="linkHeader" href="#">Mejorar edificio</a></td>
					</tr>

				</thead>
				<tbody>
					<tr>
						<td></td>
						<td>Produccion sin modificadores</td>

						<td>Modificadores</td>
						<td>Produccion final</td>
					</tr>
					<tr>
						<td>P.I.B. / D&iacute;a</td>
						<td>2000 d&iacute;a</td>
						<td>-7%(Pol&iacute;tico<br>-2%(guerras)<br>+12%(Evento
							comunidad)
						</td>
						<td>2060</td>
					
				<tr>
					
				<tr>
						<td>Bienestar / D&iacute;a</td>
						<td>1%</td>
						<td>Sin modificadores</td>
						<td>1%</td>
					
				<tr>
				
			</tbody>
			</table>
		</div>

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


		</div>
	</div>



</div>
<%@ include file="../fragments/footer.jsp"%>
