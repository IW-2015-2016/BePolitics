<%@ include file="../fragments/header.jsp" %>
<%@ include file="../fragments/menu.jsp" %>	
<div id="divCentro">
	<div id="registrado">
		<div id="titulo">
			<h1>Login</h1>
		</div>
		<div id="login">
		    <form action="${prefix}entrar" method="POST">
		    
			<input type="hidden" id="source" name="source" 
				value="${requestScope['javax.servlet.forward.servlet_path']}"/>
		    	<div class="nick-pass">
		    		<label >Nick: </label>
		    		<input type="text" name="nick">
		 		</div>
				<div class="nick-pass">
		        	<label > Contrase&ntilde;a:</label> 
		        	<input type="password" name="contra">
				</div>
				<div class="entra-registro"> 
					<input name="submit"  value="Entrar" type="submit">    
					<input type="reset" value="Restablecer">
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="../fragments/footer.jsp" %>

