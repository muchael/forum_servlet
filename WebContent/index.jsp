<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forum Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<form action="login" method="POST">
		<div>
			<div>
				<label><b>Login</b></label>
				<input type="text"
					placeholder="Entre com o login" name="login" required>
			</div>
			<div> 
				<label><b>Senha</b></label>
				<input type="password" placeholder="Entre com a senha" name="senha"
					required>
			</div>
			<div>
				<button type="submit">Login</button>
			</div>
			
			<a href="cadastro">Cadastrar usuário</a>
			
			<div>
				${mensagem}
			</div>
		</div>
	</form>
</body>
</html>