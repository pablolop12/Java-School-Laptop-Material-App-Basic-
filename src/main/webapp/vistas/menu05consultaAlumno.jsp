<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta Alumno</title>
</head>
<body>
	<div class="container">
		<div class="menu">
			<h1>Buscar un Alumno en base a la Id de su portatil</h1>
			<hr>
			<form:form method="POST" action="encontradoAlumno"
				modelAttribute="idPor">
				<form:label path="id">Id del portatil</form:label>
				<form:input path="id" />
				<input type="submit" value="Buscar" />
			</form:form>
			<br> <br> <a href="menu">Volver al menú</a>
		</div>
	</div>
</body>
</html>