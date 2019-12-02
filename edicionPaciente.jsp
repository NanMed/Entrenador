<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">      

        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/all.css">        
        <link href="css/formulario.css" rel="stylesheet">

        <title>Edición paciente</title>        
    </head>
    <style>
        #pestana, #name, #cuenta, #nombre{
            display: none;
        }
        body{
            background-color: #698ed6;
        }
        
    </style>
    <body>

        <form action ="./Session" method= "post">
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
            <input type="text" id="name" name="name" class="input" value="${requestScope.response}"> 

            <input class="proyecto_buton fas fa-arrow-circle-left" type="submit"  value="Atrás" id="boton_pro">
        </form>  

        <h4 class="text-center mt-2 font-weight-bold">Editar paciente</h4>


        <c:forEach items="${requestScope.pacientes}" var="paciente">
            <form action="./guardarCambiosPaciente" method="post" class="mt-5">
                <div id="registro" class="row justify-content-center mx-0">

                    <div class="section d-flex flex-column">
                        <input type="text" id="idPaciente" name="idPaciente" class="input" value="${paciente.id}" readonly>  
                        <span class="user_label">Id</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="nombreP" name="nombreP" class="input" value="${paciente.nombre}" required>            
                        <span class="user_label">Nombre</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="apellido" name="apellido" class="input" value="${paciente.apellido}" required>            
                        <span class="user_label">Apellido</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="edad" name="edad" class="input" value="${paciente.edad}" required>            
                        <span class="user_label">Edad</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="tipoU" name="tipoU" class="input" value="${paciente.tipoU}" required>            
                        <span class="user_label">Tipo de usuario</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="genero" name="genero" class="input" value="${paciente.genero}" required>            
                        <span class="user_label">Género</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="idRutina" name="idRutina" class="input" value="${paciente.idRutina}" required>            
                        <span class="user_label">Id Rutina</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="idMedico" name="idMedico" class="input" value="${paciente.idMedico}" required>            
                        <span class="user_label">Id Médico</span>
                    </div>
                    <div class="section d-flex flex-column">
                        <input type="text" id="idEntrenador" name="idEntrenador" class="input" value="${paciente.idEntrenador}" required>
                        <span class="user_label">Id Entrenador</span>
                    </div>
                </div>
                
                <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
                <input type="text" id="pestana" name="pestana" class="input" value="1"> 
                <input type="text" id="nombre" name="nombre" class="input" value="${requestScope.response}"> 
                <input type="text" id="nombre" name="nombre" class="input" value="${requestScope.mensaje}">
                       
                <input class="login_button" type="submit"  value="GUARDAR">
            </form>
        </c:forEach>
    </body>
</html>
