
package com.itson.facade;

/**
 *
 * @author jairo-rhz
 */
public interface IFacade {
    public FacadeComentarioDAO useComentarioDAO();

    public FacadePublicacionDAO usePublicacionDAO();

    public FacadeUsuarioDAO useUsuarioDAO();
}
