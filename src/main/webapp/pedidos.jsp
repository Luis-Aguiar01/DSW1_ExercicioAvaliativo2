<%@page import="br.edu.ifsp.dsw.model.entity.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	var pedidos = (List<Pedido>) request.getAttribute("pedidos"); 
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono box-border">
	
	<jsp:include page="includes/header.jsp" />
	
	<a href="application.do?action=register_pedido_page" class="self-end mt-5 mr-20">	
		<button class="bg-green-500 hover:bg-green-600 text-white font-semibold py-2 px-4 rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-white">Adicionar</button>
	</a>
	
	<div class="flex self-center flex-wrap items-center justify-center gap-5 mt-5">
		<% if (pedidos != null && !pedidos.isEmpty()) { %>
	   	<%   for (var pedido : pedidos) { %>
	   	
    	<div class="border-2 border-gray-200 rounded-lg shadow-md overflow-hidden bg-[#2A3439]">
	        <div class="p-6">
	            <h3 class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Produto: <span class="text-white"><%= pedido.getDescricao() %></span>
	            </h3>
	
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Nome do Cliente: <span class="text-white"><%= pedido.getUsuario().getNome() %></span>
	            </p>
	
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Endereço de Entrega: <span class="text-white"><%= pedido.getEnderecoEntrega() %></span>
	            </p>
	
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Valor: <span class="text-white">R$ <%= pedido.getPrice() %></span>
	            </p>
	
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	E-mail do Usuário: <span class="text-white"><%= pedido.getUsuario().getEmail() %></span>
	            </p>
	
	            <div class="mt-4 flex items-center justify-center gap-2">
	                <a href="application.do?action=update_pedido_page&id=<%= pedido.getIdPedido() %>">
	                	<button class="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-blue-300">Editar</button>
	                </a>
	                <a href="application.do?action=delete_pedido&id=<%= pedido.getIdPedido() %>">	
	                	<button class="bg-red-500 hover:bg-red-600 text-white font-semibold py-2 px-4 rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-red-300">Excluir</button>
	                </a>
	            </div>
	        </div>
    	</div>
    	
    	<%   } %>
    	<% } %>
    	
	</div>
</body>
</html>