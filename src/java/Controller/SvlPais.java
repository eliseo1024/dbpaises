/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pais;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angel
 */
@WebServlet(name = "SvlPais", urlPatterns = {"/SvlPais.do"})
public class SvlPais extends HttpServlet {

    public static final String INSERT_OR_EDIT = "/MantoDB.jsp";
    Pais pai;
    int id = -1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvlPais</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvlPais at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pais pa = new Pais();
        String action = request.getParameter("guardar");//Obtiene la opcion que hayamos escogido
        try {
            if (action != null) {
                String idPais = request.getParameter("txtIdPais");
                String siglas = request.getParameter("txtSiglas");
                String capital = request.getParameter("txtCapital");
                String cantHabitantes = request.getParameter("txtCantHabitantes");
                String extenTerritorio = request.getParameter("txtExtenTerritorio");
                String idioma = request.getParameter("txtIdioma");
                String moneda = request.getParameter("txtMoneda");
                int idPaiss = 0;
                int cantHabitantess = 0;
                double extenTerritorios = 0;
                if (siglas.equals("") || capital.equals("") || cantHabitantes.equals("") || extenTerritorio.equals("")
                        || idioma.equals("") || moneda.equals("")) {
                    request.getRequestDispatcher("CamposVacios.jsp").forward(request, response);
                }
                try {
                    cantHabitantess = Integer.parseInt(cantHabitantes);
                    extenTerritorios = Double.parseDouble(extenTerritorio);
                    try {
                        pa.setSiglas(siglas);
                        pa.setCapital(capital);
                        pa.setCantHabitantes(cantHabitantess);
                        pa.setExtenTerritorio(extenTerritorios);
                        pa.setIdioma(idioma);
                        pa.setMoneda(moneda);
                        if (idPais.equals("")) {
                            pa.AddPais(pa); //Guardar                         
                        } else {
                            idPaiss = Integer.parseInt(idPais);
                            pa.setIdPais(idPaiss);
                            pa.UpdatePais(pa); //Actualiza
                        }
                    } catch (Exception e) {
                    }
                } catch (NumberFormatException e) {
                    request.getRequestDispatcher("ValorNumerico.jsp").forward(request, response);
                }
            } else {
                String idEliminar = request.getParameter("idDelete");
                int idDelete = Integer.parseInt(idEliminar);
                pa.DeletePais(idDelete); //Elimina
            }
        } catch (Exception e) {
        }
        RequestDispatcher view = request.getRequestDispatcher("/MantoDB.jsp");
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
