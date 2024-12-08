document.addEventListener("DOMContentLoaded", () => {
    const postsContainer = document.querySelector(".posts");
    const usuarioEsAdministrador = document.getElementById('usuario').getAttribute('data-es-administrador') === 'true';

    const cargarPublicaciones = async () => {
        try {
            const response = await fetch('/BlogModel/SvPublicacion');
            const publicaciones = await response.json();

            postsContainer.innerHTML = "";

            publicaciones.forEach(publicacion => {
                const comentariosHTML = publicacion.comentarios.map(comentario => `
                    <div class="comment">   
                        <p><strong>${comentario.nombreUsuario}:</strong> ${comentario.contenido}</p>
                    </div>
                `).join("");

                let postHTML = `
                    <article class="post" data-id="${publicacion.id}">
                        <img src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png" alt="User Avatar" class="avatar" />
                        <div class="post-content">
                            <div class="post-header">
                                <div class="post-user">
                                    <h3>${publicacion.nombreUsuario}</h3>
                                    <span class="verified-badge">✓</span>
                                </div>
                    ${usuarioEsAdministrador ? `
                                 <form action="/BlogModel/SvPublicacionEliminar" method="GET">
    <button name="idPublicacion" value="${publicacion.id}" class="delete-btn">Borrar Publicación</button>
</form>
                                  ` : ""}
                            </div>
                            <p class="post-text">${publicacion.contenido}</p>
                            <img src="${publicacion.url}" alt="Descripción" class="post-image" />
                            <div class="comments-section">
                                <h4>Comentarios</h4>
                                ${comentariosHTML || "<p>No hay comentarios.</p>"}
                                ${!usuarioEsAdministrador ? `
                                    <form class="form-comentario" data-id="${publicacion.id}">
                                        <input name="contenido" type="text" placeholder="Añadir un comentario" class="comment-field" />
                                        <button type="submit" class="comment-btn">Comentar</button>
                                    </form>
                                ` : ""}
                            </div>
                        </div>
                    </article>
                `;
                postsContainer.innerHTML += postHTML;
            });

        } catch (error) {
            console.error("Error al cargar las publicaciones:", error);
        }
    };


    postsContainer.addEventListener("submit", async (event) => {

        event.preventDefault();
        if (event.target && event.target.matches(".form-comentario")) {
            event.preventDefault();
            const form = event.target;
            const idPublicacion = form.dataset.id;
            const contenido = form.querySelector('input[name="contenido"]').value;

            try {
                const response = await fetch('/BlogModel/SvComentario', {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify({idPublicacion, contenido})
                });

                if (response.ok) {
                    alert("Comentario enviado con éxito");
                    form.querySelector('input[name="contenido"]').value = "";
                    window.location.reload();
                } else {
                    console.error("Error al enviar el comentario.");
                }
            } catch (error) {
                console.error("Error:", error);
            }
        }
    });

    cargarPublicaciones();
});
