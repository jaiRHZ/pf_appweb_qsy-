package servlet;

import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import web.blogdominio.domain.Administrador;
import web.blogdominio.domain.Anclada;
import web.blogdominio.domain.Comun;
import web.blogdominio.domain.Usuario;

public class SvPublicacionAnclada extends HttpServlet {

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

        

        Administrador usuario = (Administrador) request.getSession().getAttribute("usuario");
        Anclada publicacionComun = new Anclada(usuario, "titulo", publicacion, url);

        fabricaNegocio.createPublicacionNegocio().registrarPublicacion(publicacionComun);
        HttpSession sesion = request.getSession();
        
        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        sesion.setAttribute("publicacionesComunes", publicacionesComunes);
        sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);

        response.sendRedirect(request.getContextPath() + "/home.jsp");

    }
}
