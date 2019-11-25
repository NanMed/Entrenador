<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Pacientes</title>
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link href="css/show2.css" rel="stylesheet">   
    </head>
    <style>
        #test3, #test4, #cuenta, #name, #pestana{
            display: none;
        }
        td{
            text-align: center;
        }
        h4{
            text-align: center;
        }
        body{
            background-color: #698ed6;
        }
    </style>
    <body>

        <br> <br>
        <form action ="./Session" method= "post">
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
            <input type="text" id="name" name="name" class="input" value="${requestScope.response}">         
            <input class="proyecto_buton btn btn-success" type="submit"  value="Menu" id="boton_pro">
        </form>  
        <br>

        <h4 class="text-center mt-2 font-weight-bold">Mostrar pacientes</h4>

        <table border="1" id="main_t">
            <tr class="visible">
                <th>ID</th>
                <th>Cuenta</th>
                <th>Contraseña</th>
                <th>Nombre</th> 
                <th>Apellido</th>  
                <th>Edad</th>  
                <th>Tipo de usuario</th>
                <th>Género</th> 
                <th>Id Rutina</th>
                <th>Id Medico</th>     
                <th>Id Entrenador</th>
                <th>Ver Progreso</th>
                <th>Ver Historial</th>
                <th>Borrar</th>

            </tr>

            <tr class="invisible">
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                
            </tr>


            <c:forEach items="${requestScope.pacientes}" var="paciente">
                <tr>
                    <td>
                        <c:out value="${paciente.id}" />
                        <br />
                    </td>
                    <td >
                        <c:out value="${paciente.cuenta}" />
                        <br />
                    </td>
                    <td>
                        <c:out value="${paciente.contrasenia}" />
                        <br />
                    </td>
                    <td>
                        <c:out value="${paciente.nombre}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${paciente.apellido}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${paciente.edad}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${paciente.tipoU}" />
                        <br/>
                    </td> 
                    <td>
                        <c:out value="${paciente.genero}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${paciente.idRutina}" />
                        <br/>
                    </td>
                    <td>
                        <c:out value="${paciente.idMedico}" />
                        <br/>
                    </td>   
                    <td>
                        <c:out value="${paciente.idEntrenador}" />
                        <br/>
                    </td>

                    <td>
                            <form action ="./ShowProgreso" method="post">
                                <input type="text" id="test4" name="test4" class="input" value="${paciente.id}"> 
                                <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}">
                            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
                                <input type="text" id="name" name="name" class="input" value="${requestScope.response}">
                                <input class="proyecto_buton btn btn-success" type="submit"  value="VerProgreso" id="boton_pro2" >
                                
                            </form> 

                            <br />
                    </td> 
                    <td>
                            <form action ="./ShowHistorial" method="post">
                                <input type="text" id="test4" name="test4" class="input" value="${paciente.id}"> 
                                <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}">
                            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
                                <input type="text" id="name" name="name" class="input" value="${requestScope.response}">
                                <input class="proyecto_buton btn btn-success" type="submit"  value="VerHistorial" id="boton_pro2" >
                                
                            </form> 

                            <br />
                    </td>   
                    <td>
                            <form action ="./borrarPaciente" method="post">
                                <input type="text" id="test3" name="test3" class="input" value="${paciente.id}"> 
                                <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
                                <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
                                <input type="text" id="name" name="name" class="input" value="${requestScope.response}">
                                <input class="proyecto_buton btn btn-success" type="submit"  value="Borrar" id="boton_pro3">
                                
                            </form> 

                            <br />
                    </td>

                </tr>
            </c:forEach>
        </table>

        <br>
        <br>
        <br>
        
    </body>
</html>



































