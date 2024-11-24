
package web.blogdominio.facade;

import web.blogdominio.facade.imp.FacadePublicacionDAO;
import web.blogdominio.facade.imp.FacadeUsuarioDAO;
import web.blogdominio.facade.imp.FacadeComentarioDAO;

/**
 *
 * @author jairo-rhz
 */
public interface IFacade {
    public FacadeComentarioDAO useComentarioDAO();

    public FacadePublicacionDAO usePublicacionDAO();

    public FacadeUsuarioDAO useUsuarioDAO();
}
