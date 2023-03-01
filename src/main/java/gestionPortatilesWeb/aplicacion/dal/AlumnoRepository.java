/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz para Portatil para hacer operaciones del CRUD gracias al "extends
 * CrudRepository"
 * 
 * @author Pablo
 *
 */
@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}