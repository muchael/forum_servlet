<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum - Ranking</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="container" >
	<h2>Ranking</h2>

	<table class="table table-striped">
		<thead>
			<th>Posição</th>
			<th>Nome</th>
			<th>Login</th>
			<th>Pontos</th>
		</thead>

		<tbody>
			<c:forEach items="${ranking}" var="usuario" varStatus="loop">
				<tr>
					<td><c:out value="${loop.index + 1}" /></td>
					<td><c:out value="${usuario.nome}" /></td>
					<td><c:out value="${usuario.login}" /></td>
					<td><c:out value="${usuario.pontos}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="listTopicos" class="btn btn-default" style="float: right;">Voltar</a>
</body>
</html>