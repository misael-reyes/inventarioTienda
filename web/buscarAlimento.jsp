<%-- 
    Document   : buscarAlimento
    Created on : 27 nov 2021, 1:29:13
    Author     : Misael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>buscar</title>
    </head>
    <body>
        <center>
        <h3>Buscar un alimento por ID</h3>
        <table with ="50%">
            <form action="BuscarAlimentos" method="post"/>
            <tr>
                <td>ID del alimento:</td>
                <td><input type="number" name="id"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="buscar" title="Buscar"></td>
            </tr>
            </form>

        </table>
        <br/>
        <a href="menuAlimentos.jsp"> Regresar </a>
    </center>
    </body>
</html>
