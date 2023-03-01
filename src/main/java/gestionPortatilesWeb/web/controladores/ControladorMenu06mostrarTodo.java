/**
 * 
 */
package gestionPortatilesWeb.web.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dto.*;
import gestionPortatilesWeb.aplicacion.services.Services;

/**
 * Controlador encargado de mostrar todos los resultados de alumnos y
 * concatenarlos junto a su portatil
 * 
 * @author Pablo
 *
 */
@Controller
public class ControladorMenu06mostrarTodo {

	// LISTAS DE ALUMNOS
	List<Alumno> listaAlumnos = new ArrayList<Alumno>();

	Map<String, Object> miModelo = new HashMap<String, Object>();// Modelo (miModelo)
	ADTO ADTO = new ADTOImpl();

	@Autowired
	Services query = new Services();

	@RequestMapping(value = "/mostrarAlumnos")
	public ModelAndView mostrarAlumnos() {
		try {

			// Lista de alumnos que rellenaremos ahora con un bucle
			List<String> listaAlumnos = new ArrayList<>();

			// Bucle que recorre y recopila cada registro que encuentra en una lista todos
			// los alumnos y concatena su portatil
			for (Alumno alumnos : query.mostrarAlumnos()) {
				listaAlumnos.add(ADTO.AlumnoDAOaDTO(alumnos).toString()
						+" --->"+ ADTO.PortatilDAOaDTO(alumnos.getPortatil()).toString());
			}

			miModelo.put("listaAlumnos", listaAlumnos);

			return new ModelAndView("menu06mostrarTodo", "miModelo", miModelo);
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("resultadoError");
		}
	}

}
