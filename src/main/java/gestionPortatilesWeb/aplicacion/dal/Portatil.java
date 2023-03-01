/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dal;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Pablo López: Clase que define nuestra Entidad Portatil así como su
 *         localización en BBDD
 */
@Entity
@Table(name = "portatiles", schema = "gestion_material")
public class Portatil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private long id;
	
	@Column(name="md_uuid",nullable=false)
	private String md_uuid;
	
	@Column(name="md_date",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar md_date;
	
	@Column(name="modelo",nullable=false)
	private String modelo;
	
	@Column(name="marca",nullable=false)
	private String marca;
	
	@OneToOne(mappedBy="portatil")
	Alumno alumno;

	
	
	//GETTERS Y SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMd_uuid() {
		return md_uuid;
	}

	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}

	public Calendar getMd_date() {
		return md_date;
	}

	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	
	


	

}