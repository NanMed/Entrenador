<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">        
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">     
        <link rel="stylesheet" href="css/all.css">
        <link href="css/formulario.css" rel="stylesheet">

        <title>Alta Historial</title>
    </head>
    <style>
        #name, #cuenta, #pestana, #nombre{
            display: none;
        }
        body{
            background-color: #e6a400;
        }
        
    </style>

    <body>

        <form action ="./Session" method= "post">
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="1"> 
            <input type="text" id="name" name="name" class="input" value="${requestScope.response}"> 

            <input class="proyecto_buton fas fa-arrow-circle-left" type="submit"  value="Atrás" id="boton_pro">
        </form> 

        <h4 class="text-center mt-2 font-weight-bold" style="color: black">Nuevo Historial</h4>

        <form action="./registroCliente" method="post" class="mt-5">

            <div id="registro" class="row justify-content-center mx-0">
                <div class="section d-flex flex-column">
                    <input type="text" id="idHistorial" name="idHistorial" class="input" required>            
                    <span class="user_label">ID</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="text" id="tiempo" name="tiempo" class="input" required>            
                    <span class="user_label">Tiempo</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="text" id="clasificacion" name="clasificacion" class="input" required>            
                    <span class="user_label">Clasificacion</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="text" id="caidas" name="caidas" class="input" required>            
                    <span class="user_label">Caidas</span>
                </div>   
                
                <div class="section d-flex flex-column">
                    <input type="text" id="prueba2" name="prueba2" class="input" required>            
                    <span class="user_label">Prueba 2</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="text" id="prueba1" name="prueba1" class="input" required>            
                    <span class="user_label">Prueba 1</span> 
                </div>
                 <div class="section d-flex flex-column">
                    <input type="text" id="sumaSppb" name="sumaSppb" class="input" required>            
                    <span class="user_label">sumaSppb</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="distancia" name="distancia" class="input" required>            
                    <span class="user_label">Distancia</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="idPaciente" name="idPaciente" class="input" required>            
                    <span class="user_label">idPaciente</span>
                </div> 


            </div>
            
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="1"> 
            <input type="text" id="nombre" name="nombre" class="input" value="${requestScope.response}"> 
            
            <input class="login_button" type="submit"  value="GUARDAR">
        
        </form>
         

    </body>
</html>