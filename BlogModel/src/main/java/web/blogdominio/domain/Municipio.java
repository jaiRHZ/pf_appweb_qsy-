package web.blogdominio.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 * Representa un municipio en el sistema.
 * 
 * <p>La clase incluye el nombre del municipio y está asociado a un estado. 
 * Además, contiene una lista de usuarios que residen en el municipio.</p>
 * 
 * <p>Se almacena en la base de datos en la tabla "municipio".</p>
 * 
 * @see Estado
 * @see Usuario
 * 
 * @author jairo-rhz
 */
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {

    /**
     * Identificador único del municipio.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del municipio.
     * Este campo es obligatorio y tiene un límite de 200 caracteres.
     */
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    
    /**
     * Estado al que pertenece el municipio.
     * Relación de muchos a uno con la clase Estado.
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "estado_id")
    private Estado estado;
    
    /**
     * Lista de usuarios que residen en el municipio.
     * Relación de uno a muchos con la clase Usuario.
     */
    @OneToMany(mappedBy = "municipio")
    private List<Usuario> usuarios;

    /**
     * Constructor sin parámetros para crear un municipio vacío.
     */
    public Municipio() {
    }

    /**
     * Crea un nuevo municipio con el nombre y el estado especificados.
     * 
     * @param nombre el nombre del municipio
     * @param estado el estado al que pertenece el municipio
     */
    public Municipio(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    /**
     * Crea un nuevo municipio con el nombre, estado y lista de usuarios especificados.
     * 
     * @param nombre el nombre del municipio
     * @param estado el estado al que pertenece el municipio
     * @param usuarios la lista de usuarios que residen en el municipio
     */
    public Municipio(String nombre, Estado estado, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    /**
     * Crea un nuevo municipio con el id, nombre, estado y lista de usuarios especificados.
     * 
     * @param id el identificador único del municipio
     * @param nombre el nombre del municipio
     * @param estado el estado al que pertenece el municipio
     * @param usuarios la lista de usuarios que residen en el municipio
     */
    public Municipio(Long id, String nombre, Estado estado, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    /**
     * Obtiene el identificador del municipio.
     * 
     * @return el identificador del municipio
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del municipio.
     * 
     * @param id el nuevo identificador del municipio
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del municipio.
     * 
     * @return el nombre del municipio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio.
     * 
     * @param nombre el nuevo nombre del municipio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el estado al que pertenece el municipio.
     * 
     * @return el estado del municipio
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado al que pertenece el municipio.
     * 
     * @param estado el nuevo estado del municipio
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la lista de usuarios que residen en el municipio.
     * 
     * @return la lista de usuarios del municipio
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios que residen en el municipio.
     * 
     * @param usuarios la nueva lista de usuarios del municipio
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Calcula el código hash del municipio en base a su identificador.
     * 
     * @return el código hash del municipio
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara este municipio con otro objeto para verificar su igualdad.
     * Dos municipios se consideran iguales si tienen el mismo identificador.
     * 
     * @param obj el objeto a comparar con este municipio
     * @return {@code true} si los objetos son iguales; {@code false} en caso contrario
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
        final Municipio other = (Municipio) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve una representación en cadena del municipio.
     * 
     * @return una cadena con el id, nombre, estado y lista de usuarios del municipio
     */
    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", usuarios=" + usuarios + '}';
    }
}
