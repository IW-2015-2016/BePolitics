<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<div id="divCentro">
	<div id="container">


		<table>
			<thead>
				<tr>
					<td><h2>C&uacute;pula de gobierno</h2></td>
					<td></td>
					<td><a class="linkHeader" href="#">Ir a ministerios</a></td>
				</tr>

			</thead>
			<tbody>
				<tr>
					<td>Nombre</td>
					<td>Honestidad</td>
					<td>Carisma</td>
					<td>Elocuencia</td>
					<td>Popularidad</td>
					<td>Cita semanal</td>
				</tr>
				<c:forEach items="${politicos}" var="b">
					<tr id="e_${b.id}">
						<td>${b.nombre}</td>
						<td><progress value="${b.honestidad }" max="100">${b.honestidad }%</progress></td>
						<td><progress value="${b.carisma }" max="100">${b.carisma }%</progress></td>
						<td><progress value="${b.elocuencia }" max="100">${b.elocuencia }%</progress></td>
						<td><progress value="${b.popularidad }" max="100">${b.popularidad }%</progress></td>
						<td><p>${b.cita}</p></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>



</div>
