<%@ include file="/vistas/cabecera.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Menú Principal</title>
</head>
<body>
	<div class="container">
		<div class="menu">
			<h1 class="titulo">Selecciona una opcion del menú</h1>
			<hr>
			<a href="matricularAlumno">1. Matricular un alumno</a> <br> <br>
			<a href="eliminarAlumno">2. Dar de baja a un alumno</a> <br> <br>
			<a href="insertPortatil">3. Registrar un portatil</a> <br> <br>
			<a href="buscarPortatil">4. Busqueda de portátil asignado a un
				alumno (se conoce el número de alumno)</a> <br> <br> <a
				href="buscarAlumno">5. Consulta alumno asignado a un portatil
				(se conoce el número de portatil)</a> <br> <br> <a
				href="mostrarAlumnos">6. Ver todos los alumnos con su asignación
				de portátil</a>
		</div>
	</div>
</body>
</html>