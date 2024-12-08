package servlet;

import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
@WebServlet(name = "SvRegister", urlPatterns = {"/SvRegister"})
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
        //String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        Normal usuarioNormal = new Normal();
        usuarioNormal.setNombreCompleto(nombreCompleto);
        usuarioNormal.setCredencial(new Credencial(email, contrasenia));
        usuarioNormal.setTelefono(telefono);
        usuarioNormal.setCorreo(email);
        usuarioNormal.setMunicipio(
                new Municipio(municipio, new Estado(estado)));
        usuarioNormal.setCiudad(ciudad);
        if (genero.equals("m")) {
            usuarioNormal.setGenero(Genero.MASCULINO);
        } else if (genero.equals("f")){
            usuarioNormal.setGenero(Genero.FEMENINO);
        }
        if (genero.equals("o")){
            usuarioNormal.setGenero(Genero.OTRO);
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
            response.sendRedirect(request.getContextPath() + "/home.jsp");

        }
//        response.sendRedirect("/paginas/Login.jsp");
    }

}
