<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum - Listagem de Tópicos</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="container">
	<h2>Tópicos</h2>

	<table class="table">
		<thead>
			<th>Título</th>
			<th>Criador</th>
			<th></th>
		</thead>
		<tbody>
			<c:forEach items="${topicos}" var="topico">
				<tr>
					<td><c:out value="${topico.titulo}" /></td>
					<td><c:out value="${topico.criador.nome}" /></td>
					<td><a href="topico?id=${ topico.id_topico }">Visualizar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="text-align: right;">
		<a href="ranking" class="btn btn-default">Ranking de usuários</a>
		<a href="criarTopico" class="btn btn-primary">Criar tópico</a>
	</div>
</body>
</html>