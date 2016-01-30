<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>


<script type="text/javascript">
	$(function() {
		$(".linkHeader").click(function() {
			// en un manejador de eventos jquery, el "this" inicial es el elemento DOM sobre el que se lanza el evento
			// por tanto, $(this) es el elemento JQuery que lo envuelve 
			var target = $(this);
			// el id del libro cuyos autores buscamos
			var id = $(this).attr("id").substring("b_".length);
			$.ajax({
				dataType : "json",
				url : "${prefix}bookAuthors",
				type : "POST",
				data : "id=" + id,
				success : function(d) {
					refreshAuthors(target, d);
				}
			})
		})
	})
	function refreshAuthors(target, authorData) {
		// 'authorData' contiene un array de objetos
		// ejemplo: [ {id : "1", familyName: "Adams", lastName: "Adam"} ]
		var list = $("<ul>"); // creo una lista HTML, todavia no insertada en el documento
		console.log(authorData);
		// llama a la funcion con i=indice y o=objeto para cada elemento del array authorData
		console.log(authorData);
		$.each(authorData, function(i, o) {
			var li = $("<li>");
			li.append(authorToLink(o));
			list.append(li)
		})
		target.replaceWith(list); // reemplazo el boton por la lista
	}

	function authorToLink(author) {
		return $("<a href='${prefix}author/" + author.id + "'>"
				+ author.familyName + ", " + author.lastName + "</a>");
	}
</script>
<div id="divCentro">
	<div id="container">

		<input id="tab-1" type="radio" name="tab-group" checked="checked" />
		<label for="tab-1">Alianzas</label> <input id="tab-1" type="radio"
			name="tab-group" />


		<div id="content">


			<div id="arriba">
				<table>
					<thead>
						<tr>
							<th><h1>Miembros</h1></th>
						</tr>
						<tr>
							
							<th>Pa&iacute;s</th>
							<th>Gestión</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${com.paises}" var="r">
							<tr>
								<td>${r.nombre}</td>
								<td><a class="ministryButton" href="#">Expulsar</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>



			<div id="abajo">


				<%-- 				<table>
					<thead>
						<tr>
							<h1>Eres líder de esta comunidad</h1>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><textarea>B&uacute;squeda</textarea></td>
						<tr>
							<td>authors</td>
							<td><button id="b_${book.id}" class="pideAutores">Ver
									autores</button></td>
						</tr>
						<td>
							<button class="linkHeader">Invitar a la alianza</button>
						</td>
						</tr>
					</tbody>
				</table> --%>




			</div>




		</div>
	</div>
</div>
<%@ include file="../fragments/footer.jsp"%>
