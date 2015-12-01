<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<script type="text/javascript">

</script>
<div id="divCentro">
<div id="titulo">
			<h1>Añadir Evento</h1>
</div>	
<div id="parteUno" class="addevento">
<input type="text" name="Nombre evento" value="Nombre evento">
<select name="Tipo">
<option>Único</option>
<option>Guerra</option>
<option>Comunidad</option>
</select>
<input type="button" class="editorBoton" value="Publicar">   
</div>
<div id="parteDos" class="addevento">
<h3>Descripcion</h3>
<textarea id="textarea1" rows="10"></textarea>
</div>
<div id="parteTres" class="addevento">
<div id="opUno" Class="opcion">

<input type="text" name="Nombre evento" value="Nombre Opción 1">
<h3>Modificadores</h3>
<table>
<tr>
<td><p>Modificador 1</p><input type="text" id="textEnvento"></td>
<td><p>Modificador 2</p><input type="text" id="textEnvento"></td>
<td><p>Modificador 3</p><input type="text" id="textEnvento"></td>
<td><p>Modificador 4</p><input type="text" id="textEnvento"></td>
</tr>
</table>
</div>
<div id="opDos" class="opcion">

<input type="text" name="Nombre evento" value="Nombre Opción 2">

<h3>Modificadores</h3>
<table>
<tr>
<td><p>Modificador 1</p><input type="text" id="textEnvento"></td>
<td><p>Modificador 2</p><input type="text" id="textEnvento"></td>
<td><p>Modificador 3</p><input type="text" id="textEnvento"></td>
<td><p>Modificador 4</p><input type="text" id="textEnvento"></td>
</tr>
</table>
</div>
<div id="parteCuatro" class="addevento">
<h3>Fecha de Activacion: </h3><input type="date" name="fecha">
</div>
</div>

</div>
<%@ include file="../fragments/footer.jsp" %>
