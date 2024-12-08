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
        String idPublicacion = request.getParameter("idPublicacion");
        System.out.println(idPublicacion);

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();

        fabricaNegocio.createPublicacionNegocio().eliminarPublicacion(Long.parseLong(idPublicacion));
        HttpSession sesion = request.getSession();

        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        sesion.setAttribute("publicacionesComunes", publicacionesComunes);
        sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);

        response.sendRedirect(request.getContextPath() + "/home.jsp");
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idPublicacion = req.getParameter("idPublicacion");

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();

        fabricaNegocio.createPublicacionNegocio().eliminarPublicacion(Long.parseLong(idPublicacion));
        HttpSession sesion = req.getSession();

        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        sesion.setAttribute("publicacionesComunes", publicacionesComunes);
        sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);

        resp.sendRedirect(req.getContextPath() + "/home.jsp");

    }

}
