<%-- 
    Document   : menuProductos
    Created on : 27 nov 2021, 1:22:57
    Author     : Misael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu productos</title>
    </head>
    <<body>
    <center>
        <h1>Manejo de productos</h1>
        <br/>
        <a href="agregarProductos.jsp">Agregar Producto</a>
        <br/>
        <br/>
        <select name="listar" onchange="location = this.value;">
            <option disabled selected value="">Listar productos</option>
            <option value="ListarProdXDescripcion">Listar por Descripción</option>
            <option value="ListarProdXPrecio">Listar por Precio</option>
            <option value="ListarProdXCantidad">Listar por Cantidad</option>
        </select>
        <br/>
        <br/>
        <a href="buscarProducto.jsp">Buscar un Producto</a>
        <br/>
        <br/>
        <a href="index.jsp">Regresar</a>
    </center>
</body>
</html>
