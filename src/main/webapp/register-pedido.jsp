<%@page import="br.edu.ifsp.dsw.model.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	var message = request.getParameter("error");
	var user = (Usuario) session.getAttribute("user");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col justify-center items-center min-h-screen font-mono bg-gradient-to-r from-black to-gray-800">
	
	<div class="flex flex-col py-5 px-10 w-1/2 bg-white">
		<h1 class="self-center font-bold text-3xl mb-5">Register Orders</h1>
		
		<% if (message != null) {
			var error = Boolean.parseBoolean(message); 
			if (error) {
		%>
			<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
					Register failed. Invalid e-mail.
			</div>
		<%  } else { %>
			<div class="self-center justify-self-start mb-5 text-green-700 text-xl">
					Register success.
			</div>
		<%  }  %>
		<% } %>
			
		<form action="application.do?action=register_pedido" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none text-base w-full" type="text" name="descricao" placeholder="Descricao" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="address" placeholder="Endereço de Entrega" required/>
			</div>
		
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="number" name="price" placeholder="Valor" required/>
			</div>
			
			<input class="px-3 py-4 bg-transparent outline-none text-base w-full" hidden="hidden" type="text" name="email" value="<%= user.getEmail() %>"/>
	
			<input class="text-lg mt-2 bg-black py-3 self-center w-1/3 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold" type="submit" value="Enviar">
		</form>
	</div>
	<a href="application.do?action=home_page" class="bg-blue-700 w-1/7 py-4 px-6 mt-4 text-center font-bold text-white rounded-lg hover:bg-blue-600 cursor-pointer"><button>Home</button></a>
</body>
</html>