<%@page import="br.edu.ifsp.dsw.model.entity.Pedido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	var message = request.getParameter("error");
	var pedido = (Pedido) request.getAttribute("pedido");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col justify-center items-center min-h-screen font-mono bg-gradient-to-r from-black to-gray-800">
	
	<div class="flex flex-col py-5 px-10 w-1/2 bg-white">
		<h1 class="self-center font-bold text-3xl mb-5">Update Order</h1>
		
		<% if (message != null) {
			var error = Boolean.parseBoolean(message); 
			if (error) {
		%>
			<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
					Register failed.
			</div>
		<%  } else { %>
			<div class="self-center justify-self-start mb-5 text-green-700 text-xl">
					Register success.
			</div>
		<%  }  %>
		<% } %>
			
		<form action="logged.do?action=update_pedido" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none text-base w-full" type="text" name="descricao" value="<%= pedido.getDescricao() %>" placeholder="Descricao" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="address" value="<%= pedido.getEnderecoEntrega() %>" placeholder="Endereço de Entrega" required/>
			</div>
		
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="number" name="price" value="<%= pedido.getPrice() %>" placeholder="Valor" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="cliente" value="<%= pedido.getNomeCliente() %>" placeholder="Nome do cliente" required/>
			</div>
			
			<input class="px-3 py-4 bg-transparent outline-none text-base w-full" hidden="hidden" type="text" name="email" value="<%= pedido.getUsuario().getEmail() %>"/>
			
			<input class="px-3 py-4 bg-transparent outline-none text-base w-full" hidden="hidden" type="number" name="id" value="<%= pedido.getIdPedido() %>"/>
			
			<div class="flex items-center self-center w-full gap-5 justify-around">
		        <a href="logged.do?action=page_pedidos" class="bg-blue-700 w-1/2 py-4 text-lg text-center font-bold text-white rounded-lg hover:bg-blue-600 cursor-pointer focus:outline-none focus:ring-2 focus:ring-white-300">
		            Voltar
		        </a>
		
		        <input class="text-lg bg-black py-4 px-6 w-1/2 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold focus:outline-none focus:ring-2 focus:ring-gray-500" type="submit" value="Enviar">
    		</div>
		</form>
	</div>
	
	
</body>
</html>