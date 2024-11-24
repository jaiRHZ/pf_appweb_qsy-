
package web.blogdominio.factory.imp;

import web.blogdominio.conexion.imp.ConexionBDmysql;
import web.blogdominio.conexion.IConexionBD;
import web.blogdominio.dao.IComentarioDAO;
import web.blogdominio.dao.IPublicacionDAO;
import web.blogdominio.dao.IUsuarioDAO;
import web.blogdominio.dao.imp.ComentarioDAO;
import web.blogdominio.dao.imp.PublicacionDAO;
import web.blogdominio.dao.imp.UsuarioDAO;
import web.blogdominio.factory.IFactoryDAO;


/**
 *
 * @author jairo-rhz
 */
public class FactoryDAO implements IFactoryDAO{

     IConexionBD conexionBD;

    public FactoryDAO() {
        this.conexionBD = new ConexionBDmysql();
    }

    @Override
    public IComentarioDAO crearComentarioDAO() {
        return new ComentarioDAO(conexionBD.usarBD());
    }

    @Override
    public IPublicacionDAO crearPublicacionDAO() {
        return new PublicacionDAO(conexionBD.usarBD());
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO() {
        return new UsuarioDAO(conexionBD.usarBD());
    }
    
}
