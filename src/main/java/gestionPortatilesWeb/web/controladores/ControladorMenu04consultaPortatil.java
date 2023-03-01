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

import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dal.Portatil;
import gestionPortatilesWeb.aplicacion.dto.ADAO;
import gestionPortatilesWeb.aplicacion.dto.ADAOImpl;
import gestionPortatilesWeb.aplicacion.dto.ADTO;
import gestionPortatilesWeb.aplicacion.dto.ADTOImpl;
import gestionPortatilesWeb.aplicacion.services.Services;

/**
 * Controlador encargado de buscar un portatil, recibiendo un ID de Alumno
 * 
 * @author Pablo
 *
 */
@Controller
public class ControladorMenu04consultaPortatil {

	// Instancias de los métodos de conversión
	ADAO ADAO = new ADAOImpl();
	ADTO ADTO = new ADTOImpl();

	// Modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();

	@Autowired
	Services query = new Services();

	// Formulario de introducción de datos
	@RequestMapping(value = "/buscarPortatil")
	public String buscarPortatil(Model modelo) {
		modelo.addAttribute("idAlu", new Alumno());
		return "menu04consultaPortatil";
	}

	// Vista de resultado
	@PostMapping(value = "/encontradoPortatil")
	public String mostrarPortatil(@ModelAttribute("idAlu") Alumno alumno, Model model) {

		try {
			Portatil portatil = new Portatil();
			portatil = query.buscarPortatilbyIdAlu(alumno.getId()); // Query de busqueda

			model.addAttribute("portatil", portatil);

			return ("resultado04consultaPortatil");
		} catch (Exception e) {
			System.out.println(e);
			return "resultadoError";
		}
	}

}
