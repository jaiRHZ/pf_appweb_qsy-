package test;

import web.blogdominio.domain.Credencial;
import web.blogdominio.domain.*;
import web.blogdominio.facade.imp.Facade;
import java.util.Calendar;

public class TestUsuario {
    public static void main(String[] args) {
        Facade faceid = new Facade();
        Administrador usuario = new Administrador("Pol", "pol@pol", "12345678", "obregon", Calendar.getInstance(), Genero.MASCULINO, new Credencial("poliester", "123456789"), new Municipio("Cajeme", new Estado("Sonora")));
        faceid.useUsuarioDAO().create(usuario);
    }
}
