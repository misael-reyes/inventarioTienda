/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import acceso_datos.ControladoraBase;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Misael
 */
@WebServlet(name = "ListarProdXCantidad", urlPatterns = {"/ListarProdXCantidad"})
public class ListarProdXCantidad extends CreadorListarProductos {

    @Override
    public IteradorProd crearIterador() {
        return new IteradorCantidad(productos);
    }


}
