<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">
	<div class="main">
		<div class="slides">
		<%-- href="home.css" --%>
			<img src="${prefix}resources/img/1.jpg" alt="">
			<img src="${prefix}resources/img/2.jpg" alt="">
			<img src="${prefix}resources/img/3.jpg" alt="">
		</div>
	</div>
				
				<script >
				 	$(function(){
					  $(".slides").slidesjs({
					    play: {
					      active: true,
					        // [boolean] Generate the play and stop buttons.
					        // You cannot use your own buttons. Sorry.
					      effect: "slide",
					        // [string] Can be either "slide" or "fade".
					      interval: 3000,
					        // [number] Time spent on each slide in milliseconds.
					      auto: false,
					        // [boolean] Start playing the slideshow on load.
					      swap: true,
					        // [boolean] show/hide stop and play buttons
					      pauseOnHover: false,
					        // [boolean] pause a playing slideshow on hover
					      restartDelay: 2500
					        // [number] restart delay on inactive slideshow
					    }
					  });
					});
				</script>

		
</div>

	
<%@ include file="../fragments/footer.jsp" %>



	
		
		
