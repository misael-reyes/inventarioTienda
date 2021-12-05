/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import acceso_datos.ControladorAlimento;
import acceso_datos.ControladoraBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alimento;

/**
 *
 * @author Misael
 */
@WebServlet(name = "ListarAlimentos", urlPatterns = {"/ListarAlimentos"})
public class ListarAlimentos extends CreadorControladores {
    
    private List<Alimento> alimentos;
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            emf = Persistence.createEntityManagerFactory("inventarioPU");

            /* Usamos el método fabrica para acceder a un controlador */
            ctrlBase = crearControlador();
            alimentos = ctrlBase.findEntidadEntities();
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarAlimentos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h3>Lista de alimentos</h3>");
            out.println("<table aling='center' width='60%' border=1>");
            out.println("<tr>");
            out.println("<td class='datos'> Id tipo </td>");
            out.println("<td class='datos'> Descripción </td>");
            out.println("<td class='datos'> Cantidad </td>");
            out.println("<td class='datos'> Precio Unitario </td>");
            out.println("<td class='datos'> Fecha de caducidad </td>");
            out.println("</tr>");
            
            for (Alimento a: alimentos) {
                out.println("<tr>");
                out.println("<td class='datos'>" + a.getIdalimento() + "</td>");
                out.println("<td class='datos'>" + a.getDescripcion() + "</td>");
                out.println("<td class='datos'>" + a.getCantidad() + "</td>");
                out.println("<td class='datos'>" + a.getPrecio() + "</td>");
                out.println("<td class='datos'>" + a.getFechaCaducidad() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</br>");
            out.println("<a href=\"menuAlimentos.jsp\">Regresar al menú</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            
           // emf.close();
        }
    }

    @Override
    public ControladoraBase crearControlador() {
        return new ControladorAlimento(emf, utx);
    }

}
