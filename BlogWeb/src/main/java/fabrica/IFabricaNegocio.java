
package fabrica;

import negocio.*;
import negocio.UsuarioNegocio;

/**
 *
 * @author jairo-rhz
 */
public interface IFabricaNegocio {
    public UsuarioNegocio createUsuarioNegocio();

    public PublicacionNegocio createPublicacionNegocio();
    
    public ComentarioNegocio createComentarioNegocio();
}
