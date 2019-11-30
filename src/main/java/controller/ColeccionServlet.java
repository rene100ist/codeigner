/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.ColeccionDao;
import dao.CompaniaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cd_Coleccion;
import modelo.Compania;

/**
 *
 * @author rene.linaresusam
 */
public class ColeccionServlet extends HttpServlet {

    Conexion conn=new Conexion();
    ColeccionDao ccdao=new ColeccionDao(conn);
    CompaniaDao codao=new CompaniaDao(conn);
    boolean resp,msg;
    RequestDispatcher rd;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch(action){
            case "insert":insert(request,response);break;
            case "update":update(request,response);break;
            case "eliminar":eliminar(request,response);break;
            case "consultarId":consultarId(request,response);break;
            case "redi":redi(request,response);break;
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

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cd_Coleccion cdo=new Cd_Coleccion(0);
        cdo.setNombre_col(request.getParameter("nombre_col"));
        cdo.setCod_tienda(Integer.parseInt(request.getParameter("cod_tienda")));
        cdo.setPvpC(Double.parseDouble(request.getParameter("pvpC")));
        cdo.setPromotor(Integer.parseInt(request.getParameter("promotor")));
        
        resp=ccdao.insert(cdo);
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        response.sendRedirect("/TiendaMusica/coleccion?action=index");
    
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_Coleccion cdo=new Cd_Coleccion(Integer.parseInt(request.getParameter("isbn")));
        cdo.setNombre_col(request.getParameter("nombre_col"));
        cdo.setCod_tienda(Integer.parseInt(request.getParameter("cod_tienda")));
        cdo.setPvpC(Double.parseDouble(request.getParameter("pvpC")));
        cdo.setPromotor(Integer.parseInt(request.getParameter("promotor")));
    
        resp=ccdao.update(cdo);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        index(request,response);
    
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_Coleccion cdo=new Cd_Coleccion(Integer.parseInt(request.getParameter("isbn")));
        
        resp=ccdao.eliminar(cdo.getIsbn());
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
    
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        rd.forward(request,response);
        
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_Coleccion cdo=new Cd_Coleccion(Integer.parseInt(request.getParameter("isbn")));
        
        cdo=ccdao.consultarId(cdo.getIsbn());
        request.setAttribute("cdo", cdo);
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
         List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
    
        rd=request.getRequestDispatcher("/Coleccion/reg.jsp");
        rd.forward(request,response);
    
    }

    private void redi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
    
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        rd.forward(request,response);
    
    
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
    
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        rd.forward(request,response);
        
        
    }


}
