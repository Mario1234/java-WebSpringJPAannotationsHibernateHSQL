<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring5 MVC Hibernate Demo</title>
		<style type="text/css">
			.error {
				color: red;
			}
			table {
				width: 50%;
				border-collapse: collapse;
				border-spacing: 0px;
			}
			table td {
				border: 1px solid #565454;
				padding: 20px;
			}
		</style>
	</head>
	<body>
		<h1>Input Form</h1>
		<form:form action="addUser" method="post" modelAttribute="jsp_usuario">
			<table>
				<tr>
					<td>Nombre</td>
					<td>
						<form:input path="nombre" /> <br />
					</td>
				</tr>
				<tr>
					<td>Apellido</td>
					<td>
						<form:input path="apellido" /> <br />
					</td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>
		
		<h2>Users List</h2>
		<table>
			<tr>
				<td><strong>Nombre</strong></td>
				<td><strong>Apellido</strong></td>
			</tr>
			<c:forEach items="${jsp_usuarios}" var="usuarioi">
				<tr>
					<td>${usuarioi.nombre}</td>
					<td>${usuarioi.apellido}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>