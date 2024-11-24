
package web.blogdominio.dao;

import java.util.List;
import web.blogdominio.dao.exceptions.NonexistentEntityException;
import web.blogdominio.domain.Publicacion;

/**
 *
 * @author jairo-rhz
 */
public interface IPublicacionDAO {
    
    public void create(Publicacion publicacion);

    public void edit(Publicacion publicacion) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Publicacion findPublicacion(Long id);

    public List<Publicacion> findPublicacionEntities();
}
