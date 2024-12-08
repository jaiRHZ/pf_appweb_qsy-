package negocio;

import java.util.ArrayList;
import java.util.List;
import web.blogdominio.domain.Anclada;
import web.blogdominio.domain.Comun;
import web.blogdominio.domain.Publicacion;
import web.blogdominio.facade.IFacade;

/**
 *
 * @author jairo-rhz
 */
public class PublicacionNegocio {

    private IFacade facade;

    public PublicacionNegocio(IFacade facade) {
        this.facade = facade;
    }

    public void registrarPublicacion(Publicacion publicacion) {
        this.facade.usePublicacionDAO().create(publicacion);
    }

    public List<Comun> consultarPublicacionesComunes() {
        List<Publicacion> publicaciones = facade.usePublicacionDAO().findPublicacionEntities();
        List<Comun> publicacionesComunes = new ArrayList<>();
        for (int i = 0; i < publicaciones.size(); i++) {
            if (publicaciones.get(i) instanceof Comun) {
                publicacionesComunes.add((Comun) publicaciones.get(i));
            }
        }
        return publicacionesComunes;
    }

    public List<Anclada> consultarPublicacionesAncladas() {
        List<Publicacion> publicaciones = facade.usePublicacionDAO().findPublicacionEntities();
        List<Anclada> publicacionesAncladas = new ArrayList<>();
        for (int i = 0; i < publicaciones.size(); i++) {
            if (publicaciones.get(i) instanceof Anclada) {
                publicacionesAncladas.add((Anclada) publicaciones.get(i));
            }
        }
        return publicacionesAncladas;
    }
    
    public Comun consultarPublicacionComunId(Long id){
        return (Comun) facade.usePublicacionDAO().findPublicacion(id);
    }
    
    public void eliminarPublicacion(Long id){
        facade.usePublicacionDAO().destroy(id);
    }
    
}
