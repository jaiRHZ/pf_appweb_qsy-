package web.blogdominio.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 * Representa un administrador en el sistema, el cual puede gestionar publicaciones ancladas.
 * Extiende de la clase {@link Usuario}.
 * 
 * @see Usuario
 * @see Anclada
 * 
 */
@Entity
@DiscriminatorValue(value = "administrador")
public class Administrador extends Usuario implements Serializable {
    
    /**
     * Lista de publicaciones ancladas gestionadas por el administrador.
     */
    @OneToMany(mappedBy = "administrador")
    private List<Anclada> publicacionesAncladas;

    /**
     * Constructor vacío para JPA.
     */
    public Administrador() {
    }

    /**
     * Constructor para crear un administrador con información completa de usuario.
     * 
     * @param nombreCompleto El nombre completo del administrador.
     * @param correo El correo electrónico del administrador.
     * @param telefono El número de teléfono del administrador.
     * @param ciudad La ciudad donde reside el administrador.
     * @param fechaNacimiento La fecha de nacimiento del administrador.
     * @param genero El género del administrador.
     * @param credencial La credencial asociada al administrador.
     * @param municipio El municipio al que pertenece el administrador.
     */
    public Administrador(String nombreCompleto, String correo, String telefono, 
            String ciudad, Calendar fechaNacimiento, Genero genero, 
            Credencial credencial, Municipio municipio) {
        super(nombreCompleto, correo, telefono, ciudad, fechaNacimiento, genero, credencial, municipio);
    }

    /**
     * Constructor para crear un administrador con ID y toda la información de usuario.
     * 
     * @param id El identificador único del administrador.
     * @param nombreCompleto El nombre completo del administrador.
     * @param correo El correo electrónico del administrador.
     * @param telefono El número de teléfono del administrador.
     * @param ciudad La ciudad donde reside el administrador.
     * @param fechaNacimiento La fecha de nacimiento del administrador.
     * @param genero El género del administrador.
     * @param credencial La credencial asociada al administrador.
     * @param municipio El municipio al que pertenece el administrador.
     */
    public Administrador(Long id, String nombreCompleto, String correo, String telefono,
            String ciudad, Calendar fechaNacimiento, Genero genero, 
            Credencial credencial, Municipio municipio) {
        super(id, nombreCompleto, correo, telefono, ciudad, fechaNacimiento, genero, credencial, municipio);
    }

    /**
     * Obtiene la lista de publicaciones ancladas por el administrador.
     * 
     * @return Una lista de publicaciones de tipo {@link Anclada}.
     */
    public List<Anclada> getPublicacionesAncladas() {
        return publicacionesAncladas;
    }

    /**
     * Establece la lista de publicaciones ancladas por el administrador.
     * 
     * @param publicacionesAncladas Una lista de publicaciones de tipo {@link Anclada}.
     */
    public void setPublicacionesAncladas(List<Anclada> publicacionesAncladas) {
        this.publicacionesAncladas = publicacionesAncladas;
    }
    
}
