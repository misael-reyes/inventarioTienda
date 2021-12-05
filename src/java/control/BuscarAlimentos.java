/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import acceso_datos.ControladorAlimento;
import acceso_datos.ControladoraBase;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "BuscarAlimentos", urlPatterns = {"/BuscarAlimentos"})
public class BuscarAlimentos extends CreadorControladores {
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            emf = Persistence.createEntityManagerFactory("inventarioPU");
            /* Usamos el método fabrica para acceder a un controlador */
            ctrlBase = crearControlador();
            
            int idalimento = Integer.parseInt(request.getParameter("id"));
            Alimento alimento = (Alimento) ctrlBase.findEntidad(idalimento);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscarAlimentos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h3>Detalle alimento</h3>");
            out.println("<table aling='center' width='60%' border=1>");
            out.println("<tr>");
            out.println("<td class='datos'> Dato </td>");
            out.println("<td class='datos'> Valor </td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td class='datos'> ID </td>");
            out.println("<td class='datos'>" + alimento.getIdalimento() + "</td>");
            out.println("</tr>");
            out.println("<td class='datos'> Descripción </td>");
            out.println("<td class='datos'>" + alimento.getDescripcion() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class='datos'> Existencia </td>");
            out.println("<td class='datos'>" + alimento.getCantidad() + "</td>");
            out.println("</tr>");
            out.println("<td class='datos'> Precio Unitario </td>");
            out.println("<td class='datos'>" + alimento.getPrecio() + "</td>");
            out.println("</tr>");
            out.println("<td class='datos'> Fecha de caducidad </td>");
            out.println("<td class='datos'>" + alimento.getFechaCaducidad() + "</td>");
            out.println("</tr>");

            out.println("</table>");
            out.println("</br>");
            out.println("<a href=\"buscarAlimento.jsp\">Buscar otro</a>");
            out.println("</br>");
            out.println("<a href=\"menuAlimentos.jsp\">Regresar al menú</a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public ControladoraBase crearControlador() {
        return new ControladorAlimento(emf, utx);
    }

}
