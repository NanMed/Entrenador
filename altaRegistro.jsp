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

        <title>Alta Registro</title>
    </head>
    <style>
        #name, #cuenta, #pestana, #nombre{
            display: none;
        }
        body{
            background-color: #698ed6;
        }
        
    </style>

    <body>

        <form action ="./Session" method= "post">
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="1"> 
            <input type="text" id="name" name="name" class="input" value="${requestScope.response}"> 

            <input class="proyecto_buton fas fa-arrow-circle-left" type="submit"  value="Atrás" id="boton_pro">
        </form> 

        <h4 class="text-center mt-2 font-weight-bold" style="color: black">Nuevo Registro</h4>

        <form action="./altaRegistro" method="post" class="mt-5">

            <div id="registro" class="row justify-content-center mx-0">
                <div class="section d-flex flex-column">
                    <input type="text" id="eje1Levantamiento" name="eje1Levantamiento" class="input" required>            
                    <span class="user_label">Ejercicio 1: Levantamiento</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="text" id="intento1E1L" name="intento1E1L" class="input" required>            
                    <span class="user_label">Intento 1</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="text" id="intento2E1L" name="intento2E1L" class="input" required>            
                    <span class="user_label">Intento 2</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="text" id="eje1Velocidad" name="eje1Velocidad" class="input" required>            
                    <span class="user_label">Ejercicio 1: Velocidad</span>
                </div>   
                
                <div class="section d-flex flex-column">
                    <input type="text" id="ntento1E1V" name="ntento1E1V" class="input" required>            
                    <span class="user_label">Intento 1</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="text" id="intento2E1V" name="intento2E1V" class="input" required>            
                    <span class="user_label">Intento 2</span> 
                </div>
                 <div class="section d-flex flex-column">
                    <input type="text" id="eje1Equilibrio" name="eje1Equilibrio" class="input" required>            
                    <span class="user_label">Ejercicio 1: Equilibrio</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="intento1E1E" name="intento1E1E" class="input" required>            
                    <span class="user_label">Intento 1</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="intento2E1E" name="intento2E1E" class="input" required>            
                    <span class="user_label">Intento 2</span>
                </div> 

                  <div class="section d-flex flex-column">
                    <input type="text" id="eje2Equilibrio" name="eje2Equilibrio" class="input" required>            
                    <span class="user_label">Ejercicio 2: Equilibrio</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="intento1E2E" name="intento1E2E" class="input" required>            
                    <span class="user_label">Intento 1</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="intento2E2E" name="intento2E2E" class="input" required>            
                    <span class="user_label">Intento 2</span>
                </div> 
                <div class="section d-flex flex-column">
                    <input type="text" id="eje3Equilibrio" name="eje3Equilibrio" class="input" required>            
                    <span class="user_label">Ejercicio 3: Equilibrio</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="intento1E3E" name="intento1E3E" class="input" required>            
                    <span class="user_label">Intento 1</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="intento2E3E" name="intento2E3E" class="input" required>            
                    <span class="user_label">Intento 2</span>
                </div> 
                 <div class="section d-flex flex-column">
                    <input type="text" id="ritmoCInicial" name="ritmoCInicial" class="input" required>            
                    <span class="user_label">Ritmo cardíaco inicial</span>
                </div>
                <div class="section d-flex flex-column">
                    <input type="text" id="ritmoCFinal" name="ritmoCInicial" class="input" required>            
                    <span class="user_label">Ritmo cardíaco final</span>
                </div>
                <div class="section d-flex flex-column">
                    <input type="text" id="omni_gse" name="omni_gse" class="input" required>            
                    <span class="user_label">OMNI-GSE</span>
                </div>
                <div class="section d-flex flex-column">
                    <input type="date" id="dia" name="dia" class="input" required>            
                    <span class="user_label">Fecha</span>
                </div>

            </div>
            
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="3"> 
            <input type="text" id="nombre" name="nombre" class="input" value="${requestScope.response}"> 
            
            <input class="login_button" type="submit"  value="GUARDAR">
        
        </form>
         

    </body>
</html>