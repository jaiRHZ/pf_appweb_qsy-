package web.blogdominio.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import jakarta.persistence.*;

/**
 * Representa una publicación en el sistema, que contiene un título, contenido,
 * y fechas de creación y edición.
 * 
 * <p>Esta clase es una entidad persistente en la base de datos, mapeada a la 
 * tabla "publicacion". Cada publicación tiene un título y contenido, y puede
 * ser editada con una nueva fecha de edición.</p>
 * 
 * @see Calendar
 * @see Serializable
 * 
 * @see Entity
 * 
 * @see Table
 * @see Column
 * 
 * @see Id
 * 
 * @see GeneratedValue
 * @see TemporalType
 * 
 * @author jairo-rhz
 */
@Entity
@Table(name = "publicacion")
public class Publicacion implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaCreacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHoraCreacion;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "contenido", nullable = false, length = 1000)
    private String contenido;

    @Column(name = "fechaEdicion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHoraEdicion;
    
    @Column(name = "url", nullable = true, length = 1000)
    private String url;

    /**
     * Constructor sin parámetros para crear una publicación vacía.
     */
    public Publicacion() {
    }

    /**
     * Crea una publicación con la fecha de creación, título y contenido especificados.
     * 
     * @param titulo el título de la publicación
     * @param contenido el contenido de la publicación
     */
    public Publicacion(String titulo, String contenido) {
        this.fechaHoraCreacion = Calendar.getInstance();
        this.titulo = titulo;
        this.contenido = contenido;
    }

    /**
     * Crea una publicación con la fecha de creación, título, contenido y fecha de edición.
     * 
     * @param titulo el título de la publicación
     * @param contenido el contenido de la publicación
     * @param fechaHoraEdicion la fecha y hora de edición de la publicación
     */
    public Publicacion(String titulo, String contenido, Calendar fechaHoraEdicion) {
        this.fechaHoraCreacion = Calendar.getInstance();
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Crea una publicación con el id, fecha de creación, título, contenido y fecha de edición especificados.
     * 
     * @param id el identificador único de la publicación
     * @param fechaHoraCreacion la fecha y hora de creación de la publicación
     * @param titulo el título de la publicación
     * @param contenido el contenido de la publicación
     * @param fechaHoraEdicion la fecha y hora de edición de la publicación
     */
    public Publicacion(Long id, Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public Publicacion(String titulo, String contenido, String url) {
        this.fechaHoraCreacion = Calendar.getInstance();
        this.titulo = titulo;
        this.contenido = contenido;
        this.url = url;
    }
    
    

    /**
     * Obtiene el identificador único de la publicación.
     * 
     * @return el id de la publicación
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la publicación.
     * 
     * @param id el nuevo id de la publicación
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de creación de la publicación.
     * 
     * @return la fecha y hora de creación
     */
    public Calendar getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y hora de creación de la publicación.
     * 
     * @param fechaHoraCreacion la nueva fecha y hora de creación
     */
    public void setFechaHoraCreacion(Calendar fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     * Obtiene el título de la publicación.
     * 
     * @return el título de la publicación
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la publicación.
     * 
     * @param titulo el nuevo título de la publicación
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el contenido de la publicación.
     * 
     * @return el contenido de la publicación
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido de la publicación.
     * 
     * @param contenido el nuevo contenido de la publicación
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene la fecha y hora de la última edición de la publicación.
     * 
     * @return la fecha y hora de edición
     */
    public Calendar getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece la fecha y hora de la última edición de la publicación.
     * 
     * @param fechaHoraEdicion la nueva fecha y hora de edición
     */
    public void setFechaHoraEdicion(Calendar fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + ", url=" + url + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
        final Publicacion other = (Publicacion) obj;
        return Objects.equals(this.id, other.id);
    }
      
}
