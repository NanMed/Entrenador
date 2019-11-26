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

        <title>Alta paciente</title>
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

        <h4 class="text-center mt-2 font-weight-bold" style="color: black">Nuevo paciente</h4>

        <h4 class="text-center mt-2 font-weight-bold"> 
            <c:out  value = "${requestScope.mensaje}"/> 
        </h4>

        <form action="./registroPaciente" method="post" class="mt-5">

            <div id="registro" class="row justify-content-center mx-0">
    
                <div class="section d-flex flex-column">
                    <input type="text" id="cuentaCliente" name="cuentaPaciente" class="input" required>            
                    <span class="user_label">Cuenta</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="password" id="contrasenia" name="contrasenia" class="input" required>            
                    <span class="user_label">Contraseña</span>
                </div>
    
                <div class="section d-flex flex-column">
                    <input type="text" id="telefono" name="nombres" class="input" required>             
                    <span class="user_label">Nombre</span>
                </div>   
                
                <div class="section d-flex flex-column">
                    <input type="text" id="correo" name="apellido" class="input" required>            
                    <span class="user_label">Apellido</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="date" id="edad" name="edad" class="input" required>            
                    <span class="user_label">Edad</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="text" id="correo" name="tipo_u" class="input" required>            
                    <span class="user_label">Tipo de usuario</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="text" id="correo" name="genero" class="input" required>            
                    <span class="user_label">Género</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="text" id="correo" name="id_rutina" class="input" required>            
                    <span class="user_label">Id rutina</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="text" id="correo" name="id_medico" class="input" required>            
                    <span class="user_label">Id del médico</span> 
                </div>

                <div class="section d-flex flex-column">
                    <input type="text" id="correo" name="id_entrenador" class="input" required>            
                    <span class="user_label">Id del entrenador</span> 
                </div>

            </div>
            
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="1"> 
            <input type="text" id="nombre" name="nombre" class="input" value="${requestScope.response}"> 
            <input type="text" id="nombre" name="nombre" class="input" value="${requestScope.mensaje}">
            
            <input class="login_button" type="submit"  value="GUARDAR">
        
        </form>
         

    </body>
</html>