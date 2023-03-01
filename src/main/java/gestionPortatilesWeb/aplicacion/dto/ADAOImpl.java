/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dto;

import java.util.Calendar;

import gestionPortatilesWeb.aplicacion.dal.Alumno;
import gestionPortatilesWeb.aplicacion.dal.Portatil;

/**
 * @author Pablo: Implementa el método que convierte DTO a DAO
 *
 */
public class ADAOImpl implements ADAO {
	
	Calendar fecha = Calendar.getInstance();


	@Override
	public Alumno AlumnoDTOaDAO(AlumnoDTO alumnoDTO) {
		String md_uuid = java.util.UUID.randomUUID().toString();//Generación de md_uuid random
		Alumno alumno = new Alumno();
		
		if (alumnoDTO != null) {
			alumno.setMd_uuid(md_uuid);//Se introduce el numero random generado arriba
			alumno.setMd_date(fecha);
			alumno.setNombre(alumnoDTO.getNombre());
			alumno.setTelefono(alumnoDTO.getTelefono());
			alumno.setPortatil(alumnoDTO.getPortatil());
		}
		
		//Para testear los datos de Alumno Introducidos
		System.out.println("AlumnoDTO nombre: " + alumnoDTO.getNombre());
	    System.out.println("AlumnoDTO telefono: " + alumnoDTO.getTelefono());
	    System.out.println("AlumnoDTO portatil: " + alumnoDTO.getPortatil());
	    System.out.println("Alumno marca: " + alumno.getNombre());
	    System.out.println("Alumno modelo: " + alumno.getTelefono());
	    System.out.println("Alumno portatil: " + alumno.getPortatil());

		return alumno;
	}

	@Override
	public Portatil PortatilDTOaDAO(PortatilDTO portatilDTO) {
		String md_uuid = java.util.UUID.randomUUID().toString();//Generación de md_uuid random
		Portatil portatil = new Portatil();
		if (portatilDTO !=null) {
			portatil.setMd_uuid(md_uuid);//Se introduce el numero random generado arriba
			portatil.setMd_date(fecha);
			portatil.setMarca(portatilDTO.getMarca());;
			portatil.setModelo(portatilDTO.getModelo());
		}
		
		//Para testear los datos de Portatil Introducidos
		System.out.println("PortatilDTO marca: " + portatilDTO.getMarca());
	    System.out.println("PortatilDTO modelo: " + portatilDTO.getModelo());
	    System.out.println("Portatil marca: " + portatil.getMarca());
	    System.out.println("Portatil modelo: " + portatil.getModelo());
	    
		return portatil;
	}

}