/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Misael
 *
 * Esta será la clase una clase CreadorConcreto
 */
@WebServlet(name = "ListarProdXDescripcion", urlPatterns = {"/ListarProdXDescripcion"})
public class ListarProdXDescripcion extends CreadorListarProductos {

    @Override
    public IteradorProd crearIterador() {
        return new IteradorDescripcion(productos);
    }


}
