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


	<div id="${b.id}" class="popup-position">
		<div id="popup-wrapper">
			<p>
				<a href="javascript:void(0)"
					onclick="toggle_visibility('${b.id}')" class="fa fa-times">X</a>
			</p>
			<div id="popup-container">
				<table>

					<thead>
						<tr>
							<td><h2>Ministerio de Industria</h2></td>
							<td></td>
							<td><h2>Político alojado: Jose Mar&iacute;a Aznar</h2></td>
							<td><a class="linkHeader" href="#">despedir</a></td>
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
						<tr>
							<td>Jos&eacute; Mar&iacute;a Aznar</td>
							<td><progress value="11" max="100">11%</progress></td>
							<td><progress value="70" max="100">70%</progress></td>
							<td><progress value="39" max="100">39%</progress></td>
							<td><progress value="95" max="100">95%</progress></td>
							<td>"Estamos trabajando en ello"</td>
						<tr>
					</tbody>
				</table>

			</div>
		</div>

	</div>

	<div id="container">
		<div id="inferior">
			<table>
				<thead>
					<tr>
						<td><h3>Edificios</h3></td>
					
					</tr>
				</thead>

				<tbody>
					<c:forEach begin="0" end="7" varStatus="loop">
						<tr id="construccion${loop.index}">
							<td><h2>${construcciones.nombres[loop.index]}</h2></td>

						</tr>
						<tr>
							<c:choose>
								<c:when test="${b.politicoAlojado eq null}">
									<td>Sin pol&iacute;tico alojado</td>
								</c:when>
								<c:otherwise>
									<td><a class="ministryButton" href="#">${b.politicoAlojado.nombre}</a></td>
								</c:otherwise>
							</c:choose>
						</tr>

					<tr>
						<td><a href="javascript:void(0)"
							onclick="toggle_visibility('${b.id}')" class="ministryButton">VER
								EDIFICIO</a></td>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
						
					</tr>
				
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>



</div>
