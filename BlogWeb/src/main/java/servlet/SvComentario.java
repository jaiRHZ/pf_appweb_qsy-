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
import java.util.Calendar;
import java.util.List;
import web.blogdominio.domain.Anclada;
import web.blogdominio.domain.Comentario;
import web.blogdominio.domain.Comun;
import web.blogdominio.domain.Normal;
import web.blogdominio.domain.Usuario;

public class SvComentario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contenido = request.getParameter("contenido");
        String idPublicacion = request.getParameter("idPublicacion");

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();
        
        

        Normal usuario = (Normal) request.getSession().getAttribute("usuario");
        Comun comun = fabricaNegocio.createPublicacionNegocio().consultarPublicacionComunId(Long.parseLong(idPublicacion));
        Comentario comentario = new Comentario(Calendar.getInstance(), contenido, usuario, comun);
        
        fabricaNegocio.createComentarioNegocio().registrarComentario(comentario);
        HttpSession sesion = request.getSession();
        
        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        sesion.setAttribute("publicacionesComunes", publicacionesComunes);
        sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);

        response.sendRedirect(request.getContextPath() + "/home.jsp");

    }

}
