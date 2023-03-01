/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dto;


import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dal.Portatil;

/**
 * @author Pablo: Clase que Implementa la Interfaz que convierte DAO a DTO y
 *         recopila los datos
 *
 */


public class ADTOImpl implements ADTO {

	
	//Recopila datos y los almacena en DTO
	@Override
	public AlumnoDTO AlumnoDAOaDTO(Alumno alumno) {
		return new AlumnoDTO(alumno.getId(), alumno.getNombre(), alumno.getTelefono(), alumno.getPortatil());
	}

	//Recopila datos y los almacena en DTO
	@Override
	public PortatilDTO PortatilDAOaDTO(Portatil portatil) {
		return new PortatilDTO(portatil.getId(), portatil.getMarca(), portatil.getModelo());

	}
	

}