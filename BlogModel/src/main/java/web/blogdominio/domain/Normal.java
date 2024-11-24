package web.blogdominio.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;

/**
 * Representa a un usuario de tipo "normal" en el sistema, extendiendo la clase {@link Usuario}.
 * 
 * <p>Esta clase añade una relación de uno a muchos con la clase {@link Comentario}, 
 * lo que permite que los usuarios normales puedan tener una lista de comentarios asociados.</p>
 * 
 * @see Usuario
 * @see Comentario
 * 
 * @see Credencial
 * @see Municipio
 * @see Genero
 * 
 * @see Calendar
 * 
 * @author jairo-rhz
 */
@Entity
@DiscriminatorValue(value = "normal")
public class Normal extends Usuario implements Serializable {
    
    /**
     * Lista de comentarios realizados por el usuario normal.
     */
    @OneToMany(mappedBy = "usuarioNormal", cascade = CascadeType.REMOVE)
    private List<Comentario> comentarios;

    /**
     * Constructor sin parámetros para crear un usuario normal vacío.
     */
    public Normal() {
    }

    /**
     * Crea un usuario normal con los detalles especificados.
     * 
     * @param nombreCompleto el nombre completo del usuario
     * @param correo el correo electrónico del usuario
     * @param telefono el número de teléfono del usuario
     * @param ciudad la ciudad de residencia del usuario
     * @param fechaNacimiento la fecha de nacimiento del usuario
     * @param genero el género del usuario
     * @param credencial la credencial asociada al usuario
     * @param municipio el municipio de residencia del usuario
     */
    public Normal(String nombreCompleto, String correo, String telefono,
            String ciudad, Calendar fechaNacimiento, Genero genero, 
            Credencial credencial, Municipio municipio) {
        super(nombreCompleto, correo, telefono, ciudad, fechaNacimiento, genero, 
                credencial, municipio);
    }

    /**
     * Crea un usuario normal con el id y detalles especificados.
     * 
     * @param id el identificador único del usuario
     * @param nombreCompleto el nombre completo del usuario
     * @param correo el correo electrónico del usuario
     * @param telefono el número de teléfono del usuario
     * @param ciudad la ciudad de residencia del usuario
     * @param fechaNacimiento la fecha de nacimiento del usuario
     * @param genero el género del usuario
     * @param credencial la credencial asociada al usuario
     * @param municipio el municipio de residencia del usuario
     */
    public Normal(Long id, String nombreCompleto, String correo, String telefono, 
            String ciudad, Calendar fechaNacimiento, Genero genero, 
            Credencial credencial, Municipio municipio) {
        super(id, nombreCompleto, correo, telefono, ciudad, fechaNacimiento, 
                genero, credencial, municipio);
    }

    /**
     * Obtiene la lista de comentarios realizados por el usuario.
     * 
     * @return la lista de comentarios del usuario
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de comentarios realizados por el usuario.
     * 
     * @param comentarios la nueva lista de comentarios del usuario
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Object getComenatarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
