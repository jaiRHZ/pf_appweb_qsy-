package web.blogdominio.factory;

import web.blogdominio.dao.IComentarioDAO;
import web.blogdominio.dao.IPublicacionDAO;
import web.blogdominio.dao.IUsuarioDAO;


/**
 *
 * @author jairo-rhz
 */
public interface IFactoryDAO {

    public IComentarioDAO crearComentarioDAO();

    public IPublicacionDAO crearPublicacionDAO();

    public IUsuarioDAO crearUsuarioDAO();
}
