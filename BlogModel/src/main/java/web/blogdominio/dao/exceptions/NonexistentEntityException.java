package web.blogdominio.dao.exceptions;

/**
 * Excepción personalizada para manejar situaciones en las que una entidad solicitada
 * no existe en el contexto de la operación realizada.
 * 
 * Esta excepción puede ser utilizada para capturar y gestionar intentos de acceso o 
 * modificación de entidades que no se encuentran en la base de datos o en el sistema.
 * 
 * @author jairo-rhz
 */
public class NonexistentEntityException extends Exception {

    /**
     * Construye una nueva instancia de {@code NonexistentEntityException} con un mensaje de
     * error específico y una causa.
     * 
     * @param message el mensaje de error detallado.
     * @param cause la causa de la excepción original, que puede ser otra excepción.
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construye una nueva instancia de {@code NonexistentEntityException} con un mensaje de error específico.
     * 
     * @param message el mensaje de error detallado.
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
