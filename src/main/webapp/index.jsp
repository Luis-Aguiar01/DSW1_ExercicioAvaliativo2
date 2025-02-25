<%@page import="br.edu.ifsp.dsw.model.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	var user = (Usuario) session.getAttribute("user"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono box-border">
	
	<jsp:include page="includes/header.jsp" />
	
	<% if (user != null) { %>
	
	<div class="self-center w-2/3 mt-8">
		<h1 class="font-bold text-4xl text-center text-white mt-10 leading-relaxed">Welcome to your page, <%= user.getNome() %> <span> &#128075;</span></h1>
	</div>	
	
	<% } else { %>
	
	<div class="self-center w-2/3 mt-8">
		<h1 class="font-bold text-4xl text-center text-white mt-10 leading-relaxed">Welcome to the home page<span> &#128075;</span></h1>
	</div>
	
	<% } %>
</body>
</html>