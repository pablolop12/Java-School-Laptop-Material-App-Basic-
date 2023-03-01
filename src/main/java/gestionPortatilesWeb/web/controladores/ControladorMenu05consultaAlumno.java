/**
 * 
 */
package gestionPortatilesWeb.web.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dal.Portatil;
import gestionPortatilesWeb.aplicacion.dto.ADAO;
import gestionPortatilesWeb.aplicacion.dto.ADAOImpl;
import gestionPortatilesWeb.aplicacion.dto.ADTO;
import gestionPortatilesWeb.aplicacion.dto.ADTOImpl;
import gestionPortatilesWeb.aplicacion.services.Services;

/**
 * Controlador encargado de buscar un alumno, recibiendo un ID de Portatil
 * 
 * @author Pablo
 *
 */
@Controller
public class ControladorMenu05consultaAlumno {

	// Instancias de los métodos de conversión
	ADAO ADAO = new ADAOImpl();
	ADTO ADTO = new ADTOImpl();

	// Modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();

	@Autowired
	Services query = new Services();

	@RequestMapping(value = "/buscarAlumno")
	public String buscarAlumno(Model modelo) {
		modelo.addAttribute("idPor", new Portatil());
		return "menu05consultaAlumno";
	}

	@PostMapping(value = "/encontradoAlumno")
	public ModelAndView mostrarAlumno(@ModelAttribute("idPor") Portatil portatil, Model model) {
		try {
			Alumno alumno = new Alumno();
			alumno = query.buscarAlumnobyIdPor(portatil.getId());

			model.addAttribute("alumno", alumno);

			return new ModelAndView("resultado05consultaAlumno");
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("resultadoError");
		}
	}

}
