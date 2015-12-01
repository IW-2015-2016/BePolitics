<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">
	<div id="registrado">
		<div id="titulo">
			<h1>Login</h1>
		</div>
		<div id="login">
		    <form action="" method="POST">
		    	<div class="nick-pass">
		    		<label >Nick: </label>
		    		<input type="text" name="nick">
		 		</div>
				<div class="nick-pass">
		        	<label > Contrase&ntilde;a:</label> 
		        	<input type="password" name="contra">
				</div>
				<div class="entra-registro"> 
					<input type="button" value="Entrar">    
					<input type="reset" value="Restablecer">
						<p><a href="vistaAdmin" >Entrar como Administrador</a></p>
						<p><a href="vistaEditor" >Entrar como Editor</a>	</p>
						<p><a href="vistaJugador" >Entrar como Jugador</a>	</p>	
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="../fragments/footer.jsp" %>

