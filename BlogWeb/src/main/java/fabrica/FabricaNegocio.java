
package fabrica;

import negocio.PublicacionNegocio;
import negocio.UsuarioNegocio;
import web.blogdominio.facade.IFacade;
import web.blogdominio.facade.imp.Facade;

/**
 *
 * @author jairo-rhz
 */
public class FabricaNegocio implements IFabricaNegocio{

IFacade facade;

    public FabricaNegocio() {
        this.facade = new Facade();
    }

    @Override
    public UsuarioNegocio createUsuarioNegocio() {
        return new UsuarioNegocio(facade);
    }

    @Override
    public PublicacionNegocio createPublicacionNegocio() {
        return new PublicacionNegocio(facade);
    }

    
}
