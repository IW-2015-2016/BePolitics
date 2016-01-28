<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	

<script type="text/javascript">
$(function() {
	$("button.ministryButton").click(function(){
		var id = $(this).attr("id").substring("d_".length); 
		var row = $("#d_"+id).parent();
		$.ajax({
			url: "${prefix}poli/"+id,
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
		location.href = "${prefix}modificarPolitico/"+id;
	})
})

</script>

<div id="divCentro">
	<div id="titulo">
		<h1>Gesti�n Pol�ticos</h1>
	</div>	

<div id="listaEventos" >
<div class="contratar"><a href="crearPolitico" class= "ministryButton"> Crear Pol�tico</a></div>

<ul>
	<c:forEach items="${politicos}" var="b">
		<li class="evento" id="e_${b.id}"> 
			${b.nombre}
			<div class="contratar"><button  class="ministryButton" id="d_${b.id}">Eliminar</button></div>
			<div class="contratar"><button  class= "ministryButtonDos" id="m_${b.id}">Modificar</button></div>
		</li>
	</c:forEach>


</ul>

</div>
</div>
	<%@ include file="../fragments/footer.jsp" %>