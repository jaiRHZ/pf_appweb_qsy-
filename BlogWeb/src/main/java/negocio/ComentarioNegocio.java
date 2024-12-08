package negocio;

import web.blogdominio.domain.Comentario;
import web.blogdominio.facade.IFacade;

public class ComentarioNegocio {
private IFacade facade;

    public ComentarioNegocio(IFacade facade) {
        this.facade = facade;
    }

    public void registrarComentario(Comentario comentario) {
        this.facade.useComentarioDAO().create(comentario);
    }
}
