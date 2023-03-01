/**
 * 
 */
package gestionPortatilesWeb.aplicacion.dal;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz para Portatil para hacer operaciones del CRUD gracias al "extends
 * CrudRepository"
 * 
 * @author Pablo
 */
@Repository
public interface PortatilRepository extends CrudRepository<Portatil, Long> {

}
