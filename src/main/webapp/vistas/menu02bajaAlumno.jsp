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
			<h1>Matriculaci�n de un nuevo Alumno</h1>
			<hr>
			<form:form onsubmit="return confirmar()" method="POST"
				action="deletedAlumno" modelAttribute="eliminarAlumno">
				<form:label path="id">Id del Alumno a eliminar: </form:label>
				<form:input path="id" />
				<br>
				<br>
				<input type="submit" onclick="confirmar()" value="Eliminar" />
			</form:form>
			<br> <a href="menu">Volver al men�</a>
		</div>
	</div>
</body>

<script>
	function confirmar() {
		var respuesta = prompt("Por favor, escriba 'confirmar' para eliminar el archivo");

		if (respuesta == "confirmar") {
			return true; // Se env�a el formulario y se elimina el archivo
		} else if (respuesta != null) {
			alert("No se ha confirmado la eliminaci�n del archivo");
			return false; // No se env�a el formulario
		} else {
			alert("La eliminaci�n del archivo ha sido cancelada");
			return false; // No se env�a el formulario
		}
	}
</script>


</html>