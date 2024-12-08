package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SvLogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la sesión actual
        HttpSession sesion = request.getSession(false);
        
        // Invalidar la sesión si existe
        if (sesion != null) {
            sesion.invalidate();
        }
        
        // Redirigir a la página de login
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}