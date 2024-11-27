package servlet;

import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.util.Calendar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import web.blogdominio.domain.Anclada;
import web.blogdominio.domain.Comun;
import web.blogdominio.domain.Usuario;

/**
 *
 * @author jairo-rhz
 */
public class SvPublicacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String publicacion = request.getParameter("publicacion");
        String url = request.getParameter("url");

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();

        

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        Comun publicacionComun = new Comun(usuario, "titulo", publicacion, url);

        fabricaNegocio.createPublicacionNegocio().registrarPublicacion(publicacionComun);
        HttpSession sesion = request.getSession();
        
        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        sesion.setAttribute("publicacionesComunes", publicacionesComunes);
        sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);

        response.sendRedirect(request.getContextPath() + "/home.jsp");

    }

}
