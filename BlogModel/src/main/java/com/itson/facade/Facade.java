
package com.itson.facade;

import com.itson.factory.FactoryDAO;
import com.itson.factory.IFactoryDAO;

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
