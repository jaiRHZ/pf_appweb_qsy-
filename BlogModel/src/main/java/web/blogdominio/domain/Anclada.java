package web.blogdominio.domain;

import java.io.Serializable;
import java.util.Calendar;
import jakarta.persistence.*;

/**
 * Representa una publicación "anclada" en el sistema, gestionada por un administrador.
 * Esta clase extiende de {@link Publicacion} y permite resaltar o fijar publicaciones
 * específicas, dándoles una visibilidad especial dentro del sistema.
 * 
 * <p>La clase utiliza anotaciones JPA para definir sus propiedades y relaciones
 * con otras entidades en la base de datos.</p>
 * 
 * @see Publicacion
 * @see Administrador
 * @see Entity
 * @see DiscriminatorValue
 * @see ManyToOne
 * @see JoinColumn
 * @see Serializable
 * 
 * @version 1.0
 */
@Entity
@DiscriminatorValue(value = "anclada")
public class Anclada extends Publicacion implements Serializable {

    /**
     * Referencia al administrador que creó o gestionó esta publicación anclada.
     */
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    /**
     * Constructor vacío para la clase Anclada.
     * Utilizado principalmente por JPA.
     */
    public Anclada() {
    }

    /**
     * Constructor que permite inicializar una publicación anclada con un administrador,
     * fecha de creación, título y contenido.
     * 
     * @param administrador El administrador que crea o gestiona esta publicación.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación.
     * @param titulo El título de la publicación.
     * @param contenido El contenido de la publicación.
     */
    public Anclada(Administrador administrador, String titulo, 
            String contenido) {
        super(titulo, contenido);
        this.administrador = administrador;
    }

    /**
     * Constructor que permite inicializar una publicación anclada solo con el administrador.
     * 
     * @param administrador El administrador que gestiona esta publicación.
     */
    public Anclada(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Constructor completo para inicializar una publicación anclada con todos los atributos.
     * 
     * @param administrador El administrador que gestiona esta publicación.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación.
     * @param titulo El título de la publicación.
     * @param contenido El contenido de la publicación.
     * @param fechaHoraEdicion La fecha y hora de la última edición de la publicación.
     */
    public Anclada(Administrador administrador, String titulo, 
            String contenido, Calendar fechaHoraEdicion) {
        super(titulo, contenido, fechaHoraEdicion);
        this.administrador = administrador;
    }

    /**
     * Constructor completo para inicializar una publicación anclada con un ID específico, 
     * administrador, fecha de creación, título, contenido y fecha de edición.
     * 
     * @param administrador El administrador que gestiona esta publicación.
     * @param id El identificador único de la publicación.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación.
     * @param titulo El título de la publicación.
     * @param contenido El contenido de la publicación.
     * @param fechaHoraEdicion La fecha y hora de la última edición de la publicación.
     */
    public Anclada(Administrador administrador, Long id, Calendar fechaHoraCreacion, String titulo, 
            String contenido, Calendar fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.administrador = administrador;
    }

    /**
     * Obtiene el administrador que gestiona esta publicación anclada.
     * 
     * @return El administrador de la publicación.
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Establece el administrador que gestiona esta publicación anclada.
     * 
     * @param administrador El administrador de la publicación.
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
