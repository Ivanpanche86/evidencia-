<!DOCTYPE html>
<html lang="es">
<head>
    <link rel="stylesheet" type="text/css" href="inicio.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"Tu Respuesta"</title>
    <meta name="autor" content="Equipo Tu Respuesta">
    <meta name="contenido" content="App para gestión y radicación de pqrs">
    <link rel="icon" href="logo_naranja.jpeg" type="imagen/x-i">
    <style>
        .short-input {
            max-width: 200px;
        }
    </style>
</head>
<body>
    <div style="text-align: center;">
        <img src="imagenes/Nombre_app.jpeg" width="310" height="150" alt=""><br>
    </div>
    
    <div style="text-align: center;">
    
         <form action="ServletControlador" method="post"> <!-- Cambia el action para apuntar a tu servlet -->
        
             <input type="text" name="nombres" size="35" maxlength="50" class="center-button" placeholder="Nombres" required><br><br>
        
             <input type="text" name="apellidos" size="35" maxlength="50" class="center-button" placeholder="Apellidos" required><br><br>
        
                 <label for="tipo_documento">Seleccione una opción</label>
                 <select name="tipo_documento" class="form-select" aria-label="Default select example" required>
                 <option value="" disabled selected>Seleccione...</option>
                 <option value="Cedul">CC</option>
                 <option value="TarjetaIdentidad">TI</option>
                 <option value="Pasaporte">Pasaporte</option>
                 </select><br><br>
        
                 <input type="text" name="numero_documento" size="35" maxlength="10" class="center-button" placeholder="No. de Identificación" required><br><br>
        
                 <input type="text" name="telefono1" size="35" maxlength="10" class="center-button" placeholder="No. de Contacto" required><br><br>
                 <input type="text" name="telefono2" size="35" maxlength="10" class="center-button" placeholder="No. de Contacto"><br><br>
        
                 <input type="e_mail" name="e_mail" size="35" class="center-button" placeholder="Correo Electrónico" required><br><br>
        
                 <label for="tipo_usuario">Seleccione una opción</label>
                 <select name="tipo_usuario" class="form-select" aria-label="Default select example" required>
                 <option value="" disabled selected>Seleccione...</option>
                 <option value="Propietario">Propietario</option>
                 <option value="Residente">Residente</option>
                 <option value="Administrador">Administrador</option>
                 </select><br><br>
        
                 <input type="text" name="torre_apartamento" size="35" maxlength="10" class="center-button" placeholder="Torre y Apartamento" required><br><br>
        
                 <input type="password" name="contraseña" size="35" maxlength="15" class="center-button" placeholder="Ingrese una clave no menor a 8 caracteres" required><br><br>
                 <input type="password" name="confirmar_contraseña" size="35" maxlength="15" class="center-button" placeholder="Confirme su clave" required><br><br>
        
                 <button onclick = " mifuncion()" type="submit">Enviar</button>
         </form> 
             <footer class="footer">
                 <div style="text-align: center;">
                    <table>
                         <tr>
                             <td>    
                              <p style="color:#fdfcfc; background-color:#f85306; font-family:verdana; font-size:8px; text-align:center; width:310px; height:25px;">
                                 Desarrollado por: Tu Respuesta 2023
                              </p>
                             </td>
                         </tr>
                    </table>
                 </div>
             </footer>    
     </div>
</body>
</html>
