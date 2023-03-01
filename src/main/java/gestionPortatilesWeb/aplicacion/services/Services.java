/**
 * 
 */
package gestionPortatilesWeb.aplicacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gestionPortatilesWeb.aplicacion.dal.*;

/**
 * @author Pablo: Clase Servicios, con todos los metodos (consultas) necesarias
 *         de nuestro programa.
 *
 */
@Service
public class Services {

	@Autowired
	private AlumnoRepository aluRepo;
	@Autowired
	private PortatilRepository porRepo;

	// Mensajes de error
	String mensaje = null;
	String error = null;

	// CREAR ALUMNO
	@Transactional
	public void crearAlumno(Alumno alumno) {
		try {
			aluRepo.save(alumno);

		} catch (Exception e) {
			mensaje = "Ha sucedido un error inesperado, no se ha podido crear la entidad";
			error = e.toString();
		}

	}

	// CREAR UN PORTATIL
	@Transactional
	public void crearPortatil(Portatil portatil) {
		try {
			porRepo.save(portatil);

		} catch (Exception e) {
			mensaje = "Ha sucedido un error inesperado, no se ha podido crear la entidad";
			error = e.toString();
		}

	}

	// ELIMINAR UN ALUMNO
	@Transactional
	public void eliminarUnAlumno(long id) {
		try {
			aluRepo.deleteById(id);

		} catch (Exception e) {
			mensaje = "Ha sucedido un error inesperado, no se ha podido eliminar la entidad";
			error = e.toString();
		}

	}

	// MOSTRAR TODOS LOS ALUMNOS
	public List<Alumno> mostrarAlumnos() {
		try {
			return (List<Alumno>) aluRepo.findAll();

		} catch (Exception e) {
			mensaje = "Ha sucedido un error inesperado, no se han podido obtener los datos";
			error = e.toString();
			return null;
		}

	}

	// MOSTRAR TODOS LOS ORDENADORES
	public List<Portatil> buscarOrdenadores() {
		try {
			return (List<Portatil>) porRepo.findAll();

		} catch (Exception e) {
			mensaje = "Ha sucedido un error inesperado, no se han podido obtener los datos";
			error = e.toString();
			return null;
		}
	}

	// BUSCAR UN PORTATIL POR ID ALUMNO
	public Portatil buscarPortatilbyIdAlu(long id) {
		try {
			Alumno alumno = aluRepo.findById(id).get();
			Portatil portatil = alumno.getPortatil();
			return portatil;

		} catch (Exception e) {
			mensaje = "Ha sucedido un error inesperado, no se han podido obtener los datos";
			error = e.toString();
			return null;
		}

	}

	// BUSCAR UN ALUMNO POR ID PORTATIL
	public Alumno buscarAlumnobyIdPor(long id) {
		try {
			Portatil portatil = porRepo.findById(id).get();
			Alumno alumno = portatil.getAlumno();
			return alumno;

		} catch (Exception e) {
			mensaje = "Ha sucedido un error inesperado, no se han podido obtener los datos";
			error = e.toString();
			return null;
		}

	}

}