<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<script type="text/javascript">

    function toggle_visibility(id) {
       var e = document.getElementById(id);
       if(e.style.display == 'block')
          e.style.display = 'none';
       else
          e.style.display = 'block';
    }
</script>




<div id="divCentro">


<div id="popup-box1" class ="popup-position">
	<div id="popup-wrapper">
	<p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')" class="fa fa-times">X</a></p>
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
						<td>Sin pol&iacute;tico alojado</td>
						<td><a class="ministryButton" href="#">Ignacio Wert</a></td>
						<td>Sin pol&iacute;tico alojado</td>
						<td><a class="ministryButton" href="#">Lu&iacute;s B&aacute;rcenas</a></td>
					</tr>
					<tr>
				
						<td><a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')" class="ministryButton">VER EDIFICIO</a></td>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
					</tr>
					<tr>
						<td><h2>Ministerio de Justicia</h2></td>
						<td><h2>Promotoras inmobiliarias</h2></td>
						<td><h2>Ministerio de sanidad</h2></td>
						<td><h2>Conferencia episcopal</h2></td>
					</tr>
					<tr>
						<td><a class="ministryButton" href="#">Pablo Iglesias</a></td>
						<td><a class="ministryButton" href="#">Mariano Rajoy</a></td>
						<td><a class="ministryButton" href="#">Ana Mato</a></td>
						<td><a class="ministryButton" href="#">Alberto Ru&iacute;z Gallard&oacute;n</a></td>
					</tr>
					<tr>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
						<td><a class="ministryButton" href="#">ver edificio</a></td>
					</tr>
				</tbody>
			
			</table>
		</div>
	</div>
	
	
	
</div>
	