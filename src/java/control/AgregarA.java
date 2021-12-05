/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import acceso_datos.ControladorAlimento;
import acceso_datos.ControladoraBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alimento;

/**
 *
 * @author Misael
 * 
 * Servlet para agregar un alimento a la base de datos
 */
@WebServlet(name = "AgregarA", urlPatterns = {"/AgregarA"})
public class AgregarA extends CreadorControladores {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            emf = Persistence.createEntityManagerFactory("inventarioPU");
            Alimento alimento = new Alimento();
            alimento.setDescripcion(request.getParameter("descripcion"));
            alimento.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            alimento.setPrecio(Double.parseDouble(request.getParameter("precio")));
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = form.parse(request.getParameter("caducidad"));
            alimento.setFechaCaducidad(fecha);
            
            //uso del método de fabricación
            ctrlBase = crearControlador();
            ctrlBase.create(alimento);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar alimento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>El nuevo alimento se agregó correctamente</h1>");
            out.println("<br/>");
            out.println("<a href='menuAlimentos.jsp'>Regresar al menú</a>");
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
