package com.itson.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Representa un estado en el sistema.
 * 
 * <p>La clase incluye el nombre del estado y una lista de municipios
 * asociados a él.</p>
 * 
 * <p>Se almacena en la base de datos en la tabla "estado".</p>
 * 
 * @author jairo-rhz
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {

    /**
     * Identificador único del estado.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del estado.
     * Este campo es obligatorio y tiene un límite de 150 caracteres.
     */
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    /**
     * Lista de municipios asociados al estado.
     * Relación de uno a muchos con la clase Municipio.
     */
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Municipio> municipios;

    //--------------------------------------------------------------------------
    
    /**
     * Constructor sin parámetros para crear un estado vacío.
     */
    public Estado() {
    }

    /**
     * Crea un nuevo estado con el nombre especificado.
     * 
     * @param nombre el nombre del estado
     */
    public Estado(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea un nuevo estado con el nombre y lista de municipios especificados.
     * 
     * @param nombre el nombre del estado
     * @param municipios la lista de municipios asociados al estado
     */
    public Estado(String nombre, List<Municipio> municipios) {
        this.nombre = nombre;
        this.municipios = municipios;
    }

    /**
     * Crea un nuevo estado con el id, nombre y lista de municipios especificados.
     * 
     * @param id el identificador único del estado
     * @param nombre el nombre del estado
     * @param municipios la lista de municipios asociados al estado
     */
    public Estado(Long id, String nombre, List<Municipio> municipios) {
        this.id = id;
        this.nombre = nombre;
        this.municipios = municipios;
    }

    //--------------------------------------------------------------------------

    /**
     * Obtiene el identificador del estado.
     * 
     * @return el identificador del estado
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del estado.
     * 
     * @param id el nuevo identificador del estado
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estado.
     * 
     * @return el nombre del estado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado.
     * 
     * @param nombre el nuevo nombre del estado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de municipios asociados al estado.
     * 
     * @return la lista de municipios del estado
     */
    public List<Municipio> getMunicipios() {
        return municipios;
    }

    /**
     * Establece la lista de municipios asociados al estado.
     * 
     * @param municipios la nueva lista de municipios del estado
     */
    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    /**
     * Devuelve una representación en cadena del estado.
     * 
     * @return una cadena con el id, nombre y lista de municipios del estado
     */
    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nombre=" + nombre + ", municipios=" + municipios + '}';
    }
}

