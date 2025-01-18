<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% var message = request.getParameter("error"); %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col justify-center items-center min-h-screen font-mono bg-gradient-to-r from-black to-gray-800">
	
	<div class="flex flex-col py-6 px-7 w-1/2 bg-white">
		<h1 class="self-center font-bold text-3xl mb-10">Register page</h1>
		
		<% if (message != null) {
			var error = Boolean.parseBoolean(message); 
			if (error) {
		%>
			<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
					Register failed. Email unavailable.
			</div>
		<%  } else { %>
			<div class="self-center justify-self-start mb-5 text-green-700 text-xl">
					Register success.
			</div>
		<%  }  %>
		<% } %>
			
		<form action="application.do?action=register" method="POST" class="flex flex-col">
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="name" placeholder="Name" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="email" placeholder="E-mail" required/>
			</div>
	
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none text-base w-full" type="password" name="password" placeholder="Password" required/>
			</div>
			
			<div class="flex items-center self-center w-full gap-5 justify-around">
		        <a href="application.do?action=home_page" class="bg-blue-700 w-1/2 py-4 text-md text-center font-bold text-white rounded-lg hover:bg-blue-600 cursor-pointer focus:outline-none focus:ring-2 focus:ring-white-300">
		            Voltar
		        </a>
		
		        <input class="text-md bg-black py-4 px-6 w-1/2 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold focus:outline-none focus:ring-2 focus:ring-gray-500" type="submit" value="Enviar">
    		</div>
		</form>
	</div>
	
</body>
</html>