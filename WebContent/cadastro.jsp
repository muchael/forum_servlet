<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de usuários</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<h2>Cadastro de usuários</h2>
	<form action="cadastro" method="POST">
		<div>
			<div>
				<label><b>Nome</b></label>
				<input type="text" name="nome" required>
			</div>
			<div>
				<label><b>Login</b></label>
				<input type="text" name="login" required>
			</div>
			<div>
				<label><b>Email</b></label>
				<input type="email" name="email" required>
			</div>
			<div> 
				<label><b>Senha</b></label>
				<input type="password" name="senha" required>
			</div>
			<div>
				<button type="submit">Salvar</button>
			</div>
		</div>
	</form>
</body>
</html>