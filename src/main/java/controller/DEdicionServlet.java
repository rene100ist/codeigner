/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.ColeccionDao;
import dao.CompaniaDao;
import dao.DetalleEdicionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.scene.paint.Color;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cd_Coleccion;
import modelo.Compania;
import modelo.DetalleEdicion;

/**
 *
 * @author rene.linaresusam
 */
public class DEdicionServlet extends HttpServlet {
    Conexion conn=new Conexion();
    DetalleEdicionDao dedao=new DetalleEdicionDao(conn);
    RequestDispatcher rd;
    //para mostrar los nombres de los campos en vez de numeros
    CompaniaDao cdao = new CompaniaDao(conn);
    ColeccionDao codao = new ColeccionDao(conn);
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch(action){
            case "index":index(request,response);break;
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compania> listac=cdao.consultar();
        request.setAttribute("listac", listac);
        
        List<DetalleEdicion> listade=dedao.consultar();
        request.setAttribute("listade", listade);
        
        rd=request.getRequestDispatcher("/DEdicion/index.jsp");
        rd.forward(request, response);
        
    }

}
