
package servlet;

import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();
        Comun publicacionComun = new Comun();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        publicacionComun.setContenido(publicacion);
        publicacionComun.setFechaHoraCreacion(Calendar.getInstance());
        publicacionComun.setTitulo("publicacion");
        publicacionComun.setUsuario(usuario);
        fabricaNegocio.createPublicacionNegocio().registrarPublicacion(publicacionComun);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Publicación enviada con éxito");

    }

}
