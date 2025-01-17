<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
<link rel="icon" href="images/icon.ico" type="image/x-icon">
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono box-border">
	
	<header class="flex p-6 items-center">
		<div class="flex items-center text-white justify-around w-full">
			
			<a href="application.do?action=index" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl;">
				<span class="material-icons text-2xl">home</span>
				<span>Home</span>
			</a>
			
			<a href="application.do?action=admin-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl;">
				<span class="material-symbols-outlined">lock_open</span>
				<span>Administração</span>
			</a>
			
			<a href="application.do?action=boarding-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl;">
				<span class="material-icons text-2xl">flight_takeoff</span>
				<span>Embarque</span>
			</a>
			
			<a href="application.do?action=arriving-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl;">
				<span class="material-icons text-2xl">flight_land</span>
				<span>Desembarque</span>
			</a>
			
			<a href="application.do?action=taking-off-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl;">
				<span class="material-icons text-2xl">airplanemode_active</span>
				<span>Hall 1</span>
			</a>
			
			<a href="application.do?action=took-off-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl;">
				<span class="material-icons text-2xl">check_circle</span>
				<span>Hall 2</span>
			</a>
			
			<a href="application.do?action=logout" class="bg-red-700 py-4 px-4 hover:bg-red-500 font-bold rounded-lg">
				<button>Logout</button>
			</a>
			
			
			<a href="application.do?action=login-page" class="bg-[#0070FF] py-3 px-5 hover:bg-[#589EFA] font-bold rounded-lg">
				<button>Login</button>
			</a>
			
		</div>
</header>
	
	

</body>
</html>