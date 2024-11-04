
package com.itson.facade;

import com.itson.domain.Publicacion;
import com.itson.implementationDAO.exceptions.NonexistentEntityException;
import com.itson.interfaceDAO.IPublicacionDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo-rhz
 */
public class FacadePublicacionDAO {
    IPublicacionDAO publicacionDAO;

    public FacadePublicacionDAO(IPublicacionDAO publicacionDAO) {
        this.publicacionDAO = publicacionDAO;
    }

    public void create(Publicacion publicacion) {
        publicacionDAO.create(publicacion);
    }

    public void edit(Publicacion publicacion) {
        try {
            publicacionDAO.edit(publicacion);
        } catch (Exception ex) {
            Logger.getLogger(FacadePublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            publicacionDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadePublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Publicacion findPublicacion(Long id) {
        return publicacionDAO.findPublicacion(id);
    }

    public List<Publicacion> findPublicacionEntities() {
        return publicacionDAO.findPublicacionEntities();
    }
}
