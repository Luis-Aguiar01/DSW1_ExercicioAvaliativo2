<%@page import="br.edu.ifsp.dsw.model.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% var user = (Usuario) session.getAttribute("user"); %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono items-center justify-center box-border">
	
	<div class="border-solid border-2 border-gray-400 rounded-lg w-2/3">
		<h1 class="font-bold text-4xl text-center text-white mt-10 leading-relaxed">Welcome to your page, <%= user.getNome() %></h1>
	
		<div class="flex font-bold text-white text-lg w-full justify-center gap-5 mb-10 mt-5">
			<div>
				<a href="application.do?action=register_users_page" class="bg-blue-700 w-1/4 py-4 px-4 text-center rounded-lg hover:bg-blue-600 cursor-pointer"><button>Cadastrar Usuários</button></a>
				<a href="application.do?action=register_pedido_page" class="bg-blue-700 w-1/4 py-4 px-4 text-center rounded-lg hover:bg-blue-600 cursor-pointer"><button>Cadastrar Pedidos</button></a>
				<a href="application.do?action=delete_pedido_page" class="bg-blue-700 w-1/4 py-4 px-4 text-center rounded-lg hover:bg-blue-600 cursor-pointer"><button>Deletar Pedidos</button></a>
			</div>
			<div>	
				<a href="application.do?action=register_users_page" class="bg-blue-700 w-1/4 py-4 px-4 text-center rounded-lg hover:bg-blue-600 cursor-pointer"><button>Consultar Pedidos</button></a>
				<a href="application.do?action=register_users_page" class="bg-blue-700 w-1/4 py-4 px-4 text-center rounded-lg hover:bg-blue-600 cursor-pointer"><button>Cadastrar Usuários</button></a>
				<a href="application.do?action=logout" class="bg-red-700  w-1/4 py-4 px-4 text-center rounded-lg hover:bg-red-500 cursor-pointer"><button>Logout</button></a>
			</div>
		</div>
	</div>	
	
</body>
</html>>