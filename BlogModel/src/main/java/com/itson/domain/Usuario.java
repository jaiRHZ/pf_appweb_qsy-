package com.itson.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 * Representa un usuario en el sistema.
 *
 * <p>
 * La clase incluye información personal del usuario, como nombre completo,
 * correo electrónico, teléfono, ciudad, fecha de nacimiento, y género. También
 * está relacionada con las clases Credencial, Municipio y Comun.</p>
 *
 * <p>
 * Se almacena en una tabla única ("usuario") en la base de datos, y usa una
 * columna de discriminador para distinguir entre tipos de usuarios.</p>
 *
 * @see Credencial
 * @see Municipio
 * @see Comun
 *
 * @see Genero
 *
 * @author jairo-rhz
 */
@Entity
@Table(name = "usuario")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreCompleto", nullable = false, length = 200)
    private String nombreCompleto;

    @Column(name = "correo", nullable = false, length = 200)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 12)
    private String telefono;

    @Column(name = "ciudad", nullable = false, length = 12)
    private String ciudad;

    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private Genero genero;

    //---------------------RELACIONES-------------------------------------------
    /**
     * Credencial de autenticación asociada al usuario. Relación de uno a uno
     * con la clase Credencial.
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "credencial_id", unique = true)
    private Credencial credencial;

    /**
     * Municipio al que pertenece el usuario. Relación de muchos a uno con la
     * clase Municipio.
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;

    /**
     * Lista de publicaciones comunes asociadas al usuario. Relación de uno a
     * muchos con la clase Comun.
     */
    @OneToMany(mappedBy = "usuario")
    private List<Comun> publicacionesComunes;

    //--------------------------------------------------------------------------
    /**
     * Constructor sin parámetros para crear un usuario vacío.
     */
    public Usuario() {
    }

    /**
     * Crea un nuevo usuario con los detalles especificados.
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
    public Usuario(String nombreCompleto, String correo, String telefono, String ciudad, Calendar fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.credencial = credencial;
        this.municipio = municipio;
    }

    /**
     * Crea un nuevo usuario con el id y detalles especificados.
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
    public Usuario(Long id, String nombreCompleto, String correo, String telefono, String ciudad, Calendar fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.credencial = credencial;
        this.municipio = municipio;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return el identificador del usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id el nuevo identificador del usuario
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del usuario.
     *
     * @return el nombre completo del usuario
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombreCompleto el nuevo nombre completo del usuario
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return el correo electrónico del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo el nuevo correo electrónico del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono el nuevo número de teléfono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la ciudad de residencia del usuario.
     *
     * @return la ciudad del usuario
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de residencia del usuario.
     *
     * @param ciudad la nueva ciudad del usuario
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return la fecha de nacimiento del usuario
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento la nueva fecha de nacimiento del usuario
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el género del usuario.
     *
     * @return el género del usuario
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero el nuevo género del usuario
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la credencial asociada al usuario.
     *
     * @return la credencial del usuario
     */
    public Credencial getCredencial() {
        return credencial;
    }

    /**
     * Establece la credencial asociada al usuario.
     *
     * @param credencial la nueva credencial del usuario
     */
    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    /**
     * Obtiene el municipio de residencia del usuario.
     *
     * @return el municipio del usuario
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio de residencia del usuario.
     *
     * @param municipio el nuevo municipio del usuario
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

}
