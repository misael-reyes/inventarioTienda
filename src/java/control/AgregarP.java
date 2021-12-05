/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import acceso_datos.ControladorProducto;
import acceso_datos.ControladoraBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import modelo.Producto;

/**
 *
 * @author Misael
 */
@WebServlet(name = "AgregarP", urlPatterns = {"/AgregarP"})
public class AgregarP extends CreadorControladores {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* agregamos el nuevo registro */
            emf = Persistence.createEntityManagerFactory("inventarioPU");
            Producto producto = new Producto();
            
            //empezamos a darle valores a los atributos del producto
            producto.setDescripcion(request.getParameter("descripcion"));
            producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            producto.setPrecio(Double.parseDouble(request.getParameter("precio")));

            /* Usamos el método fabrica para acceder a un controlador */
            ctrlBase = crearControlador();
            //creamos el registro
            ctrlBase.create(producto);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar producto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>El nuevo producto se agregó correctamente</h1>");
            out.println("<br/>");
            out.println("<a href='menuProductos.jsp'>Regresar al menú</a>");
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
