/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import acceso_datos.ControladorProducto;
import acceso_datos.ControladoraBase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author Misael
 */
@WebServlet(name = "BuscarProductos", urlPatterns = {"/BuscarProductos"})
public class BuscarProductos extends CreadorControladores {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            emf = Persistence.createEntityManagerFactory("inventarioPU");

            /* Usamos el método fabrica para acceder a un controlador */
            ctrlBase = crearControlador();
            //ProductoJpaController productoController = new ProductoJpaController(utx, emf);

            int idproducto = Integer.parseInt(request.getParameter("id"));
            //Producto producto = productoController.findProducto(idproducto);
            Producto producto = (Producto) ctrlBase.findEntidad(idproducto);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscarProductos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h3>Detalle producto</h3>");
            out.println("<table aling='center' width='60%' border=1>");
            out.println("<tr>");
            out.println("<td class='datos'> Dato </td>");
            out.println("<td class='datos'> Valor </td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td class='datos'> ID </td>");
            out.println("<td class='datos'>" + producto.getIdprod() + "</td>");
            out.println("</tr>");
            out.println("<td class='datos'> Descripción </td>");
            out.println("<td class='datos'>" + producto.getDescripcion() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='datos'> Existencia </td>");
            out.println("<td class='datos'>" + producto.getCantidad() + "</td>");
            out.println("</tr>");
            out.println("<td class='datos'> Precio Unitario </td>");
            out.println("<td class='datos'>" + producto.getPrecio() + "</td>");
            out.println("</tr>");

            out.println("</table>");
            out.println("</br>");
            out.println("<a href=\"buscarProducto.jsp\">Buscar otro</a>");
            out.println("</br>");
            out.println("<a href=\"menuProductos.jsp\">Regresar al menú</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public ControladoraBase crearControlador() {
        return new ControladorProducto(emf, utx);
    }

}
