<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group" checked="checked"/>
		<!--<label for="tab-1">Pol&iacute;ticos</label>  -->
		<label for="tab-1">Guerras</label>
		<input id="tab-1" type="radio" name="tab-group"/>
		
	
		<div id="content">
			<div id="content-1">

				<table>
					<thead>
						<tr>	
							<th></th>
							<th><textarea>Búsqueda</textarea></th>
							<th><a class="linkHeader" href="#"> Buscar país para guerra</a></th>
							<th></th>
							<th></th>
						</tr>
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
						<tr>
							<td>Far far away</td>
							<td>15</td>
							<td>7</td>
							<td>1</td>
							<td>4 D&iacute;as</td>
							<td>-14.060 PIB<br> +3% Corr<br> -53% Pop</td>
							<td>-7.403 PIB<br> +12% Corr<br> -61% Pop</td>
							<td><a class="linkHeader" href="#"> Rendirse</a></td>
							
						<tr>
						<tr>
							<td>Latveria</td>
							<td>24</td>
							<td>20</td>
							<td>0</td>
							<td>15 D&iacute;as</td>
							<td>-32.060 PIB<br> +6% Corr<br> -11% Pop</td>
							<td>-6.403 PIB<br> +14% Corr<br> -88% Pop</td>
							<td><a class="linkHeader" href="#"> Rendirse</a></td>
							
						<tr>
					</tbody>		
				</table>
			</div>
		</div>
	</div>
</div>
			
	
<%@ include file="../fragments/footer.jsp" %>