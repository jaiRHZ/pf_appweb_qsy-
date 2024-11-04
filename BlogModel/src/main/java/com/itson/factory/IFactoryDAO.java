package com.itson.factory;

import com.itson.interfaceDAO.IComentarioDAO;
import com.itson.interfaceDAO.IPublicacionDAO;
import com.itson.interfaceDAO.IUsuarioDAO;

/**
 *
 * @author jairo-rhz
 */
public interface IFactoryDAO {

    public IComentarioDAO crearComentarioDAO();

    public IPublicacionDAO crearPublicacionDAO();

    public IUsuarioDAO crearUsuarioDAO();
}
