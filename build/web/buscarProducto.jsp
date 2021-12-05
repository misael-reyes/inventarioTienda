<%-- 
    Document   : buscarProducto
    Created on : 15 nov 2021, 17:49:53
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
        <h3>Buscar un producto por ID</h3>
        <table with ="50%">
            <form action="BuscarProductos" method="post"/>
            <tr>
                <td>ID del producto:</td>
                <td><input type="number" name="id"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="buscar" title="Buscar"></td>
            </tr>
            </form>

        </table>
        <br/>
        <a href="menuProductos.jsp"> Regresar </a>
    </center>
</body>
</html>
