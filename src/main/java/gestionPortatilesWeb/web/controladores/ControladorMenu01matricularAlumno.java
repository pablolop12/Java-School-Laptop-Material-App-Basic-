package gestionPortatilesWeb.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dal.Portatil;
import gestionPortatilesWeb.aplicacion.dto.AlumnoDTO;
import gestionPortatilesWeb.aplicacion.dto.ADAO;
import gestionPortatilesWeb.aplicacion.dto.ADAOImpl;
import gestionPortatilesWeb.aplicacion.services.Services;

/**
 * Controlador que se encarga de la inserción en base de datos de nuevos alumnos
 * así como la asignación automática de un portatil disponible para el mismo
 * 
 * @author Pablo
 *
 */
@Controller
public class ControladorMenu01matricularAlumno {

	@Autowired
	private Services services;

	private ADAO adao = new ADAOImpl();

	// Lista donde almacenaremos las ID de los portatiles que están siendo usados
	private List<Integer> portatilesUsados = new ArrayList<>();

	// Vista formulario de introduccion de datos
	@RequestMapping(value = "/matricularAlumno")
	public String mostrarFormularioMatriculacion(Model modelo) {
		modelo.addAttribute("nuevoAlumno", new AlumnoDTO());
		return "menu01matricularAlumno";
	}

	// Guardado de alumno
	@RequestMapping(value = "/savedAlumno", method = RequestMethod.POST)
	public String guardarAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoDTO, Model modelo) {

		try {
			Portatil portatilDisponible = null; // Variable donde almacenaremos el Portatil que este disponible

			// Bucle que lee todos los alumnos, y si tiene un portatil asignado, recoge su
			// ID y la almacena en la lista
			for (Alumno alumno : services.mostrarAlumnos()) {
				if (alumno.getPortatil() != null) {
					portatilesUsados.add((int) alumno.getPortatil().getId());
				}
			}

			// Bucle que lee todos los portatiles y comprueba si están en la lista de
			// ordenadores usados que hemos rellenado anteriormente. En cuanto encuentra uno
			// libre lo asigna a la variable portatilDisponible
			for (Portatil portatil : services.buscarOrdenadores()) {
				if (!portatilesUsados.contains(Math.toIntExact(portatil.getId()))) {
					portatilDisponible = portatil;
					break;
				}
			}

			// Se asigna a la instancia de alumnoDTO el portatil disponible encontrado en el
			// bucle anterior
			if (portatilDisponible != null) {
				alumnoDTO.setPortatil(portatilDisponible);
			}

			// Pasamos el DTO a DAO para hacer la query
			Alumno alumno = adao.AlumnoDTOaDAO(alumnoDTO);

			// Lanzamos la query
			services.crearAlumno(alumno);

			// Mostramos en la vista la instancia de alumnoDTO anterior para que el usuario
			// verifique los datos que ha introducido
			modelo.addAttribute("alumnoGuardado", alumnoDTO);
			return "resultado01matricularAlumno";

		} catch (Exception e) {
			System.out.println(e);
			return "resultadoError";
		}
	}

}