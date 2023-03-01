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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gestionPortatilesWeb.aplicacion.dal.Portatil;
import gestionPortatilesWeb.aplicacion.dto.ADAO;
import gestionPortatilesWeb.aplicacion.dto.ADAOImpl;
import gestionPortatilesWeb.aplicacion.dto.PortatilDTO;
import gestionPortatilesWeb.aplicacion.services.Services;

/**
 * Controlador encargado de la inserción de un portatil en base a los datos que
 * introduzca el usuario
 * 
 * @author Pablo
 *
 */
@Controller
public class ControladorMenu03registrarPortatil {

	Map<String, Object> miModelo = new HashMap<String, Object>();
	ADAO ADAO = new ADAOImpl();

	@Autowired
	Services query = new Services();

	// Formulario de introduccion de datos
	@RequestMapping(value = "/insertPortatil")
	public String formularioCrearPortatil(Model model) {
		PortatilDTO portatilDTO = new PortatilDTO();
		model.addAttribute("nuevoPortatil", portatilDTO);
		return "menu03registrarPortatil"; // Página donde esta nuestro formulario de creación
	}

	// Vista de datos introducidos con éxito
	@RequestMapping(value = "/savedPortatil", method = RequestMethod.POST)
	public String guardarPortatil(@ModelAttribute("nuevoPortatil") PortatilDTO portatilDTO) {
		try {

			Portatil portatil = new Portatil();
			portatil = ADAO.PortatilDTOaDAO(portatilDTO); // El DTO se pasa a DAO para hacer la query

			query.crearPortatil(portatil); // Query CrearPortatil

			return "resultado03registrarPortatil"; // Página de resumen de datos introducidos
		} catch (Exception e) {
			System.out.println(e);
			return "resultadoError";
		}
	}

}
