
package com.itson.facade;

import com.itson.domain.Comentario;
import com.itson.implementationDAO.exceptions.NonexistentEntityException;
import com.itson.interfaceDAO.IComentarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo-rhz
 */
public class FacadeComentarioDAO {
    IComentarioDAO comentarioDAO;

    public FacadeComentarioDAO(IComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    public Comentario create(Comentario comentario) {
        return comentarioDAO.create(comentario);
    }

    public void edit(Comentario comentario) {
        try {
            comentarioDAO.edit(comentario);
        } catch (Exception ex) {
            Logger.getLogger(FacadeComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            comentarioDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Comentario findComentario(Long id) {
        return comentarioDAO.findComentario(id);
    }

    public List<Comentario> findComentarioEntities() {
        return comentarioDAO.findComentarioEntities();
    }
}
