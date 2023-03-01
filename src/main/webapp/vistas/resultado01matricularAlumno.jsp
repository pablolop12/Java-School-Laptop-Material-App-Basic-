<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<h1>Estos son los datos que has introducido</h1>
<span>Nombre: </span><span>${nuevoAlumno.nombre}</span><br/>
<span>Modelo: </span><span>${nuevoAlumno.telefono}</span><br/>
<br>
<a href="menu">Volver al menú</a> 

</body>
</html>