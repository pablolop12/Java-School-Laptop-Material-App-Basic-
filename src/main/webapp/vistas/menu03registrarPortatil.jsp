<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Portatil</title>
</head>
<body>
	<div class="container">
		<div class="menu">
			<h1>Inserción de un nuevo Portatil</h1>
			<hr>
			<form:form method="POST" action="savedPortatil"
				modelAttribute="nuevoPortatil">
				<form:label path="marca">Marca</form:label>
				<form:input path="marca" />
				<form:label path="modelo">Modelo</form:label>
				<form:input path="modelo" />
				<input type="submit" value="Guardar" />
			</form:form>
			<br> <a href="menu">Volver al menú</a>
		</div>
	</div>
</body>
</html>