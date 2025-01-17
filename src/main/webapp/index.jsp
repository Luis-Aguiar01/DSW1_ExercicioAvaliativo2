<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono items-center justify-center box-border">
	
	<div class="flex font-bold text-white text-lg w-full justify-center gap-5 mb-10 mt-5">
		<a href="application.do?action=login_page" class="bg-blue-700 w-1/4 py-4 px-4 text-center rounded-lg hover:bg-blue-600 cursor-pointer"><button>Login</button></a>
		<a href="application.do?action=register_page" class="bg-green-700  w-1/4 py-4 px-4 text-center rounded-lg hover:bg-green-500 cursor-pointer"><button>Register</button></a>
	</div>

</body>
</html>