<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group" checked="checked"/>
		<label for="tab-1">Pol&iacute;ticos</label>
		<input id="tab-2" type="radio" name="tab-group"/>
		
		<label for="tab-2">Pa&iacute;ses</label>
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
							<th>Dinamismo</th>
							<th>Corrupci&oacute;n</th>
							<th>Lealtad</th>
							<th>Eficacia</th>
							<th>Opini&oacute;n popular</th>
							<th>Formaci&oacute;n</th>
							
						</tr>	
					</thead>
					<tbody>
						<tr>
							<td>Zaz&uacute;</td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
							<td><progress value="22" max="100">22%</progress></td>
						<tr>
						<tr>
							<td>Reina Elsa</td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
							<td><progress value="33" max="100">33%</progress></td>
						<tr>
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
			
	
<%@ include file="../fragments/footer.jsp" %>