<%@page import="java.util.List"%>
<%@page import="br.edu.ifsp.dsw.model.entity.Pedido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	var pedidos = (List<Pedido>) request.getAttribute("pedidos"); 
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report Page</title>
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=search" />
</head>
<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono box-border">
	
	<jsp:include page="../includes/header.jsp" />
		
	<form action="logged.do?action=search_pedidos_usuario" method="POST" class="flex gap-5 self-end mt-5 mr-10 w-1/4">
		<a href="logged.do?action=page_relatorios" class="bg-green-600 w-1/4 py-4 text-md text-center font-bold text-white rounded-lg hover:bg-green-700 cursor-pointer focus:outline-none focus:ring-2 focus:ring-white-300">
			Todos
		</a>
		<div class="flex items-center border rounded-lg bg-gray-200 p-3 w-2/3">
			<input class="bg-transparent outline-none text-base w-full" type="text" name="name" placeholder="Pesquisar" required/>
			<button type="submit" class="flex items-center font-bold text-gray-600">
    			<span class="material-symbols-outlined mr-2">search</span>
			</button>
		</div>
	</form>
	
	<div class="flex self-center flex-wrap items-center justify-center gap-5 mt-10">
		<% if (pedidos != null && !pedidos.isEmpty()) { %>
	   	<%   for (var pedido : pedidos) { %>
	   	
    	<div class="border-2 border-gray-200 rounded-lg shadow-md overflow-hidden bg-[#2A3439] w-80 h-80">
	        <div class="p-6">
	            <h3 class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Produto: <span class="text-white"><%= pedido.getDescricao() %></span>
	            </h3>
	
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Nome do Cliente: <span class="text-white"><%= pedido.getNomeCliente() %></span>
	            </p>
	
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Endereço de Entrega: <span class="text-white"><%= pedido.getEnderecoEntrega() %></span>
	            </p>
	
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Valor: <span class="text-white">R$ <%= pedido.getPrice() %></span>
	            </p>
	            
	            <p class="mt-4 text-[#0070FF] text-sm font-bold">
	            	Cadastrado por: <span class="text-white"> <%= pedido.getUsuario().getNome() %> </span>
	            </p>
	
	            <div class="mt-4 flex items-center justify-center gap-2">
	                <a href="application.do?action=update_pedidos_page&id=<%= pedido.getIdPedido() %>">
	                	<button class="bg-blue-600 hover:bg-blue-500 text-white font-semibold py-2 px-4 rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-blue-300">Editar</button>
	                </a>
	                <a href="logged.do?action=delete_pedido&id=<%= pedido.getIdPedido() %>">	
	                	<button class="bg-red-600 hover:bg-red-500 text-white font-semibold py-2 px-4 rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-red-300">Excluir</button>
	                </a>
	            </div>
	        </div>
    	</div>
    	
    	<%   } %>
    	<% } else { %>
    	
    	<div class="self-center w-2/3 mt-8">
			<h1 class="font-bold text-4xl text-center text-white mt-10 leading-relaxed">Nenhum produto encontrado.</h1>
		</div>
    	
    	<% } %>
    	
	</div>
</body>
</html>