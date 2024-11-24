
package web.blogdominio.dao;

import java.util.List;
import web.blogdominio.dao.exceptions.NonexistentEntityException;
import web.blogdominio.domain.Usuario;

/**
 *
 * @author jairo-rhz
 */
public interface IUsuarioDAO {
    
    public Usuario create(Usuario usuario);

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Usuario findUsuario(Long id);

    public List<Usuario> findUsuarioEntities();
}
