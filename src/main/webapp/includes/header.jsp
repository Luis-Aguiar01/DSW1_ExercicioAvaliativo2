<%@page import="br.edu.ifsp.dsw.model.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% var isLogged = (Usuario) session.getAttribute("user"); %>

<header class="flex p-6 items-center">
	<div class="flex items-center text-white justify-around w-full">
		
		<a href="application.do?action=home_page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">home</span>
			<span>Home</span>
		</a>
		
		<% if (isLogged != null) { %>
		
		<a href="application.do?action=register_page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">edit</span>
			<span>Cadastro</span>
		</a>
		
		<a href="application.do?action=page_pedidos" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">article</span>
			<span>Pedidos</span>
		</a>
		
		<a href="application.do?action=home_page_relatorios" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">description</span>
			<span>Relatórios</span>
		</a>
		
		<a href="application.do?action=logout" class="bg-red-700 py-4 px-4 hover:bg-red-500 font-bold rounded-lg">
			<button>Logout</button>
		</a>
		
		<% } else { %>
		
		<a href="application.do?action=login_page" class="bg-[#0070FF] py-3 px-5 hover:bg-[#589EFA] font-bold rounded-lg">
			<button>Login</button>
		</a>
		
		<% } %>
	</div>
</header>