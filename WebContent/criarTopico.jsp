<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forum - Criar Tópico</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="container">
	<h2>Criar Tópico</h2>
	<form action="criarTopico" method="POST" class="form-horizontal">
		<div>
			<div class="form-group">
				<label class="control-label">Titulo</label>
				<input class="form-control" type="text" name="titulo" required>
			</div>
			<div class="form-group">
				<label><b>Conteúdo</b></label>
				<textarea class="form-control" name="conteudo"
					required rows="3"></textarea> 
			</div>
			<div style="text-align: right;">
				<a href="listTopicos" class="btn btn-default">Voltar</a>
				<button class="btn btn-primary" type="submit">Salvar</button>
			</div>

		</div>
	</form>
</body>
</html>