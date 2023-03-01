<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta portatil</title>
</head>
<body>
	<div class="container">
		<div class="menu">
			<h1>Buscar un Portatil en base a la Id de su alumno</h1>
			<hr>
			<form:form method="POST" action="encontradoPortatil"
				modelAttribute="idAlu">
				<form:label path="id">Id del alumno</form:label>
				<form:input path="id" />
				<input type="submit" value="Buscar" />
			</form:form>
			<br> <br> <a href="menu">Volver al menú</a>
		</div>
	</div>
</body>
</html>