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
	<span>Id del portatil: </span>
	<span>${portatil.id}</span>
	<br>
	<span>Modelo: </span>
	<span>${portatil.modelo}</span>
	<br>
	<span>Marca: </span>
	<span>${portatil.marca}</span>
	<br>
	<br>
	<a href="menu">Volver al menú</a>

</body>
</html>