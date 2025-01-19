<%@page import="br.edu.ifsp.dsw.model.entity.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	var pedidos = (List<Pedido>) request.getAttribute("pedidos"); 
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders Page</title>
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono box-border">
	
	<jsp:include page="../includes/header.jsp" />
	
	<a href="logged.do?action=register_pedido_page" class="self-end mt-5 mr-20">	
		<button class="bg-green-600 hover:bg-green-500 text-white font-semibold py-3 px-4 rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-white">Adicionar</button>
	</a>
	
	<div class="flex self-center flex-wrap items-center justify-center gap-5 mt-5">
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
	                <a href="logged.do?action=update_pedidos_page&id=<%= pedido.getIdPedido() %>">
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