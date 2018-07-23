<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/estilo.css">
<title>Páginas JSP</title>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="LoginServlet" method="post">
				Login: <input type="text" name="login" id="login"><br />
				Senha: <input type="password" name="senha" id="senha"><br />
				<button type="submit" value="Logar">Logar</button>
			</form>
		</div>
	</div>
</body>
</html>