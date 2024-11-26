<%-- 
    Document   : home
    Created on : 26 nov 2024, 01:03:43
    Author     : Paul Vazquez
    Author     : Jairo Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home</title>
        <link rel="stylesheet" href="/estilos/styleHome.css" />
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
                        <span>Perfil</span>
                    </div>
                    <button class="post-button">Post</button>
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
                        <input
                            type="text"
                            placeholder="¿En qué piensas?"
                            class="post-input"
                            />
                        <button class="post-btn">Post</button>
                    </div>
                </div>

                <!-- Posts -->
                <div class="posts">
                    <article class="post">
                        <img
                            src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                            alt="User Avatar"
                            class="avatar"
                            />
                        <div class="post-content">
                            <div class="post-header">
                                <div class="post-user">
                                    <h3>Paul Vazquez</h3>
                                    <span class="verified-badge">✓</span>
                                </div>
                                <button class="delete-btn">Borrar Publicación</button>
                            </div>
                            <p class="post-text">
                                The movie wants to bring you down into the waste yard that is
                                Hollywood then pull you out to see the beauty that grows out of
                                the trash. The problem is the movie spends so much time in the
                                mud, and goes so deep into it that by the time it tries to pull
                                you out at the end it's too late.
                            </p>
                            <img
                                src="https://www.loslunesseriefilos.com/wp-content/uploads/2022/09/babylon-pelicula.jpg"
                                alt="Post image"
                                class="post-image"
                                />
                            <div class="comments-section">
                                <h4>Comentarios</h4>
                                <div class="comment">
                                    <img
                                        src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                                        alt="Commenter Avatar"
                                        class="avatar"
                                        />
                                    <p>Jairo Rodriguez: No entendí</p>
                                </div>
                                <div class="comment-input">
                                    <input
                                        type="text"
                                        placeholder="Añadir un comentario"
                                        class="comment-field"
                                        />
                                    <button class="comment-btn">Comentar</button>
                                </div>
                            </div>
                        </div>
                    </article>
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
                <div class="pinned-posts">
                    <h2>📌 Publicaciones Ancladas</h2>
                    <article class="pinned-post">
                        <img
                            src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                            alt="User Avatar"
                            class="avatar"
                            />
                        <div class="pinned-content">
                            <div class="post-user">
                                <h3>Jairo Rodriguez</h3>
                                <span class="verified-badge">✓</span>
                            </div>
                            <p>
                                The Substance is a powerful, haunting exploration of desire and
                                ambition, especially through the eyes of its lead female
                                character. Her journey is intense and layered, capturing the
                                struggle between personal boundaries and the pull of a
                                mysterious force.
                            </p>
                            <img
                                src="https://images.mubicdn.net/images/film/332868/cache-966973-1717030578/image-w1280.jpg?size=700x"
                                alt="Portal Revolution"
                                class="pinned-image"
                                />
                            <button class="delete-btn">Borrar Publicación</button>
                        </div>
                    </article>
                </div>
            </aside>
        </div>
    </body>
</html>