package web.blogdominio.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import jakarta.persistence.*;

/**
 * Representa una publicación de tipo "común" en el sistema, la cual es creada
 * por un usuario y puede tener múltiples comentarios.
 * 
 * <p>La clase `Comun` extiende a `Publicacion` y representa publicaciones estándar
 * realizadas por usuarios del sistema. Cada publicación común está asociada
 * a un usuario específico y puede tener una lista de comentarios.</p>
 * 
 * @see Publicacion
 * @see Usuario
 * @see Comentario
 * 
 * @see Entity
 * @see ManyToOne
 * @see OneToMany
 * 
 * @see DiscriminatorValue
 * 
 * @see JoinColumn
 * 
 * @see Column
 * 
 * @see TemporalType
 * @see Id
 * @see GeneratedValue
 * 
 * @see TemporalType
 * @see Column
 * 
 * @see GeneratedValue
 * 
 * @see CascadeType
 * @see List
 * 
 * @see Serializable
 * @author 
 * 
 * 
 */
@Entity
@DiscriminatorValue(value = "comun")
public class Comun extends Publicacion implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "publicacionComun", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    /**
     * Constructor sin parámetros para crear una publicación común vacía.
     */
    public Comun() {
    }

    /**
     * Crea una publicación común con el usuario especificado.
     * 
     * @param usuario el usuario que creó la publicación
     */
    public Comun(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Crea una publicación común con el usuario, fecha de creación, título y contenido.
     * 
     * @param usuario el usuario que creó la publicación
     * @param fechaHoraCreacion la fecha y hora de creación de la publicación
     * @param titulo el título de la publicación
     * @param contenido el contenido de la publicación
     */
    public Comun(Usuario usuario, String titulo, String contenido) {
        super(titulo, contenido);
        this.usuario = usuario;
    }

    /**
     * Crea una publicación común con la fecha de creación, título y contenido especificados.
     * 
     * @param fechaHoraCreacion la fecha y hora de creación de la publicación
     * @param titulo el título de la publicación
     * @param contenido el contenido de la publicación
     */
    public Comun(String titulo, String contenido) {
        super(titulo, contenido);
    }

    /**
     * Crea una publicación común con todos los atributos especificados.
     * 
     * @param usuario el usuario que creó la publicación
     * @param id el identificador único de la publicación
     * @param fechaHoraCreacion la fecha y hora de creación de la publicación
     * @param titulo el título de la publicación
     * @param contenido el contenido de la publicación
     * @param fechaHoraEdicion la fecha y hora de la última edición de la publicación
     */
    public Comun(Usuario usuario, Long id, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    public Comun(Usuario usuario, String titulo, String contenido, String url) {
        super(titulo, contenido, url);
        this.usuario = usuario;
    }

    
    /**
     * Obtiene el usuario que creó la publicación.
     * 
     * @return el usuario creador de la publicación
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que creó la publicación.
     * 
     * @param usuario el nuevo usuario creador de la publicación
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de comentarios asociados a la publicación.
     * 
     * @return la lista de comentarios de la publicación
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de comentarios asociados a la publicación.
     * 
     * @param comentarios la nueva lista de comentarios de la publicación
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
}
