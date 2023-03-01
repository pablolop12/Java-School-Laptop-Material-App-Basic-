<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Resultado de la búsqueda</h1>
	<span>Id del Alumno: </span>
	<span>${alumno.id}</span>
	<br>
	<span>Nombre: </span>
	<span>${alumno.nombre}</span>
	<br>
	<span>Telefono: </span>
	<span>${alumno.telefono}</span>
	<br>
	<br>
	<a href="menu">Volver al menú</a>

</body>
</html>