
package web.blogdominio.facade.imp;

import web.blogdominio.facade.IFacade;
import web.blogdominio.factory.IFactoryDAO;
import web.blogdominio.factory.imp.FactoryDAO;

/**
 *
 * @author jairo-rhz
 */
public class Facade implements IFacade{

    IFactoryDAO factoryDAO;

    public Facade() {
        this.factoryDAO = new FactoryDAO();
    }

    @Override
    public FacadeComentarioDAO useComentarioDAO() {
        return new FacadeComentarioDAO(factoryDAO.crearComentarioDAO());
    }

    @Override
    public FacadePublicacionDAO usePublicacionDAO() {
        return new FacadePublicacionDAO(factoryDAO.crearPublicacionDAO());
    }

    @Override
    public FacadeUsuarioDAO useUsuarioDAO() {
        return new FacadeUsuarioDAO(factoryDAO.crearUsuarioDAO());
    }
    
}
