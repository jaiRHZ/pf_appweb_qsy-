package web.blogdominio.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

/**
 * Representa un comentario en una publicación, con posibilidad de comentarios
 * anidados y asociaciones con usuarios y publicaciones comunes.
 * Implementa la interfaz {@link Serializable}.
 * 
 * @see Normal
 * @see Comun
 * 
 */
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

    /**
     * Identificador único del comentario.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha y hora en que se creó el comentario.
     */
    @Column(name = "fechaHora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;

    /**
     * Contenido textual del comentario.
     */
    @Column(name = "contenido", nullable = false, length = 300)
    private String contenido;
    
    //----------------------RELACIONES------------------------------------------

    /**
     * Usuario normal que creó el comentario.
     */
    @ManyToOne()
    @JoinColumn(name = "usuarioNormal_id")
    private Normal usuarioNormal;

    /**
     * Publicación común a la cual pertenece el comentario.
     */
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "publicacionComun_id")
    private Comun publicacionComun;

    /**
     * Comentario padre en caso de que este comentario sea una respuesta.
     */
    @ManyToOne()
    @JoinColumn(name = "comentarioPadre_id")
    private Comentario comentarioPadre;

    /**
     * Lista de comentarios hijos en caso de que este comentario tenga respuestas.
     */
    @OneToMany(mappedBy = "comentarioPadre", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comentario> comentarios;

    /**
     * Constructor vacío para JPA.
     */
    public Comentario() {
    }

    /**
     * Constructor para crear un comentario con los detalles básicos.
     * 
     * @param fechaHora La fecha y hora de creación del comentario.
     * @param contenido El contenido textual del comentario.
     * @param usuarioNormal El usuario que crea el comentario.
     * @param publicacionComun La publicación a la que pertenece el comentario.
     */
    public Comentario(Calendar fechaHora, String contenido, Normal usuarioNormal, Comun publicacionComun) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.publicacionComun = publicacionComun;
    }

    /**
     * Constructor para crear un comentario con todos sus detalles.
     * 
     * @param id El identificador único del comentario.
     * @param fechaHora La fecha y hora de creación del comentario.
     * @param contenido El contenido textual del comentario.
     * @param usuarioNormal El usuario que crea el comentario.
     * @param publicacionComun La publicación a la que pertenece el comentario.
     * @param comentarios La lista de comentarios hijos (respuestas).
     */
    public Comentario(Long id, Calendar fechaHora, String contenido, Normal usuarioNormal, Comun publicacionComun, List<Comentario> comentarios) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.publicacionComun = publicacionComun;
        this.comentarios = comentarios;
    }

    // Getters y Setters con documentación
    /**
     * Obtiene el identificador único del comentario.
     * @return El ID del comentario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del comentario.
     * @param id El ID del comentario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de creación del comentario.
     * @return La fecha y hora de creación.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de creación del comentario.
     * @param fechaHora La fecha y hora de creación.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el contenido del comentario.
     * @return El contenido del comentario.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     * @param contenido El contenido del comentario.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el usuario que realizó el comentario.
     * @return El usuario normal que creó el comentario.
     */
    public Normal getUsuarioNormal() {
        return usuarioNormal;
    }

    /**
     * Establece el usuario que realizó el comentario.
     * @param usuarioNormal El usuario normal que creó el comentario.
     */
    public void setUsuarioNormal(Normal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    /**
     * Obtiene la publicación a la que pertenece el comentario.
     * @return La publicación común asociada al comentario.
     */
    public Comun getPublicacionComun() {
        return publicacionComun;
    }

    /**
     * Establece la publicación a la que pertenece el comentario.
     * @param publicacionComun La publicación común asociada al comentario.
     */
    public void setPublicacionComun(Comun publicacionComun) {
        this.publicacionComun = publicacionComun;
    }

    /**
     * Obtiene el comentario padre, en caso de ser una respuesta.
     * @return El comentario padre o null si no tiene.
     */
    public Comentario getComentarioPadre() {
        return comentarioPadre;
    }

    /**
     * Establece el comentario padre, en caso de ser una respuesta.
     * @param comentarioPadre El comentario padre.
     */
    public void setComentarioPadre(Comentario comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    /**
     * Obtiene la lista de respuestas asociadas a este comentario.
     * @return Lista de comentarios hijos.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de respuestas asociadas a este comentario.
     * @param comentarios Lista de comentarios hijos.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    // Métodos hashCode y equals

    /**
     * Calcula el hashCode basado en el ID.
     * @return El valor hash del comentario.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara este comentario con otro objeto para verificar igualdad por ID.
     * @param obj El objeto a comparar.
     * @return true si ambos objetos tienen el mismo ID, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        return Objects.equals(this.id, other.id);
    }

}
