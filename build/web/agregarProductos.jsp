<%-- 
    Document   : agregarProductos
    Created on : 15 nov 2021, 17:46:51
    Author     : Misael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>agregar</title>
    </head>
    <body>
        
    <center>
        <h3>Agregar Productos</h3>
        <table with ="50%">
            <form action="AgregarP" method="post"/>
            <tr>
                <td colspan="2">Datos del producto</td>
            </tr>
            <tr>
                <td>Descripción:</td>
                <td><input type="text" name="descripcion"></td>
            </tr>
            <tr>
                <td>Cantidad:</td>
                <td>
                    <input type="number" name="cantidad">
                </td>
            </tr>
            <tr>
                <td>Precio:</td>
                <td><input type="number" name="precio"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="aceptar" title="Agregar"></td>
            </tr>
            </form>

        </table>
        <a href="menuProductos.jsp"> Regresar </a>
    </center>
</body>
</html>
