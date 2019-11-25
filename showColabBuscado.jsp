<!--Checar las session-->
<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Colaboradores</title>
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,700" rel="stylesheet">
        <link href="css/show2.css" rel="stylesheet">   
    </head>
    <style>
        #test3, #test4, #cuenta, #pestana, #name{ 
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
            <input type="text" id="pestana" name="pestana" class="input" value="1"> 
            <input type="text" id="name" name="name" class="input" value="${requestScope.response}"> 

            <input class="proyecto_buton btn btn-success" type="submit"  value="Menu" id="boton_pro">
        </form> 
        <br>
        <form action ="./buscarColab" method="post" id="above">
            <select id="optBusq" name= "optBusq">
              <option value="All">All</option>
              <option value="Nombre">Nombre</option>
              <option value="Id">Id</option>
              
            </select>

            <input type="text" id="valueBusca" name="valueBusca" class="input" required> 
            <input type="text" id="cuenta" name="cuenta" class="input" value="${requestScope.response2}"> 
            <input type="text" id="pestana" name="pestana" class="input" value="1"> 
            <input type="text" id="name" name="name" class="input" value="${requestScope.response}"> 
            <input class="proyecto_buton btn btn-success" type="submit"  value="Buscar" id="boton_pro">
       </form>

       <table border="1" id="main_t">
            <tr class="visible">
                <th>ID</th>
                <th>Cuenta</th>
                <th>Nombre</th> 
                <th>Apellido</th>
                <th>Edad</th>
                <th>Género</th>
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
            <c:forEach items="${requestScope.colaboradores}" var="colab">
                <tr>
                        <td>
                            <c:out value="${colab.id}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${colab.cuenta}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${colab.nombre}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${colab.apellido}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${colab.edad}" />
                            <br />
                        </td>
                        <td>
                            <c:out value="${colab.genero}" />
                            <br />
                        </td>  

                        <td>
                            <form action ="./borrarColab" method="post">
                                <input type="text" id="test3" name="test3" class="input" value="${col.id}"> 
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