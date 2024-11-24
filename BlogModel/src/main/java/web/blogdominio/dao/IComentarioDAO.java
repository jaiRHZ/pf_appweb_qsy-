
package web.blogdominio.dao;

import java.util.List;
import web.blogdominio.dao.exceptions.NonexistentEntityException;
import web.blogdominio.domain.Comentario;

/**
 *
 * @author jairo-rhz
 */
public interface IComentarioDAO {
    public Comentario create(Comentario comentario);

    public void edit(Comentario comentario) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Comentario findComentario(Long id);

    public List<Comentario> findComentarioEntities();
}
