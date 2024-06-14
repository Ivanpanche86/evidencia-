
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <link rel="stylesheet" type="text/css" href="consultapqrs.css">
            <!--Contiene los metadatos, información para el navegador-->
             <meta charset="UTF-8">
             <meta http-equiv="X-UA-Compatible" content="IE=edge">
             <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>"Tu Respuesta"</title> 
                     <meta name="autor" content="Equipo Tu Respuesta">
                     <meta name="contenido" content="App para gestión y radicación de pqrs">
         <link rel="icon" href="logo_naranja.jpeg" type="imagen/x-i">
         <style>
        .short-input{
            max-width: 200px; /*Ajusta el ancho <deseado></deseado>*/
        }
         </style>
    </head> 
   
    <body>          <!--Contiene el cuerpo de la página-->
        <div style="text-align: center;">
            <img src="imagenes/logCompVac.jpeg" width="320" height="150" alt=""> <br>
        </div>
        <form action="../../form-result.php" method="post" target="_blank">
            <div>
              Búsqueda por: <input type="search" name="busquedapqrs" placeholder="No. Radicado">
          
              <input type="submit" value="Buscar"> <br><br>
              Búsqueda por: <input type="search" name="busquedapqrs" placeholder="Documento de identidad">
          
              <input type="submit" value="Buscar">
             
            </div>
          
            <div class="rectangulo" ></div>
            <img src="Imagenes/logonaranja.jpeg" width="330"height="25"alt="10"/>
          
          </form>
    </body>
</html>
     
