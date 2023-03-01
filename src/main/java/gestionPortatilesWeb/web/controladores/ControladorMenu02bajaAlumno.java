/**
 * 
 */
package gestionPortatilesWeb.web.controladores;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.services.Services;

/**
 * Controlador donde a partir del ID del alumno podremos eliminar d ela base de
 * datos el registro del mismo.
 * 
 * @author Pablo
 *
 */
@Controller
public class ControladorMenu02bajaAlumno {

	Map<String, Object> miModelo = new HashMap<String, Object>();// Modelo (miModelo)

	@Autowired
	Services query = new Services();

	// Vista del formulario de eliminación
	@RequestMapping(value = "/eliminarAlumno")
	public String fromEliminarAlumno(Model modelo) {
		Alumno gestionAlumnos = new Alumno();
		modelo.addAttribute("eliminarAlumno", gestionAlumnos);
		return "menu02bajaAlumno";
	}

	// Eliminación del alumno en base al ID proporcionado con el método
	// eliminarUnAlumno
	@RequestMapping(value = "/deletedAlumno", method = RequestMethod.POST)
	public String eliminadoAlumno(@RequestParam long id) {
		try {
			query.eliminarUnAlumno(id);

			return "resultado02bajaAlumno";
		} catch (Exception e) {
			System.out.println(e);
			return "resultadoError";
			
		}

	}

}
