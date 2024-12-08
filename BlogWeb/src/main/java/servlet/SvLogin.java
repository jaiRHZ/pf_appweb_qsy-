package servlet;

import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.blogdominio.domain.Anclada;
import web.blogdominio.domain.Comun;
import web.blogdominio.domain.Usuario;

/**
 *
 * @author jairo-rhz
 */
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("contrasenia");

        System.out.println("holaaaaa");
        System.out.println(email);

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();
        Usuario usuario = fabricaNegocio.createUsuarioNegocio().
                validarInicioUsuario(email, contrasenia);
        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        
//        for (Anclada publicacionAnclada : publicacionesAncladas) {
//           System.out.println(publicacionAnclada.toString());
//       }
        if (usuario != null) {

            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            sesion.setAttribute("publicacionesComunes", publicacionesComunes);
            sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);
            response.sendRedirect(request.getContextPath() + "/home.jsp");

        } else {

            response.sendRedirect(request.getContextPath() + "/errores.jsp");
        }
    }
}
