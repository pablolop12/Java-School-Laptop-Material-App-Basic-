/**
 * 
 */
package gestionPortatilesWeb;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import gestionPortatilesWeb.aplicacion.AplicacionConfiguracionContexto;
import gestionPortatilesWeb.web.WebConfiguracionContexto;


/**
 * @author Pablo
 *
 */
public class EnrutadorGestionPortatiles extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AplicacionConfiguracionContexto.class };

	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfiguracionContexto.class };
	}

	@Override
	protected String[] getServletMappings() {
        return new String[] { "/" };
	}

}
