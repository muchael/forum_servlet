<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forum Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container text-center" style="border: 1px solid #ccc; width: 380px; height: 290px;  position: absolute; top: 30%;  left: 38%;">
		<form action="login" method="POST">
			<div><h2 style="margin-bottom: 30px;">FÓRUM</h2></div>
			<div class="form-group">
				<label><b>Login</b></label>
				<input type="text" placeholder="Entre com o login" name="login" required>
			</div>
			<div class="form-group">
				<label><b>Senha</b></label>
				<input type="password" placeholder="Entre com a senha" name="senha" required>
			</div>
			<div>
				<a class="btn btn-default" href="cadastro">Cadastrar usuário</a>
				<button type="submit" class="btn btn-primary">Login</button>
			</div>


			<div style="margin-top: 25px; color: red;">${mensagem}</div>
		</form>
	</div>
</body>
</html>