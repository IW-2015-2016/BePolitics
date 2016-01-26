<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" prefix="e" %>

<!DOCTYPE html>
<html>
	<head>
		<title>${pageTitle}</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		
		<!--fuentes de google-->
		<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
		
		<!-- js -->
		<script src="${prefix}resources/js/menu/jquery.min.js"></script>
		<script src="${prefix}resources/js/menu/jsMenu.js"></script>
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<script src="${prefix}resources/js/slider/jquery.slides.js"></script>



		<!-- css -->
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/home.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/header.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/menu.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/styleSlider.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/iniciarSesion.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/crearCuenta.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/ranking.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/eventos.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/ministerios.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/addeditor.css">
		<!-- css auxiliares -->
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/auxliares/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="${prefix}resources/css/auxliares/fonts.css">
	</head>
<body>


		<c:choose> 
		<c:when test="${(not empty UsuarioRegistrado) && (not empty Administrador) && ( (not empty Editor))}">
			<c:when test="${(rol.rol eq 'UsuarioRegistrado')}">
				<header onclick="location.href='';" style="cursor: pointer;">
			</c:when>
			<c:when test="${(rol.rol eq 'Administrador')}">
				<header onclick="location.href='';" style="cursor: pointer;">
			</c:when>
			<c:when test="${(rol.rol eq 'Editor')}">
				<header onclick="location.href='';" style="cursor: pointer;">
			</c:when>
		</c:when>		
		<c:otherwise>
			<header onclick="window.location='';" style="cursor: pointer;">
		</c:otherwise>
	</c:choose> 

	
	
	
		<div class="botonHeader">
		<ul class="menuHeader">
				
			<c:choose>
				<c:when test="${(not empty UsuarioRegistrado) || (not empty Administrador) || ( (not empty Editor))}">
					<li><a href="logout" class= "linkHeader">Salir</a></li>
					<li><a href="iniciarSesion" class= "linkHeader">Mi cuenta</a></li>
				 </c:when>
				<c:otherwise>
					<li><a href="iniciarSesion" class= "linkHeader">Iniciar sesión</a></li>
					<li><a href="crearCuenta" class= "linkHeader">Crear una cuenta</a></li>
				</c:otherwise>
			</c:choose>
			
		</ul>
		</div>
		
	</header>
