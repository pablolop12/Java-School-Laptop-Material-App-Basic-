/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dto;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import gestionPortatilesWeb.aplicacion.dal.Alumno;

/**
 * @author Pablo: DTO de Portatil
 *
 */
@Service
public class PortatilDTO {
	
	//ATRIBUTOS
	private Long id;
	private Calendar md_date;
	private String marca;
	private String modelo;
	Alumno alumno;
	
	//CONSTRUCTOR 
	public PortatilDTO(Calendar md_date,String marca, String modelo) {
		super();
		this.md_date = md_date; 
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	
	
	public PortatilDTO(Long id, String marca, String modelo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
	}




	public PortatilDTO() {
		super();
	}



	//GETTERS Y SETTERS
	/**
	 * md_date provisional getter y setters
	 */
	public Calendar getMd_date() {
		return md_date;
	}

	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	//TOSTRING
	@Override
	public String toString() {
		return "Portatil:  [ ID:" + id + "] [ Marca:" + marca + "] [ Modelo:" + modelo + "] ";
	}
	
	
	
	

	
}