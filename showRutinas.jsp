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
        #test3, #cuenta, #pestana, #name{
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

        <h4 class="text-center mt-2 font-weight-bold">Mostrar Rutinas</h4>

        <table border="1" id="main_t">
            <tr class="visible">
                <th>ID</th>
                <th>video</th>
                <th>texto</th>
                <th>imagen</th> 
                <th>Asignar paciente</th>  
                <th></th>
                <th></th>

            </tr>

            <tr class="invisible">
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>


            <c:forEach items="${requestScope.rutinas}" var="rutinas">
                <tr>
                    <td>
                        <c:out value="${rutinas.idRutina}" />
                        <br />
                    </td>
                    <td >
                        <c:out value="${rutinas.video}" />
                        <br />
                    </td>
                    <td>
                        <c:out value="${rutinas.texto}" />
                        <br />
                    </td>
                    <td>
                        <c:out value="${rutinas.imagen}" />
                        <br/>
                    </td>

                    <td>
                        <form action="./modPacienteRutina" method="post">
                            <input type="text" id="test3" name="test3" class="input" value="${rutinas.idRutina}"> 
                            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
                            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
                            <input type="text" id="name" name="name" class="input" value="${requestScope.response}">

                            <select id="selectionFilter" name="selectionFilter">
                                <option value="n/a">Todo</option>
                                <c:forEach items="${requestScope.pacientes}" var="pacientes">
                                    <option value="${pacientes.nombre}"><c:out value="${pacientes.nombre}"/></option>
                                </c:forEach>
                            </select>
                            
                            <input class="proyecto_buton btn btn-success" type="submit"  value="Asignar" style="
                            border: 1px solid #dc3545;
                            background-color: green;
                            font-size: 15px;
                            font-family: 'Raleway';
                            border-radius: 6px;
                            font-weight: bold; 
                            color: white;
                            ">
                        </form>
                    </td> 

                    <td>
                        <form action ="./borrarRutina" method="post">
                            <input type="text" id="test3" name="test3" class="input" value="${rutinas.idRutina}"> 
                            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
                            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
                            <input type="text" id="name" name="name" class="input" value="${requestScope.response}">
                            <input class="proyecto_buton btn btn-success" type="submit"  value="Borrar" id="boton_pro3">
                            
                        </form>
                    </td>
                    <td>
                        <form action ="./editarRutina" method="post">
                            <input type="text" id="test3" name="test3" class="input" value="${rutinas.idRutina}"> 
                            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
                            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
                            <input type="text" id="name" name="name" class="input" value="${requestScope.response}">
                            <input class="proyecto_buton btn btn-success" type="submit"  value="Editar" id="boton_editar">
                            
                        </form>
                    </td>                           
                </tr>
            </c:forEach>
        </table>

        <br>
        <br>
        <br>
        
    </body>
</html>