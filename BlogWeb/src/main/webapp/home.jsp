<%-- 
    Document   : home
    Created on : 26 nov 2024, 01:03:43
    Author     : Paul Vazquez
    Author     : Jairo Rodriguez
--%>
<%@page import="web.blogdominio.domain.Anclada"%>
<%@page import="web.blogdominio.domain.Comentario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="web.blogdominio.domain.Administrador"%>
<%@page import="web.blogdominio.domain.Normal"%>
<%@page import="java.util.List"%>
<%@page import="web.blogdominio.domain.Comun"%>
<%@page import="web.blogdominio.domain.Comun"%>
<%@page import="web.blogdominio.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home</title>
        <link rel="stylesheet" href="./estilos/styleHome.css" />


    </head>
    <body>
        <div class="container">
            <!-- Sidebar izquierdo -->
            <aside class="sidebar">
                <nav class="nav-menu">
                    <div class="nav-item active">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            class="icon"
                            viewBox="0 0 24 24"
                            width="24"
                            height="24"
                            >
                        <path
                            fill="none"
                            stroke="currentColor"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            d="M5 12H3l9-9 9 9h-2M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2v-7"
                            />
                        </svg>
                        <span>Home</span>
                    </div>
                    <div class="nav-item">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            class="icon"
                            viewBox="0 0 24 24"
                            width="24"
                            height="24"
                            >
                        <path
                            fill="none"
                            stroke="currentColor"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            d="m21 21-6-6m2-5a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z"
                            />
                        </svg>
                        <span>Buscar</span>
                    </div>
                    <div class="nav-item">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            class="icon"
                            viewBox="0 0 24 24"
                            width="24"
                            height="24"
                            >
                        <path
                            fill="none"
                            stroke="currentColor"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            d="M14.857 17.082a23.848 23.848 0 0 0 5.454-1.31A8.967 8.967 0 0 1 18 9.75V9A6 6 0 0 0 6 9v.75a8.967 8.967 0 0 1-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 0 1-5.714 0m5.714 0a3 3 0 1 1-5.714 0"
                            />
                        </svg>
                        <span>Notificaciones</span>
                    </div>
                    <div class="nav-item">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            class="icon"
                            viewBox="0 0 24 24"
                            width="24"
                            height="24"
                            >
                        <path
                            fill="none"
                            stroke="currentColor"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            d="M17.593 3.322c1.1.128 1.907 1.077 1.907 2.185V21L12 17.25 4.5 21V5.507c0-1.108.806-2.057 1.907-2.185a48.507 48.507 0 0 1 11.186 0Z"
                            />
                        </svg>
                        <span>Marcador</span>
                    </div>
                    <div class="nav-item">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            class="icon"
                            viewBox="0 0 24 24"
                            width="24"
                            height="24"
                            >
                        <path
                            fill="none"
                            stroke="currentColor"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z"
                            />
                        </svg>

                        <%
                            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                            boolean usuarioEsAdministrador = false;
                            if (usuario != null && usuario instanceof Administrador) {
                                usuarioEsAdministrador = true;
                            }
                        %>
                        <div id="usuario" data-es-administrador="<%= usuarioEsAdministrador%>">
                            <span><%=usuario.getNombreCompleto()%></span>
                        </div>
                        <!--<button class="post-button">Post</button>-->
                        <form action="/BlogModel/SvLogOut">
                            <button class="post-button">Salir</button>
                        </form>

                </nav>
            </aside>




            <!-- Contenido principal -->
            <main class="main-content">
                <header class="header">
                    <h1>Home</h1>
                </header>

                <!-- Área de nueva publicación -->
                <div class="new-post">
                    <img
                        src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                        alt="User Avatar"
                        class="avatar"
                        />
                    <div class="post-input-container">
                        <form id="post-form">
                            <input id="publicacion" name="publicacion" type="text" placeholder="¿En qué piensas?" class="post-input" />
                            <br>
                            <input id="url" name="url" type="text" placeholder="URL imagen" class="post-input" />
                            <button type="submit" class="post-btn">Post</button>
                        </form>
                    </div>
                </div>

                <!-- Posts -->
                <div class="posts">


                </div>
            </main>

            <!-- Sidebar derecho -->
            <aside class="sidebar-right">
                <div class="search-container">
                    <input
                        type="text"
                        placeholder="Buscar Publicación"
                        class="search-input"
                        />
                </div>

                <%if (usuario instanceof Administrador) {%>
                <div class="post-input-container">
                    <form action="/BlogModel/SvPublicacionAnclada" method="POST">
                        <input name="publicacion"
                               type="text"
                               placeholder="¿En qué piensas?"
                               class="post-input"
                               />
                        <br>
                        <input name="url"
                               type="text"
                               placeholder="URL imagen"
                               class="post-input"
                               />
                        <button type="submit" class="post-btn">Post</button>
                    </form> 
                </div>
                <%}%>
                <div class="pinned-posts">

                    <h2>📌 Publicaciones Ancladas</h2>
                    <%
                        List<Anclada> publicacionesAncladas = (List<Anclada>) session.getAttribute("publicacionesAncladas");

                        for (Anclada anclada : publicacionesAncladas) {
                    %>
                    <article class="pinned-post">
                        <img
                            src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                            alt="User Avatar"
                            class="avatar"
                            />
                        <div class="pinned-content">
                            <div class="post-user">
                                <h3><%=anclada.getAdministrador().getNombreCompleto()%></h3>
                                <span class="verified-badge">✓</span>
                            </div>
                            <p>
                                <%=anclada.getContenido()%>
                            </p>
                            <img
                                src=<%=anclada.getUrl()%>
                                alt="Descripción" 
                                class="post-image"
                                />
                            <%if (usuario instanceof Administrador) {%>
                            <form action="/BlogModel/SvPublicacion" method="GET">
                                <button name="idPublicacion" value=<%=anclada.getId()%> class="delete-btn">Borrar Publicación</button>
                            </form>
                            <%}%>
                        </div>
                    </article>
                    <%}%>   
                </div>

            </aside>
        </div>
    </body>
    <script src="./script/cargarPublicacionesComunes.js"></script>
    <script src="./script/agregarPublicacionComun.js"></script>
</html>
