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
		<h1>Mercado de políticos</h1>
	</div>	
<div id="popup-box1" class ="popup-position">
	<div id="popup-wrapper">
	 <p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')"><i class="fa fa-times"></i></a></p>
			<div id="popup-container">
			<div >
			<h2>Zazú</h2>
		</div>	
				<p>Lorem ipsum 1 dolor sit amet, consectetur adipiscing elit. Proin imperdiet dui sed malesuada lobortis. Praesent mattis nulla a tincidunt scelerisque. Curabitur cursus, nisl mollis interdum aliquam, orci nibh tincidunt orci, sed molestie arcu massa nec elit. Praesent efficitur volutpat metus, non faucibus sapien aliquet ac. Nam nisi eros, bibendum in egestas ut, consequat eu purus. Aliquam et magna eu sem rutrum finibus vel vitae nibh. Vivamus congue, lectus a iaculis scelerisque, ipsum magna gravida sapien, at facilisis eros odio ut nisl. 
				</p><p>
				Praesent a odio et risus mollis blandit. Praesent vehicula ex ex, vitae hendrerit arcu ullamcorper vitae. Nam ornare eget orci sed ullamcorper. Praesent ut mi sed odio sagittis accumsan at eu elit. Duis vel justo iaculis, pretium massa sit amet, dignissim dui. Mauris a rutrum neque. Sed sed est maximus, gravida dolor quis, elementum orci. Suspendisse sit amet risus sit amet risus ornare rutrum non ut est. Pellentesque at placerat risus, id vehicula purus. Donec tincidunt sapien sed enim fermentum, sit amet convallis purus maximus. 
				</p>
				
			</div>
	
	</div>

</div>
<div id="popup-box2" class ="popup-position">
	<div id="popup-wrapper">
	<p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box2')"><i class="fa fa-times"></i></a></p>
			<div id="popup-container">
<div>
			<h2>Reina de corazones</h2>
		</div>
				<p>Lorem ipsum 2 dolor sit amet, consectetur adipiscing elit. Proin imperdiet dui sed malesuada lobortis. Praesent mattis nulla a tincidunt scelerisque. Curabitur cursus, nisl mollis interdum aliquam, orci nibh tincidunt orci, sed molestie arcu massa nec elit. Praesent efficitur volutpat metus, non faucibus sapien aliquet ac. Nam nisi eros, bibendum in egestas ut, consequat eu purus. Aliquam et magna eu sem rutrum finibus vel vitae nibh. Vivamus congue, lectus a iaculis scelerisque, ipsum magna gravida sapien, at facilisis eros odio ut nisl. 
				</p><p>
				Praesent a odio et risus mollis blandit. Praesent vehicula ex ex, vitae hendrerit arcu ullamcorper vitae. Nam ornare eget orci sed ullamcorper. Praesent ut mi sed odio sagittis accumsan at eu elit. Duis vel justo iaculis, pretium massa sit amet, dignissim dui. Mauris a rutrum neque. Sed sed est maximus, gravida dolor quis, elementum orci. Suspendisse sit amet risus sit amet risus ornare rutrum non ut est. Pellentesque at placerat risus, id vehicula purus. Donec tincidunt sapien sed enim fermentum, sit amet convallis purus maximus. 
				</p>
				
				 </div>
	</div>

</div>
<div id="popup-box3" class ="popup-position">
	<div id="popup-wrapper">
	<p><a href="javascript:void(0)" onclick="toggle_visibility('popup-box3')"><i class="fa fa-times"></i></a></p>
			<div id="popup-container">
			<div>
			<h2>Dr. Doom</h2>
		</div>
				<p>Lorem ipsum 3 dolor sit amet, consectetur adipiscing elit. Proin imperdiet dui sed malesuada lobortis. Praesent mattis nulla a tincidunt scelerisque. Curabitur cursus, nisl mollis interdum aliquam, orci nibh tincidunt orci, sed molestie arcu massa nec elit. Praesent efficitur volutpat metus, non faucibus sapien aliquet ac. Nam nisi eros, bibendum in egestas ut, consequat eu purus. Aliquam et magna eu sem rutrum finibus vel vitae nibh. Vivamus congue, lectus a iaculis scelerisque, ipsum magna gravida sapien, at facilisis eros odio ut nisl. 
				</p><p>
				Praesent a odio et risus mollis blandit. Praesent vehicula ex ex, vitae hendrerit arcu ullamcorper vitae. Nam ornare eget orci sed ullamcorper. Praesent ut mi sed odio sagittis accumsan at eu elit. Duis vel justo iaculis, pretium massa sit amet, dignissim dui. Mauris a rutrum neque. Sed sed est maximus, gravida dolor quis, elementum orci. Suspendisse sit amet risus sit amet risus ornare rutrum non ut est. Pellentesque at placerat risus, id vehicula purus. Donec tincidunt sapien sed enim fermentum, sit amet convallis purus maximus. 
				</p>
				
			</div>
	</div>

</div>

<div id="listaEventos" >
<ul>
	<li class="evento"> 
		<i class="fa fa-btc"></i>
		<a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')"> Zazú </a>
		<a href="javascript:void(0)" onclick="toggle_visibility('popup-box1')"> Coste: 500 PIB</a>
		<div class="contratar"><a href="#" class= "ministryButton">Contratar</a></div>

	</li>
	<li class="evento"> 
		<i class="fa fa-btc"></i>
		<a href="javascript:void(0)" onclick="toggle_visibility('popup-box2')"> Reina de corazones </a>
		<a href="javascript:void(0)" onclick="toggle_visibility('popup-box2')"> Coste: 900 PIB</a>
		<div class="contratar"><a href="#" class= "ministryButton">Contratar</a></div>
		
	</li>
	<li class="evento"> 
		<i class="fa fa-btc"></i>
		<a href="javascript:void(0)" onclick="toggle_visibility('popup-box3')"> Reina de corazones </a>
		<a href="javascript:void(0)" onclick="toggle_visibility('popup-box3')"> Coste: 100 PIB</a>
		<div class="contratar"><a href="#" class= "ministryButton">Contratar</a></div>
	
	</li>

</ul>

</div>
</div>
	<%@ include file="../fragments/footer.jsp" %>