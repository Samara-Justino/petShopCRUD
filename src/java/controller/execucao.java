/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.AnimalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Animal;

/**
 *
 * @author Samara Justino
 */
@WebServlet(name = "execucao", urlPatterns = {"/execucao"})
public class execucao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String exe = request.getParameter("exe");

            if (exe.equals("CADASTRAR")) {
                try {
                    Animal ani = InstanciarAnimal(request);
                    AnimalDAO adao = new AnimalDAO();
                    adao.cadastrar(ani);
                    request.setAttribute("msg", "Cadastrado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }

            } else if (exe.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Animal ani = new Animal();
                AnimalDAO adao = new AnimalDAO();
                ani.setId(id);
                try {
                    adao.deletar(ani);
                    request.setAttribute("msg", "Deletado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            } else if (exe.equals("ATUALIZAR")) {
                try {
                    Animal ani = InstanciarAnimal(request);
                    int id = Integer.parseInt(request.getParameter("txtid"));
                    ani.setId(id);

                    AnimalDAO adao = new AnimalDAO();
                    adao.atualizar(ani);
                    request.setAttribute("msg", "Atualizado com sucesso!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            } else if (exe.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Animal ani = new Animal();
                AnimalDAO adao = new AnimalDAO();
                ani.setId(id);

                try {
                    Animal animalconsultado = adao.consultarById(ani);
                    request.setAttribute("animal", animalconsultado);
                    request.getRequestDispatcher("consultarId.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            } else if (exe.equals("CONSULTAR TODOS")) {
                AnimalDAO adao = new AnimalDAO();
                try {
                    List<Animal> animaisConsultados = adao.consultarTodos();
                    request.setAttribute("animaisConsultados", animaisConsultados);
                    request.getRequestDispatcher("consultarTodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
        }
    }

    private Animal InstanciarAnimal(HttpServletRequest request) {
        String nome = request.getParameter("txtnome");
        String idade = request.getParameter("txtidade");
        String tipo = request.getParameter("txttipo");
        String sexo = request.getParameter("txtsexo");
        String porte = request.getParameter("txtporte");
        double peso = Double.parseDouble(request.getParameter("txtpeso"));
        String raca = request.getParameter("txtraca");
        String cor = request.getParameter("txtcor");
        String deficiencia = request.getParameter("txtdeficiencia");
        String observacao = request.getParameter("txtobservacao");

        Animal ani = new Animal();
        ani.setNome(nome);
        ani.setIdade(idade);
        ani.setTipo(tipo);
        ani.setSexo(sexo);
        ani.setPorte(porte);
        ani.setPeso(peso);
        ani.setRaca(raca);
        ani.setCor(cor);
        ani.setDeficiencia(deficiencia);
        ani.setObservacao(observacao);

        return ani;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
