/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dto;

import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dal.Portatil;

/**
 * @author Pablo: Interfaz que convierte DTO a DAO (Alumno & Portatil)
 *
 */
public interface ADAO {
	
	public Alumno AlumnoDTOaDAO (AlumnoDTO alumnoDTO);
	
	public Portatil PortatilDTOaDAO (PortatilDTO portatilDTO);

}