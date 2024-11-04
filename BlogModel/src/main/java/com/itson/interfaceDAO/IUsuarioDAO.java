
package com.itson.interfaceDAO;

import com.itson.domain.Usuario;
import com.itson.implementationDAO.exceptions.NonexistentEntityException;
import java.util.List;

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
