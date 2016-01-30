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
					<td>Apoyo popular</td>
					<td>Cita semanal</td>
				</tr>
				<c:forEach items="${politicos}" var="b">
				<tr id="e_${b.id}">
					<td>${b.nombre}</td>
					<td><progress value="11" max="100">11%</progress></td>
					<td><progress value="70" max="100">70%</progress></td>
					<td><progress value="39" max="100">39%</progress></td>
					<td><progress value="95" max="100">95%</progress></td>
					<td>"Estamos trabajando en ello"</td>
				</tr>
</c:forEach>

			</tbody>
		</table>

	</div>



</div>
