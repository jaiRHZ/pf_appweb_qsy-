
package negocio;

import java.util.List;
import web.blogdominio.domain.Usuario;
import web.blogdominio.facade.IFacade;

/**
 *
 * @author jairo-rhz
 */
public class UsuarioNegocio {
    private IFacade facade;

    public UsuarioNegocio(IFacade facade) {
        this.facade = facade;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return this.facade.useUsuarioDAO().create(usuario);
    }

    public Usuario validarInicioUsuario(String avatar, String contrasenia) {
        List<Usuario> usuarios = facade.useUsuarioDAO().findUsuarioEntities();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCredencial().getAvatar().equals(avatar)
                    && usuarios.get(i).getCredencial().getContrasenia().equals(contrasenia)) {
                return usuarios.get(i);
            }
        }
        return null;
    }
}
