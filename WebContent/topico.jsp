<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fórum - Tópico</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<h2>Tópico ${ topico.titulo }</h2> <h3> Usuário: ${ topico.criador.nome } </h3>
		
		<div>Descrição: </div>
		<div>${ topico.conteudo }</div>
		<div>Comentários:</div>
		
		<div>
			<table class="table">
				<tr>
					<td>Usuário</td>
					<td>Comentário</td>
				</tr>

				<c:forEach items="${topico.comentarios}" var="comentario">
					<tr>
						<td><c:out value="${comentario.comentario}" /></td>
						<td><c:out value="${comentario.usuario.nome}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div>
			<form action="topico?id=${ topico.id_topico }" method="POST">
				<div class="form-group">
					<label>Comentário:</label>
					<textarea class="form-control" name="comentario" rows="3" cols=""></textarea>
				</div>
				<button>Enviar</button>
			</form>
		</div>
		<a href="listTopicos">Voltar</a>
	</div>
</body>
</html>