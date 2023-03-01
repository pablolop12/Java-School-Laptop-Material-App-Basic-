<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="menu">
			<h1>Matriculación de un nuevo Alumno</h1>
			<hr>
			<form:form method="POST" action="savedAlumno"
				modelAttribute="nuevoAlumno">
				<form:label path="nombre">Nombre: </form:label>
				<form:input path="nombre" />
				<br>
				<br>
				<form:label path="telefono">Telefono</form:label>
				<form:input path="telefono" />
				<br>
				<br>
				<input type="submit" value="Guardar" />
			</form:form>
			<br> <a href="menu">Volver al menú</a>

		</div>
	</div>
</body>
</html>