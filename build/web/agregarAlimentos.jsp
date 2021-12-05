<%-- 
    Document   : AgregarAlimentos
    Created on : 27 nov 2021, 1:12:37
    Author     : Misael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h3>Agregar Alimentos</h3>
        <table with="50%">
            <form action="AgregarA" method="post"/>
                <tr>
                <td colspan="2">Datos del alimento</td>
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
                <td>Fecha de caducidad:</td>
                <td><input type="date" name="caducidad"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="aceptar" title="Agregar"></td>
            </tr>
            </form>
        </table>
        <a href="menuAlimentos.jsp"> Regresar </a>
    </center>
    </body>
</html>
