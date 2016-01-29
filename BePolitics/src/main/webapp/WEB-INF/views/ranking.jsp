
<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<div id="divCentro">
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group" checked="checked" /> <label
			for="tab-1">Pol&iacute;ticos</label> <input id="tab-2" type="radio"
			name="tab-group" /> <label for="tab-2">Pa&iacute;ses</label>
		<div id="content">
			<div id="content-1">
				<table>
					<thead>
						<tr>
							<th>Nombre pol&iacute;tico</th>
							<th colspan="7">Stats</th>
						</tr>
						<tr>
							<th></th>

							<th>Honestidad</th>
							<th>Carisma</th>
							<th>Elocuencia</th>
							<th>Popularidad</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${politicos}" var="b">
							<tr>
								<td>${b.nombre}</td>
								<td><progress value="${b.honestidad}" max="100">${b.honestidad}%</progress></td>
								<td><progress value="${b.carisma}" max="100">${b.carisma}%</progress></td>
								<td><progress value="${b.elocuencia}" max="100">${b.elocuencia}%</progress></td>
								<td><progress value="${b.popularidad}" max="100">${b.popularidad}%</progress></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="content-2">

				<table>
					<thead>
						<tr>
							<th>Pa&iacute;s</th>
							<th colspan="5">Stats</th>
						</tr>
						<tr>
							<th></th>
							<th>Econom&iacute;a</th>
							<th>Defensa</th>
							<th>Poblaci&oacute;n</th>
							<th>Formaci&oacute;n militar</th>
							<th>Bienestar</th>


						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Far far away</td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
						<tr>
						<tr>
							<td>Latveria</td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
						<tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<%@ include file="../fragments/footer.jsp"%>

