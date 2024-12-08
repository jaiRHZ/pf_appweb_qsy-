document.getElementById('post-form').addEventListener('submit', async function (event) {
    event.preventDefault();

    const publicacion = document.getElementById('publicacion').value;
    const url = document.getElementById('url').value;

    const data = {
        publicacion: publicacion,
        url: url
    };

    try {

        const response = await fetch('/BlogModel/SvPublicacion', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert("Publicación realizada con éxito");

            window.location.reload();
        } else {
            console.error("Error al enviar la publicación");
        }
    } catch (error) {
        console.error("Error en la solicitud", error);
    }
});