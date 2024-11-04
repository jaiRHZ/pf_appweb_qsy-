
package com.itson.interfaceDAO;

import com.itson.domain.Publicacion;
import com.itson.implementationDAO.exceptions.NonexistentEntityException;
import java.util.List;

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
