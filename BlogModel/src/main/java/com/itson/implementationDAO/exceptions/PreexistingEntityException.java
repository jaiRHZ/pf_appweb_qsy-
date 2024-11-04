package com.itson.implementationDAO.exceptions;

/**
 * Excepción personalizada para manejar situaciones en las que se intenta crear o 
 * insertar una entidad que ya existe en el contexto del sistema o la base de datos.
 * 
 * Esta excepción es útil para capturar y gestionar intentos de duplicación de datos, 
 * garantizando que no se creen registros redundantes o conflictivos.
 * 
 * @author jairo-rhz
 */
public class PreexistingEntityException extends Exception {

    /**
     * Construye una nueva instancia de {@code PreexistingEntityException} con un mensaje de
     * error específico y una causa.
     * 
     * @param message el mensaje de error detallado.
     * @param cause la causa de la excepción original, que puede ser otra excepción.
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construye una nueva instancia de {@code PreexistingEntityException} con un mensaje de error específico.
     * 
     * @param message el mensaje de error detallado.
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
