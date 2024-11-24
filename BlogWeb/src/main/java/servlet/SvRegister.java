
package servlet;

import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import web.blogdominio.domain.Anclada;
import web.blogdominio.domain.Comun;
import web.blogdominio.domain.Credencial;
import web.blogdominio.domain.Estado;
import web.blogdominio.domain.Genero;
import web.blogdominio.domain.Municipio;
import web.blogdominio.domain.Normal;

/**
 *
 * @author jairo-rhz
 */
public class SvRegister extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreCompleto = request.getParameter("nombreCompleto");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String estado = request.getParameter("estado");
        String ciudad = request.getParameter("ciudad");
        String municipio = request.getParameter("municipio");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String genero = request.getParameter("genero");
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        Normal usuarioNormal = new Normal();
        usuarioNormal.setNombreCompleto(nombreCompleto);
        usuarioNormal.setCredencial(new Credencial(usuario, contrasenia));
        usuarioNormal.setTelefono(telefono);
        usuarioNormal.setCorreo(email);
        usuarioNormal.setMunicipio(
                new Municipio(municipio, new Estado(estado)));
        usuarioNormal.setCiudad(ciudad);
        if (genero.equals("Hombre")) {
            usuarioNormal.setGenero(Genero.MASCULINO);
        } else {
            usuarioNormal.setGenero(Genero.FEMENINO);
        }

        usuarioNormal.setFechaNacimiento(Calendar.getInstance());

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();

        Normal UsuarioNormalNuevo = (Normal) fabricaNegocio.createUsuarioNegocio().registrarUsuario(usuarioNormal);
        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        if (UsuarioNormalNuevo != null) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", UsuarioNormalNuevo);
            sesion.setAttribute("publicacionesComunes", publicacionesComunes);
            sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);
            response.sendRedirect(request.getContextPath() + "/paginas/PaginaPrincipal.jsp");

        }
//        response.sendRedirect("/paginas/Login.jsp");
    }

}
