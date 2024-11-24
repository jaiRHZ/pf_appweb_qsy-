package web.blogdominio.conexion;

import jakarta.persistence.EntityManagerFactory;

/**
 * Interface para gestionar la conexión con la base de datos mediante JPA.
 * Proporciona un método para obtener una instancia de {@link EntityManagerFactory}.
 * 
 * Implementaciones de esta interfaz deben definir la lógica para establecer
 * y configurar la conexión a la base de datos deseada.
 * 
 * @see EntityManagerFactory
 * 
 */
public interface IConexionBD {

    /**
     * Obtiene una instancia de {@link EntityManagerFactory} configurada para
     * interactuar con la base de datos.
     * 
     * @return una instancia de {@link EntityManagerFactory} para gestionar la conexión con la base de datos.
     */
    public EntityManagerFactory usarBD();
}
