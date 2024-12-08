
package filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author jairo-rhz
 */
@WebFilter(filterName = "FiltroLogueo", urlPatterns = {"/*"})
public class FiltroLogueo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    private final static String[] pathsPublicos = {
        "register.jsp", "estilos", "scripts", "SvRegister", "SvLogin", "errores.jsp"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = this.getPathSolicitado(httpRequest);
        boolean isPathPrivado = this.isPathPrivado(path);
        boolean isUsuarioLogueado = this.isUsuarioLogueado(httpRequest);
        if (isPathPrivado && !isUsuarioLogueado) {
            request.getServletContext()
                    .getRequestDispatcher("/login.jsp")
                    .forward(request, response);
            return;

        }
        // avanza normalmente
        chain.doFilter(request, response);
    }

    private String getPathSolicitado(HttpServletRequest request) {
        String uriSolicitada = request.getRequestURI();
        String path = uriSolicitada.substring(request.getContextPath().length());
        return path;
    }

    private boolean isPathPrivado(String path) {
        for (String pathPublico : FiltroLogueo.pathsPublicos) {
            if (path.startsWith("/" + pathPublico)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUsuarioLogueado(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);
        return (sesion != null && sesion.getAttribute("usuario") != null);
    }
    
}
