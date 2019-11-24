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

        <h4 class="text-center mt-2 font-weight-bold">Mostrar Historico</h4>

        <table border="1" id="main_t">
            <tr class="visible">
                <th>ID</th>
                <th>Tiempo</th>
                <th>Clasificacion</th>
                <th>Caidas</th> 
                <th>Prueba 2</th>  
                <th>Prueba 1 </th>  
                <th>sumaSppb</th>
                <th>Distancia</th>
                <th>Id Paciente</th>                    
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
            </tr>


            <c:forEach items="${requestScope.hostorico}" var="historico">
                <tr>
                    <td>
                        <c:out value="${historico.id}" />
                        <br />
                    </td>
                    <td >
                        <c:out value="${historico.tiempo}" />
                        <br />
                    </td>
                    <td>
                        <c:out value="${historico.clasificacion}" />
                        <br />
                    </td>
                    <td>
                        <c:out value="${historico.caidas}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${historico.prueba2}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${historico.prueba1}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${historico.sumaSppb}" />
                        <br/>
                    </td> 
                    <td>
                        <c:out value="${historico.distancia}" />
                        <br/>
                    </td>  
                    <td>
                        <c:out value="${historico.idPaciente}" />
                        <br/>
                    </td>                        
                </tr>
            </c:forEach>
        </table>

        <br>
        <br>
        <br>
        
    </body>
</html>



































