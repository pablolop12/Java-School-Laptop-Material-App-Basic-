/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dto;



import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dal.Portatil;

/**
 * @author Pablo: Interfaz que convierte DAO a DTO (Alumno & Portatil)
 *
 */
public interface ADTO {

	public AlumnoDTO AlumnoDAOaDTO (Alumno alumno);
	
	
	public PortatilDTO PortatilDAOaDTO (Portatil portatil);
}