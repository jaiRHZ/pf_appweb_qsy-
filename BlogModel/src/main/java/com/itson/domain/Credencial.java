package com.itson.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Representa una credencial en el sistema. La clase incluye información de
 * autenticación como el avatar del usuario y su contraseña. Se almacena en la
 * base de datos en la tabla "credencial".
 *
 * @author jairo-rhz
 */
@Entity
@Table(name = "credencial")
public class Credencial implements Serializable {

    /**
     * Identificador único de la credencial.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * URL o nombre del avatar del usuario. Debe ser único y no nulo.
     */
    @Column(name = "avatar", nullable = false, length = 200, unique = true)
    private String avatar;

    /**
     * Contraseña del usuario. Es un campo obligatorio y tiene un límite de 200
     * caracteres.
     */
    @Column(name = "contrasenia", nullable = false, length = 200)
    private String contrasenia;

    //--------------------------------------------------------------------------
    /**
     * Constructor sin parámetros para crear una credencial vacía.
     */
    public Credencial() {
    }

    /**
     * Crea una nueva credencial con el avatar y la contraseña especificados.
     *
     * @param avatar el avatar del usuario
     * @param contrasenia la contraseña del usuario
     */
    public Credencial(String avatar, String contrasenia) {
        this.avatar = avatar;
        this.contrasenia = contrasenia;
    }

    /**
     * Crea una nueva credencial con el id, avatar y contraseña especificados.
     *
     * @param id el identificador único de la credencial
     * @param avatar el avatar del usuario
     * @param contrasenia la contraseña del usuario
     */
    public Credencial(Long id, String avatar, String contrasenia) {
        this.id = id;
        this.avatar = avatar;
        this.contrasenia = contrasenia;
    }

    //--------------------------------------------------------------------------
    /**
     * Obtiene el identificador de la credencial.
     *
     * @return el identificador de la credencial
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la credencial.
     *
     * @param id el nuevo identificador de la credencial
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el avatar del usuario.
     *
     * @return el avatar del usuario
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Establece el avatar del usuario.
     *
     * @param avatar el nuevo avatar del usuario
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return la contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia la nueva contraseña del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
