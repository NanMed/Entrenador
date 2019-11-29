<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Progeso</title>
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link href="css/show2.css" rel="stylesheet">   
    </head>
    <style>
        #test3, #test4, #cuenta, #nombre, #pestana{
            display: none;
        }
        td{
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
            <input type="text" id="pestana" name="pestana" class="input" value="4"> 
            <input type="text" id="nombre" name="nombre" class="input" value="${requestScope.response}"> 
            <input class="proyecto_buton btn btn-success" type="submit"  value="Menu" id="boton_pro">
        </form> 
        <br>

      <!--   <form action ="./buscarWorker" method="post" id="above">
            <select id="optBusq" name= "optBusq">
              <option value="All">All</option>
              <option value="Nombre">Nombre</option>
              <option value="Id">Id</option>
              
            </select>
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="${requestScope.response3}"> 
            <input type="text" id="name" name="name" class="input" value="${requestScope.response}">
            <input type="text" id="valueBusca" name="valueBusca" class="input" required> 
            <input class="proyecto_buton btn btn-success" type="submit"  value="Buscar" id="boton_pro">
       </form> -->

       <table border="1" id="main_t">
            <tr class="visible">
                <th>Id</th>
                <th>Velocidad</th>
                <th>Levantamiento</th>
                <th>Equilibrio</th>
                <th>Dia</th>
                <th>IdRutina</th>
                <th>IdPaciente</th>
                <th>IdRegistros</th>
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
            </tr>
            
            <c:forEach items="${requestScope.progresos}" var="progreso">
                <tr>
                        <td>
                            <c:out value="${progreso.idProgreso}" />
                            
                            <br />
                        </td>

                        <td>
                            <c:out value="${progreso.velocidad}" />
                            <br />
                        </td>

                        <td>
                            <c:out value="${progreso.levantamiento}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${progreso.equilibrio}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${progreso.dia}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${progreso.idRutina}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${progreso.idPaciente}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${progreso.idRegistro}" />
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