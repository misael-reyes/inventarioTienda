/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import acceso_datos.ControladorProducto;
import acceso_datos.ControladoraBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
 *
 *
 * esta clase es una representación de la clase Creador_abstracto
 */
@WebServlet(name = "ListarProductoss", urlPatterns = {"/ListarProductoss"})
public abstract class CreadorListarProductos extends CreadorControladores {

    protected List<Producto> productos;
/*
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
*/
    /**
     * al ser una clase Creador abstracto, necesita tener el método creador
     * abstracto tambien para que sus hijos la implementen
     *
     * @return el iterdor de tipo IteradorProd
     */
    public abstract IteradorProd crearIterador();
    
    @Override
    public ControladoraBase crearControlador() {
        return new ControladorProducto(emf, utx);
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            emf = Persistence.createEntityManagerFactory("inventarioPU");

            //creamos un objeto constructor
            //CreadorControladores cc = new CreadorProducto(emf, utx);
            //creamos el controlador que queremos
            //ControladoraBase cb = cc.crearControlador();
            //productos = cb.findEntidadEntities();
            ctrlBase = crearControlador();
            productos = ctrlBase.findEntidadEntities();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarProductos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h3>Lista de productos</h3>");
            out.println("<table aling='center' width='60%' border=1>");
            out.println("<tr>");
            out.println("<td class='datos'> Id tipo </td>");
            out.println("<td class='datos'> Descripción </td>");
            out.println("<td class='datos'> Cantidad </td>");
            out.println("<td class='datos'> Precio Unitario </td>");
            out.println("</tr>");

            //utilizamos el método de fabricación
            IteradorProd iterador = crearIterador();
            //ordenamos el iterador
            iterador.ordenar();
            
            Producto p;
            
            while (iterador.hasNext()) {
                p = (Producto) iterador.next();
                out.println("<tr>");
                out.println("<td class='datos'>" + p.getIdprod() + "</td>");
                out.println("<td class='datos'>" + p.getDescripcion() + "</td>");
                out.println("<td class='datos'>" + p.getCantidad() + "</td>");
                out.println("<td class='datos'>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</br>");
            out.println("<a href=\"menuProductos.jsp\">Regresar al menú</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");

            //emf.close();
        }
    }

}
