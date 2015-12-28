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
            <h4>T�tulo</h4>
            <textarea class="titulo"><h2>Satan�s afirma que Juega BePolitics</h2></textarea>
            <h4>Fecha</h4>
            <input type="date" name="fecha">
        	</div>    
            <h4>Noticia</h4>    
            <textarea class="texto">
			<p>Tras unas pol�micas declaraciones en las que el se�or de las tinieblas afirmaba que mirar fijamente a una cabra podr�a llevar al infierno seg�n las leyes divinas, Satan�s dedic� unos minutos a hablar de sus hobbies
			</p> 
			<p>
			Seg�n una transcripci�n de la entrevista que tuvo en primicia la cadena que lo entrevist�, Sat�n dec�a: "Disfruto mucho metiendo a los sims en una piscina y quitando la escalera, pongo faltas de ortograf�a en foros y juego a BePolitics, al final los mejores actos de maldad son los cotidianos"                 
			</p>
			<p> No podemos esperar a la pr�xima aparici�n de tan controvertido y extravagante personaje</p>
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
            <h2>El cara a cara entre Scar y Mufasa ser� el 14 de diciembre en la Academia de la Televisi�n</h2>
        </div>
                <p>"Tengo las garras a punto"- Dice Scar tratando de amedrentar a su hermano</p>
                <p>
                El debate tendr� lugar en directo a trav�s de una m�dium contratada expecialmente para la ocasi�n. Cada uno expondr� sus pol�ticas y luego se abrir� una ronde de preguntas. "Van a estar como hienas para responder" Afirmaba Scar.  
                </p><p>
                La roca de la vida ser� el lugar del encuentro en que tendr� lugar el debate al tener cabida para todos los animales de la jungla. 
                </p>
                
                 </div>
    </div>

</div>
<div id="popup-box3" class ="popup-position">
    <div id="popup-wrapper">
    <p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box3')"><i class="fa fa-times"></i></a></p>
            <div id="popup-container">
            <div>
            <h2>Mariano Rajoy y Pablo iglesias se abrazan ante las c�maras</h2>
        </div>
                <p>Tras un emotivo v�deo de gatitos en directo, Mariano Rajoy y Pablo Iglesias se dieron un largo abrazo que ambos calificaron en directo como satisfactorio.</p>
                
                <p>"A�n huelo un poco fuerte y estoy lleno de pelo"- Declaraba el presidente unas horas despu�s en twitter</p>
                <p>"La barba raspaba bastante, pero era como abrazar a un telettuby"- A�adi� el secretario de Podemos cuando le preguntaron unas horas depu�s por la experiencia</p>
                
            </div>
    </div>

</div>

<div id="listaEventos" >
<table><tbody>
            <tr><td><input type="text" value="Introduce tu b�squeda"></td>
            <td><a class="ministryButton" >Buscar</a></td></tr>
            </tbody></table>
<ul>
    <li class="evento">
        <i class="fa fa-newspaper-o"></i>
        <a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')"> 
            Satan�s afirma que Juega BePolitics 
            <i class="ministryButton">Modificar</i>
            <a class="ministryButton">Eliminar</a>
        </a>
    </li>
    <li class="evento">
        <i class="fa fa-newspaper-o"></i>
        <a href="javascript:void(0)" onclick="toggle_visibility('popup-box2')"> 
            El cara a cara entre Scar y Mufasa ser� el 14 de diciembre en la Academia de la Televisi�n 
            
            <i class="ministryButton">Modificar</i>
            <a class="ministryButton">Eliminar</a>
            
        </a>
    </li>
    <li class="evento"> 
        <i class="fa fa-newspaper-o"></i>
        <a href="javascript:void(0)" onclick="toggle_visibility('popup-box3')"> 
            Mariano Rajoy y Pablo iglesias se abrazan ante las c�maras 
            <i class="ministryButton">Modificar</i>
            <a class="ministryButton">Eliminar</a>
        </a>
    </li>
</ul>

</div>
</div>
    <%@ include file="../fragments/footer.jsp" %>