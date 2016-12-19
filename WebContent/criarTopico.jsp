<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forum - Criar Tópico</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<h2>Criar Tópico</h2>
	<form action="criarTopico" method="POST">
		<div>
			<div>
				<label><b>Titulo</b></label>
				<input type="text" name="titulo" required>
			</div>
			<div>
				<label><b>Conteúdo</b></label>
				<input type="text" name="conteudo" required>
			</div>
			<div>
				<button type="submit">Salvar</button>
			</div>
			
			<a href="listTopicos">Voltar</a>
		</div>
	</form>
</body>
</html>