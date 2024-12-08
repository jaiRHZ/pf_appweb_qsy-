<%-- 
    Document   : register
    Created on : 26 nov 2024, 00:29:47
    Author     : Paul Vazquez
    Author     : Jairo Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>¡Registrate!</title>
       <link rel="stylesheet" href="./estilos/styleSingup.css">
    </head>
    <body>
        <div class="container">
            <h1>¡Registrate!</h1>
            <form action="/BlogModel/SvRegister" method="POST">
                <div class="form-grid">
                    <div class="form-group">
                        <input name="nombreCompleto" type="text" class="form-control" placeholder="Nombre" required>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <input name="fechaNacimiento" type="date" class="form-control" required>
                        </div>
                        <div class="select-wrapper">
                            <select name="genero" class="input-field">
                                <option value="" disabled selected>Género</option>
                                <option value="m">Masculino</option>
                                <option value="f">Femenino</option>
                                <option value="o">Otro</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <input name="email" type="email" class="form-control" placeholder="Email" required>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <input name="telefono" type="tel" class="form-control" placeholder="Teléfono" required>
                        </div>
                        <div class="form-group">
                            <input name="ciudad" type="text" class="form-control" placeholder="Ciudad" required>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <input name="municipio" type="text" class="form-control" placeholder="Municipio" required>
                        </div>
                        <div class="form-group">
                            <input name="estado" type="text" class="form-control" placeholder="Estado" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <input name="contrasenia" type="password" class="form-control" placeholder="Contraseña" required>
                    </div>
                </div>

                <div class="buttons">
                    <button type="button" class="btn btn-cancel" onclick="location.href='login.jsp'">Cancelar</button>
                    <button type="submit" class="btn btn-register">Registrar</button>
                </div>
            </form>
        </div>
    </body>
</html>