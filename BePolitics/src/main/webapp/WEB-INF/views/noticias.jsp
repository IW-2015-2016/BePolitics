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
	<div id="titulo">
		<h1>Noticias</h1>
	</div>
	<div id="popup-box1" class="popup-position">
		<div id="popup-wrapper">
			<p>
				<a href="javascript:void(0)"
					onclick="toggle_visibility('popup-box1')"><i
					class="fa fa-times"></i></a>
			</p>
			<div id="popup-container">
				<div>
					<h2>Satanás afirma que Juega BePolitics</h2>
				</div>
				<p>Tras unas polémicas declaraciones en las que el señor de las
					tinieblas afirmaba que mirar fijamente a una cabra podría llevar al
					infierno según las leyes divinas, Satanás dedicó unos minutos a
					hablar de sus hobbies</p>
				<p>Según una transcripción de la entrevista que tuvo en primicia
					la cadena que lo entrevistó, Satán decía: "Disfruto mucho metiendo
					a los sims en una piscina y quitando la escalera, pongo faltas de
					ortografía en foros y juego a BePolitics, al final los mejores
					actos de maldad son los cotidianos"</p>
				<p>No podemos esperar a la próxima aparición de tan
					controvertido y extravagante personaje</p>

			</div>

		</div>
	</div>





	<!-- 
	<div id="popup-box2" class="popup-position">
		<div id="popup-wrapper">
			<p>
				<a href="javascript:void(0)"
					onclick="toggle_visibility('popup-box2')"><i
					class="fa fa-times"></i></a>
			</p>
			<div id="popup-container">
				<div>
					<h2>El cara a cara entre Scar y Mufasa será el 14 de diciembre
						en la Academia de la Televisión</h2>
				</div>
				<p>"Tengo las garras a punto"- Dice Scar tratando de amedrentar
					a su hermano</p>
				<p>El debate tendrá lugar en directo a través de una médium
					contratada expecialmente para la ocasión. Cada uno expondrá sus
					políticas y luego se abrirá una ronde de preguntas. "Van a estar
					como hienas para responder" Afirmaba Scar.</p>
				<p>La roca de la vida será el lugar del encuentro en que tendrá
					lugar el debate al tener cabida para todos los animales de la
					jungla.</p>

			</div>
		</div>-->

	<c:forEach items="${noticias}" var="b">
		<div id="${b.id}" class="popup-position">
			<div id="popup-wrapper">
				<p>
					<a href="javascript:void(0)" onclick="toggle_visibility('${b.id}')"><i
						class="fa fa-times"></i></a>
				</p>
				<div id="popup-container">
					<div>
						<h2>${b.titulo}</h2>
					</div>
					<div>${b.cuerpo}</div>
				</div>
			</div>
		</div>

	</c:forEach>

</div>






<!--
	<div id="popup-box3" class="popup-position">
		<div id="popup-wrapper">
			<p>
				<a href="javascript:void(0)"
					onclick="toggle_visibility('popup-box3')"><i
					class="fa fa-times"></i></a>
			</p>
			<div id="popup-container">
				<div>
					<h2>Mariano Rajoy y Pablo iglesias se abrazan ante las cámaras</h2>
				</div>
				<p>Tras un emotivo vídeo de gatitos en directo, Mariano Rajoy y
					Pablo Iglesias se dieron un largo abrazo que ambos calificaron en
					directo como satisfactorio.</p>

				<p>"Aún huelo un poco fuerte y estoy lleno de pelo"- Declaraba
					el presidente unas horas después en twitter</p>
				<p>"La barba raspaba bastante, pero era como abrazar a un
					telettuby"- Añadió el secretario de Podemos cuando le preguntaron
					unas horas depués por la experiencia</p>

			</div>
		</div>

	</div>-->

<div id="listaEventos">
	<ul>
		<c:forEach items="${noticias}" var="b">
			<div id="popup-box" class="popup-position">
				<div id="popup-wrapper">
					<p>
						<a href="javascript:void(0)"
							onclick="toggle_visibility('popup-box2')"><i
							class="fa fa-times"></i></a>
					</p>
					<div id="popup-container" class="${b.id}">
						<div>
							<h2>${b.titulo}</h2>
						</div>
						<div>${b.cuerpo}</div>
					</div>
				</div>
			</div>

			<li class="evento"><i class="fa fa-newspaper-o"></i><a
				href="javascript:void(0)" onclick="toggle_visibility('${b.titulo}')">
					${b.titulo} <i class="fa fa-plus-circle"></i>
			</a></li>
			
		</c:forEach>
		
		
		
		<!-- 
		<li class="evento"><i class="fa fa-newspaper-o"></i><a
			href="javascript:void(0)" onclick="toggle_visibility('popup-box1')">
				Satanás afirma que Juega BePolitics <i class="fa fa-plus-circle"></i>
		</a></li>
		<li class="evento"><i class="fa fa-newspaper-o"></i><a
			href="javascript:void(0)" onclick="toggle_visibility('popup-box2')">
				El cara a cara entre Scar y Mufasa será el 14 de diciembre en la
				Academia de la Televisión <i class="fa fa-plus-circle"></i>
		</a></li>
		<li class="evento"><i class="fa fa-newspaper-o"></i><a
			href="javascript:void(0)" onclick="toggle_visibility('popup-box3')">
				Mariano Rajoy y Pablo iglesias se abrazan ante las cámaras <i
				class="fa fa-plus-circle"></i>
		</a></li> -->
	</ul>

</div>
</div>
<%@ include file="../fragments/footer.jsp"%>







<!-- 
    

<script type="text/javascript">
	function toggle_visibility(id) {
		var e = document.getElementById(id);
		if (e.style.display == 'block')
			e.style.display = 'none';
		else
			e.style.display = 'block';
	}

	function mostrar_y_cargar(id){
		toggle_visibility(id);
		
	}
	$(function() {
		$("button.ministryButtonUno").click(function(){
			var id = $(this).attr("id").substring("d_".length); 
			var row = $("#d_"+id).parent();
			$.ajax({
				url: "${prefix}borraNoticia/"+id,
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
			$.ajax({
				url: "${prefix}noticias/"+id,
				type: "POST",
				data: "id=" + id ,
				success: function(m) {
					console.log("ok - this worked");
					$.ajax({
						url: "${prefix}borraNoticia/"+ID,

					})
				} 
			})
		})
	})
</script>
<div id="divCentro">
	<div id="titulo">
		<h1>Noticias</h1>
	</div>
	

	<div id="popup-box1" class="popup-position">
		<c:choose>
			<c:when
				test="${(rol.rol eq 'Administrador') or (rol.rol eq 'Editor')}">
				<form action="${prefix}crearNoticia" method="POST" id="formCreacion">
					<input type="hidden" id="source" name="source"
						value="${requestScope['javax.servlet.forward.servlet_path']}" />
					<div class="nick-pass2">
						<label> Titulo </label><input type="text" name="titulo">
					</div>
					<div class="nick-pass2">

						<label>Cuerpo</label>
						<textarea name="cuerpo" id="textoNoticia"></textarea>
					</div>
					<div class="crea-cuenta">
						<input name="submit" value="Crear Noticia" type="submit">
						<input type="reset">
					</div>
				</form>
				<a class="ministryButton" id="botonSalir" href="javascript:void(0)"
					onclick="toggle_visibility('popup-box1')">Salir</a>
			</c:when>
			<c:otherwise>
				<div id="sinPermisos">
					<a class="ministryButton" id="botonSalir" href="javascript:void(0)"
						onclick="toggle_visibility('popup-box1')">Salir</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	

	<div id="listaEventos">
		<table>
			<tbody>
				<tr>
					<td><i class="ministryButton" href="javascript:void(0)"
						onclick="toggle_visibility('popup-box1')">Crear Noticia</i> 
						
					<td><input type="text" value="Introduce tu búsqueda"></td>
					<td><a class="ministryButton">Buscar</a></td>
				</tr>
			</tbody>
		</table>

				
		
		<ul>
			<c:forEach items="${noticias}" var="b">
				<li class="evento" id="e_${b.id}">${b.titulo}
					<div class="contratar">
						<button class="ministryButtonUno" id="d_${b.id}">Eliminar</button>
					</div>
					<div class="contratar" href="javascript:void(0)" 
							onclick="toggle_visibility('${b.id}2')">
						<i class="ministryButtonDos">Modificar</i>
					</div>
				</li>
		
				<div id="${b.id}2" class="popup-position">
					<c:choose>
						<c:when
							test="${(rol.rol eq 'Administrador') or (rol.rol eq 'Editor')}">
							<form action="${prefix}modificarNoticia" method="POST"
								id="${b.id}">
								<input type="hidden" id="id" name="id"
									value="${b.id}" />
								<div class="nick-pass2">
									<label>Titulo </label><input type="text" name="titulo"
										value="${b.titulo}">
								</div>
								<div class="nick-pass2">

									<label>Cuerpo</label>
									<textarea name="cuerpo" id="textoNoticia"
										placeholder="">${b.cuerpo}</textarea>
								</div>
								<div class="crea-cuenta">
									<input name="submit" value="Guardar cambios" type="submit">
								</div>
							</form>
							<a class="ministryButton" id="botonSalir"
								href="javascript:void(0)"
								onclick="toggle_visibility('${b.id}2')">Salir</a>
						</c:when>
						<c:otherwise>
							<div id="sinPermisos">
								<a class="ministryButton" id="botonSalir"
									href="javascript:void(0)"
									onclick="toggle_visibility('popup-box1')">Salir</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>

		</ul>

	</div>
</div>
     -->