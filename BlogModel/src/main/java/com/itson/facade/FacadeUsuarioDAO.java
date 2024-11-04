
package com.itson.facade;

import com.itson.domain.Usuario;
import com.itson.implementationDAO.exceptions.NonexistentEntityException;
import com.itson.interfaceDAO.IUsuarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo-rhz
 */
public class FacadeUsuarioDAO {
    IUsuarioDAO usuarioDAO;

    public FacadeUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario create(Usuario usuario) {
        return usuarioDAO.create(usuario);
    }

    public void edit(Usuario usuario) {
        try {
            usuarioDAO.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(FacadeUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            usuarioDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario findUsuario(Long id) {
        return usuarioDAO.findUsuario(id);
    }

    public List<Usuario> findUsuarioEntities() {
        return usuarioDAO.findUsuarioEntities();
    }
}
