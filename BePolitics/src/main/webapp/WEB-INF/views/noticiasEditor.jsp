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
<div id="titulo">
            <h1>Noticias</h1>
</div>    
<div id="popup-box1" class ="popup-position">
    <div id="popup-wrapper">
     <p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')"><i class="fa fa-times"></i></a></p>
            <div id="popup-container">
            <div>
            <h4>Título</h4>
            <textarea class="titulo"><h2>Satanás afirma que Juega BePolitics</h2></textarea>
            <h4>Fecha</h4>
            <input type="date" name="fecha">
        	</div>    
            <h4>Noticia</h4>    
            <textarea class="texto">
			<p>Tras unas polémicas declaraciones en las que el señor de las tinieblas afirmaba que mirar fijamente a una cabra podría llevar al infierno según las leyes divinas, Satanás dedicó unos minutos a hablar de sus hobbies
			</p> 
			<p>
			Según una transcripción de la entrevista que tuvo en primicia la cadena que lo entrevistó, Satán decía: "Disfruto mucho metiendo a los sims en una piscina y quitando la escalera, pongo faltas de ortografía en foros y juego a BePolitics, al final los mejores actos de maldad son los cotidianos"                 
			</p>
			<p> No podemos esperar a la próxima aparición de tan controvertido y extravagante personaje</p>
			</textarea>
                
            </div>
            <div class="abajo">
                <a class="ministryButton">Modificar</a>
                <a class="ministryButton">Eliminar</a>
            </div>
    
    </div>

</div>
<div id="popup-box2" class ="popup-position">
    <div id="popup-wrapper">
    <p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box2')"><i class="fa fa-times"></i></a></p>
            <div id="popup-container">
<div>
            <h2>El cara a cara entre Scar y Mufasa será el 14 de diciembre en la Academia de la Televisión</h2>
        </div>
                <p>"Tengo las garras a punto"- Dice Scar tratando de amedrentar a su hermano</p>
                <p>
                El debate tendrá lugar en directo a través de una médium contratada expecialmente para la ocasión. Cada uno expondrá sus políticas y luego se abrirá una ronde de preguntas. "Van a estar como hienas para responder" Afirmaba Scar.  
                </p><p>
                La roca de la vida será el lugar del encuentro en que tendrá lugar el debate al tener cabida para todos los animales de la jungla. 
                </p>
                
                 </div>
    </div>

</div>
<div id="popup-box3" class ="popup-position">
    <div id="popup-wrapper">
    <p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box3')"><i class="fa fa-times"></i></a></p>
            <div id="popup-container">
            <div>
            <h2>Mariano Rajoy y Pablo iglesias se abrazan ante las cámaras</h2>
        </div>
                <p>Tras un emotivo vídeo de gatitos en directo, Mariano Rajoy y Pablo Iglesias se dieron un largo abrazo que ambos calificaron en directo como satisfactorio.</p>
                
                <p>"Aún huelo un poco fuerte y estoy lleno de pelo"- Declaraba el presidente unas horas después en twitter</p>
                <p>"La barba raspaba bastante, pero era como abrazar a un telettuby"- Añadió el secretario de Podemos cuando le preguntaron unas horas depués por la experiencia</p>
                
            </div>
    </div>

</div>

<div id="listaEventos" >
<table><tbody>
            <tr><td><input type="text" value="Introduce tu búsqueda"></td>
            <td><a class="ministryButton" >Buscar</a></td></tr>
            </tbody></table>
<ul>
    <li class="evento">
        <i class="fa fa-newspaper-o"></i>
        <a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')"> 
            Satanás afirma que Juega BePolitics 
            <i class="ministryButton">Modificar</i>
            <a class="ministryButton">Eliminar</a>
        </a>
    </li>
    <li class="evento">
        <i class="fa fa-newspaper-o"></i>
        <a href="javascript:void(0)" onclick="toggle_visibility('popup-box2')"> 
            El cara a cara entre Scar y Mufasa será el 14 de diciembre en la Academia de la Televisión 
            
            <i class="ministryButton">Modificar</i>
            <a class="ministryButton">Eliminar</a>
            
        </a>
    </li>
    <li class="evento"> 
        <i class="fa fa-newspaper-o"></i>
        <a href="javascript:void(0)" onclick="toggle_visibility('popup-box3')"> 
            Mariano Rajoy y Pablo iglesias se abrazan ante las cámaras 
            <i class="ministryButton">Modificar</i>
            <a class="ministryButton">Eliminar</a>
        </a>
    </li>
</ul>

</div>
</div>
    <%@ include file="../fragments/footer.jsp" %>