<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/cadastro.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">
<title>Cadastro de usuário</title>
</head>
<body>
	<center>
		<h1>Cadastro de usuário</h1>
	</center>
	<form action="SalvarUsuario" method="post">
		<ul class="form-style-1">
			<li>
				<table>
					<tr>
						<td>Código:</td>
						<td><input type="text" id="id" name="id" value="${user.id}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>Login</td>
						<td><input type="text" name="login" id="login"
							value="${user.login}"></td>
					</tr>
					<tr>
						<td>Senha</td>
						<td><input type="password" name="senha" id="senha"
							value="${user.senha}"></td>
					</tr>
					<tr>
						<td>Nome</td>
						<td><input type="text" name="nome" id="nome"
							value="${user.nome}"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="salvar" value="Salvar"></td>
					</tr>
				</table>
			</li>
		</ul>
	</form>

	<div class="container">
		<table class="table table-striped responsive-table">
			<center>
				<h3>Usuários cadastrados</h3>
			</center>
			<thead>
				<th>#</th>
				<th>Login</th>
				<th>Nome</th>
				<th>Deletar</th>
				<th>Editar</th>
			</thead>
			<c:forEach items="${usuarios}" var="user">
				<tbody>
					<tr>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.login}"></c:out></td>
						<td><c:out value="${user.nome}"></c:out></td>
						<td><a href="SalvarUsuario?acao=delete&user=${user.login}"><i
								class="fas fa-trash-alt"></i></a></td>
						<td><a href="SalvarUsuario?acao=editar&user=${user.login}"><i
								class="fas fa-edit"></i></a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

	<!-- Javascript -->
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="/js/function.js"></script>

</body>
</html>