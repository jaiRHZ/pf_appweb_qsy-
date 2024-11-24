package web.blogdominio.conexion.imp;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import web.blogdominio.conexion.IConexionBD;

/**
 * Clase que implementa la interfaz {@link IConexionBD} y proporciona
 * la configuración para establecer la conexión con la base de datos mediante JPA.
 * 
 * Esta clase sigue un patrón singleton para la creación de la instancia
 * de {@link EntityManagerFactory}, asegurando que se crea solo una vez.
 * 
 * @see IConexionBD
 * @see EntityManagerFactory
 * @see Persistence
 * 
 */
public class ConexionBDmysql implements IConexionBD {

    /**
     * Instancia única de {@link EntityManagerFactory} para gestionar la conexión con la base de datos.
     */
    private EntityManagerFactory factory;

    /**
     * Proporciona una instancia de {@link EntityManagerFactory}. Si la instancia aún no se ha creado,
     * la inicializa usando la configuración definida en el archivo de persistencia.
     * 
     * @return la instancia de {@link EntityManagerFactory} configurada para la conexión con la base de datos.
     */
    @Override
    public EntityManagerFactory usarBD() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("persistencia");
        }
        return factory;
    }
}
