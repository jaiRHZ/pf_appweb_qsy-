
package fabrica;

import negocio.PublicacionNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author jairo-rhz
 */
public interface IFabricaNegocio {
    public UsuarioNegocio createUsuarioNegocio();

    public PublicacionNegocio createPublicacionNegocio();
}
