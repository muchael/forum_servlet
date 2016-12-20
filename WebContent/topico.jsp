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
		<h2>Tópico: ${ topico.titulo }</h2>
		<h3>Criador: ${ topico.criador.nome }</h3>

		<label>Descrição</label>
		<div>${ topico.conteudo }</div>

		<c:if test="${not empty topico.comentarios}">
			<div style="margin-top: 40px;">
				<h4>Comentários</h4>
				<div>
					<table class="table">
						<thead>
							<th>Comentário</th>
							<th>Usuário</th>
						</thead>

						<c:forEach items="${topico.comentarios}" var="comentario">
							<tr>
								<td><c:out value="${comentario.comentario}" /></td>
								<td><c:out value="${comentario.usuario.nome}" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</c:if>

		<div>
			<form action="topico?id=${ topico.id_topico }" method="POST"
				style="width: 400px; margin: 0 30%; margin-top: 40px;">
				<div class="form-group">
					<label>Comentário:</label>
					<textarea class="form-control" name="comentario" rows="3" cols=""></textarea>
				</div>
				<div style="text-align: right;">
					<a href="listTopicos" class="btn btn-default">Voltar</a>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>