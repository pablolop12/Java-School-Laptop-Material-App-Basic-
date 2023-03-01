/**
 * 
 */
package gestionPortatilesWeb.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pablo
 *
 */
@Controller
public class ControladorMenu {

	@RequestMapping(value="/menu")
    public String home() {
        return "menu";
    }

}
