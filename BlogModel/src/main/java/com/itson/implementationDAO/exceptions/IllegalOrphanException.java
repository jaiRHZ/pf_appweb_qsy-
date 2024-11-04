package com.itson.implementationDAO.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Excepción personalizada para manejar situaciones en las que se encuentran
 * referencias huérfanas ilegales en operaciones de base de datos o entidad.
 * 
 * Esta excepción contiene una lista de mensajes que explican los errores específicos 
 * relacionados con la operación fallida, lo que permite una mayor claridad al 
 * gestionar errores complejos.
 * 
 * @author jairo-rhz
 */
public class IllegalOrphanException extends Exception {

    /**
     * Lista de mensajes que describen cada una de las razones por las cuales
     * se lanzó esta excepción.
     */
    private List<String> messages;

    /**
     * Construye una nueva instancia de {@code IllegalOrphanException} con una lista
     * de mensajes de error. Si la lista está vacía, el mensaje de la excepción será {@code null}.
     *
     * @param messages Lista de cadenas de texto que describen los motivos de la excepción.
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<>();
        } else {
            this.messages = messages;
        }
    }

    /**
     * Obtiene la lista de mensajes de error asociados a esta excepción.
     *
     * @return una lista de mensajes de error que explican las causas de la excepción.
     */
    public List<String> getMessages() {
        return messages;
    }
}
