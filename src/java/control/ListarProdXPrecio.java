/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Misael
 */
@WebServlet(name = "ListarProdXPrecio", urlPatterns = {"/ListarProdXPrecio"})
public class ListarProdXPrecio extends CreadorListarProductos {


    @Override
    public IteradorProd crearIterador() {
        return new IteradorPrecio(productos);
    }


}
