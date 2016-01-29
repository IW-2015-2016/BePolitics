<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<script type="text/javascript">
$(function() {
	$("button.ministryButton").click(function(){
		var id = $(this).attr("id").substring("d_".length); 
		var row = $("#d_"+id).parent();
		$.ajax({
			url: "${prefix}even/"+id,
			type: "DELETE",
			success: function(d) {
				console.log("ok - this worked");
				$("#e_"+id).remove();
			}
		})
	});
	$("button.ministryButtonDos").click(function(){
		var id = $(this).attr("id").substring("m_".length); 
		var row = $("#m_"+id).parent();
		location.href = "${prefix}modificarEvento/"+id;
	})
})
</script>
<div id="divCentro">
	<div id="titulo">
		<h1>Gestión Eventos</h1>
	</div>
	<div  class="contratar">
		<a href="crearEvento" class= "ministryButton">Crear Evento</a>
	</div>	
	

<div id="listaEventos" >
<ul>
<c:forEach items="${eventos}" var="e">
<li class="evento"id="e_${e.id}"> 
		${e.titulo}
		<div class="contratar"><button  class="ministryButton" id="d_${e.id}">Eliminar</button></div>
		<div class="contratar"><button  class= "ministryButtonDos"id="m_${e.id}">Modificar</button></div>
</c:forEach>


</ul>

</div>
</div>
	<%@ include file="../fragments/footer.jsp" %>
