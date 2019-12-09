/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.IndividualDao;
import dao.PistasDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cd_individual;
import modelo.Pistas;

/**
 *
 * @author rene.linaresusam
 */
public class PistasServlet extends HttpServlet {
    Conexion conn=new Conexion();
    PistasDao pdao=new PistasDao(conn);
    boolean resp;
    RequestDispatcher rd;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch(action){
            case "insert":insert(request,response);break;
            case "index":index(request,response);break;
            case "eliminar":eliminar(request,response);break;
            case "consultarId":consultarId(request,response);break;
            case "update":update(request,response);break;
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

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Pistas pi=new Pistas(0);
        pi.setDuracion(LocalTime.parse(request.getParameter("duracion")));
        pi.setNombre(request.getParameter("nombre"));
        
        resp=pdao.insert(pi);
        rd=request.getRequestDispatcher("/Pistas/index.jsp");
        response.sendRedirect("/TiendaMusica/pistas?action=index");
        
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Pistas> listap=pdao.consultar();
        request.setAttribute("listap", listap);
        rd=request.getRequestDispatcher("/Pistas/index.jsp");
        rd.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pistas pi=new Pistas(Integer.parseInt(request.getParameter("id")));
        
        resp=pdao.eliminar(pi.getId());
        List<Pistas> listap=pdao.consultar();
        request.setAttribute("listap", listap);
        rd=request.getRequestDispatcher("/Pistas/index.jsp");
        rd.forward(request, response);
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pistas pi=new Pistas(Integer.parseInt(request.getParameter("id")));
        
        pi=pdao.consultarId(pi.getId());
        List<Pistas> listap=pdao.consultar();
        request.setAttribute("listap", listap);
        rd=request.getRequestDispatcher("/Pistas/index.jsp");
        rd.forward(request, response);
        
        
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pistas pi=new Pistas(Integer.parseInt(request.getParameter("id")));
        pi.setDuracion(LocalTime.parse(request.getParameter("duracion")));
        pi.setNombre(request.getParameter("nombre"));
        
        resp=pdao.update(pi);
        List<Pistas> listap=pdao.consultar();
        request.setAttribute("listap", listap);
        rd=request.getRequestDispatcher("/Pistas/index.jsp");
        rd.forward(request, response);
    }



}
