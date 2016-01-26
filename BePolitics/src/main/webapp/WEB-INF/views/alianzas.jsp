<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group" checked="checked"/>
		<!--<label for="tab-1">Pol&iacute;ticos</label>  -->
		<label for="tab-1">Alianzas</label>
		<input id="tab-1" type="radio" name="tab-group"/>
		
	
		<div id="content">
			<div id="arriba">

				<table>
					<thead>
						<tr>	
							<th><h1>Miembros</h1></th>
							<th><textarea>B&uacute;squeda</textarea></th>
							<th><a class="linkHeader" href="#"> Buscar  en la alianza</a></th>
							<th></th>

						</tr>
						<tr>
							<th>Usuario</th>
							<th>Pa&iacute;s</th>
							<th>Aliado desde</th>
							<th>Es l&iacute;der</th>
							<th>Gestión</th>
							
					
						</tr>	
					</thead>
					<tbody>
						<tr>
							<td>Princess_Fiona</td>
							<td>Far far away</td>
							<td>ayer</td>
							<td>No</td>
							<td><a class="ministryButton" href="#">Expulsar</a></td>
							
						<tr>
						<tr>
							<td>*-.VictorVonMuerte.-*</td>
							<td>Latveria</td>
							<td>12/10/04</td>
							<td>No</td>
							<td><a class="ministryButton" href="#">Expulsar</a></td>
						<tr>
						<tr>
							<td>Profet_Comstock22</td>
							<td>Columbia</td>
							<td>12/04/23</td>
							<td>S&iacute;</td>
							<td>No puedes expulsar al creador</td>
						<tr>
						<tr>
							<td>[USA]AndrewRyan03</td>
							<td>Rapture</td>
							<td>02/11/54</td>
							<td>S&iacute;</td>
							<td>S&oacute;lo el creador puede expulsar otros l&iacute;deres</td>
						<tr>
					</tbody>		
				</table>
			</div>
			<div id="abajo">
				<table>
					<thead>
						<tr><h1>Eres líder de esta comunidad</h1></tr>
					</thead>
					<tbody>
						<td>
						<textarea>B&uacute;squeda</textarea>
						</td>
						<td>
						<a class="linkHeader" href="#"> Invitar a la alianza</a>
						</td>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
	<%@ include file="../fragments/footer.jsp" %>