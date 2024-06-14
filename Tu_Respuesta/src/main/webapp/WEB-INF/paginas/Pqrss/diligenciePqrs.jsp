
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="autor" content="Equipo Tu Respuesta">
    <meta name="contenido" content="App para gestión y radicación de pqrs">
    <title>Tu Respuesta</title>
    <link rel="stylesheet" type="text/css" href="diligenciepqrs.css"> <!--Vincula archivo CSS-->
    <link href="css/bootstrap.min.css" rel="stylesheet">        
    <link rel="icon" href="logo_naranja.jpeg" type="imagen/jpeg">        
      
    </head>
    <body>
         <img src="imagenes/Nombre_app.jpeg" width="310" height="150" alt="">

     <form action="#"method="GET"enctype="multipart/form-data">
         <input type="text" 
         name="nombre" 
         id="nombre" size="31" required 
         minlength="2" maxlength="30"
         placeholder="Escribe aquí tu nombre"
         autofocus>  

         <label class="tipoSolictud";Arial, sans-serif;>Seleccione el tipo de solicitud</label>
             <select class="tipoSolicitud" aria-label="tipoSolicitud ">
                <option value="1">Petición</option>
                <option value="2">Queja</option>
                <option value="3">Reclamo</option> 
                <option value="4">Solicitud</option>
            </select> <br>

            <label for="nombre"size="15"></label> 
            <input type="text" 
            name="Asunto" 
            id="Asunto" size="31" required 
            minlength="2" maxlength="30"
            placeholder="Escribe aquí el asunto"
            autofocus>  

            <label for="direccion"size=" 15"></label>
            <input type="text"
            name="torre_apartamento" 
            id="torre_apartamento" size="31" required 
            minlength="2" maxlength="30"
            placeholder="Digite N°. de torre y apartamento" 
            autofocus> 
            <label for="identificacion"></label>

            <textarea name="texto_pqrs" rows="15" cols="38" alt="40"placeholder="Escriba aquí su PQRS."></textarea>  
            <br><br>
            <div style="margin-top: 2px;">
                <label for="archivos"size="10"></label>
                <input type="file"name="archivos"id="Archivos">
            </div> <br>
            <input type="submit" value="Cancelar">
            <input type="submit" value="Radicar"> <br><br>

            <img src="Imagenes/logonaranja.jpeg" width="330"height="25"alt="10"/> </p>     
        </form>
        
    </body>
</html>
