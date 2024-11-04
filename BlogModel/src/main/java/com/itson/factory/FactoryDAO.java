
package com.itson.factory;

import com.itson.conexion.ConexionBD;
import com.itson.conexion.IConexionBD;
import com.itson.implementationDAO.ComentarioDAO;
import com.itson.implementationDAO.PublicacionDAO;
import com.itson.implementationDAO.UsuarioDAO;
import com.itson.interfaceDAO.IComentarioDAO;
import com.itson.interfaceDAO.IPublicacionDAO;
import com.itson.interfaceDAO.IUsuarioDAO;

/**
 *
 * @author jairo-rhz
 */
public class FactoryDAO implements IFactoryDAO{

     IConexionBD conexionBD;

    public FactoryDAO() {
        this.conexionBD = new ConexionBD();
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
