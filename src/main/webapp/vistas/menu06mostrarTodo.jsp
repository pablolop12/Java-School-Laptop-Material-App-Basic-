<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar todo</title>
</head>
<body>
	<div class="container">
		<div class="menu">
			<h1>Listado de Alumnos con sus portatiles asignados</h1>
			<hr>
			<ol>
			<c:forEach items="${miModelo.listaAlumnos}" var="alumnoPortatil">
				<li><c:out value="${alumnoPortatil}"></c:out>
				<br><br><br>
			</c:forEach>
			</ol>
			<br> <a href="menu">Volver al menú</a>
		</div>
	</div>
</body>
</html>