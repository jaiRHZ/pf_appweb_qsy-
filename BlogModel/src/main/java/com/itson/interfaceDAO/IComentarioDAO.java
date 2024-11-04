
package com.itson.interfaceDAO;

import com.itson.domain.Comentario;
import com.itson.implementationDAO.exceptions.NonexistentEntityException;
import java.util.List;

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
