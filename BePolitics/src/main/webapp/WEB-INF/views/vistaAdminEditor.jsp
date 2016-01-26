<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	

<script type="text/javascript">
$(function() {
	$("button.ministryButton").click(function(){
		var id = $(this).attr("id").substring("d_".length); 
		var row = $("#d_"+id).parent();
		$.ajax({
			url: "${prefix}editor/"+id,
			url: "${prefix}poli/"+id,
			type: "DELETE",
			success: function(d) {
				console.log("ok - this worked");
				$("#e_"+id).remove();
			}
		})
	})	
})

</script>


<div id="divCentro">
	<div id="titulo">
		<h1>Gestión Editor</h1>
	</div>	

	<div id="Anadir">
		<a href="crearCuenta" class= "ministryButton">Añadir Editor</a>
	</div>	

<div id="listaEventos" >
<ul>
	<c:forEach items="${editores}" var="b">
		<li class="evento" id="e_${b.id}"> 
			${b.nombre}
			<div class="contratar"><button  class="ministryButton" id="d_${b.id}">Eliminar</button></div>
			<div class="contratar"><button  class= "ministryButton">Modificar</button></div>
			<div class="contratar"><a href="#" class= "ministryButton">Eliminar</a></div>
			<div class="contratar"><a href="#" class= "ministryButton">Modificar</a></div>
		</li>
	</c:forEach>
<!-- 	<li class="evento"> 
		Shrek
		<div class="contratar"><a href="#" class= "ministryButton">Eliminar</a></div>
		<div class="contratar"><a href="#" class= "ministryButton">Modificar</a></div>
	</li>
	<li class="evento"> 
		Aurora
		<div class="contratar"><a href="#" class= "ministryButton">Eliminar</a></div>
		<div class="contratar"><a href="#" class= "ministryButton">Modificar</a></div>
	
	</li> -->

</ul>

</div>
</div>
	<%@ include file="../fragments/footer.jsp" %>