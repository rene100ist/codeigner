/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.ColeccionDao;
import dao.CompaniaDao;
import dao.GrupoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Artistas;
import modelo.Cd_Coleccion;
import modelo.Compania;
import modelo.Grupo;

/**
 *
 * @author rene.linaresusam
 */
public class ColeccionServlet extends HttpServlet {

    Conexion conn=new Conexion();
    ColeccionDao ccdao=new ColeccionDao(conn);
    CompaniaDao codao=new CompaniaDao(conn);
    GrupoDao gdao=new GrupoDao(conn);
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
            case "index2":index2(request,response);break;
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
        cdo.setGrupo(Integer.parseInt(request.getParameter("grupo")));
        
        resp=ccdao.insert(cdo);
        List<Compania> listaco = codao.consultar();
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listaco", listaco);
        request.setAttribute("listag", listag);
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        response.sendRedirect("/TiendaMusica/coleccion?action=index");
    
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_Coleccion cdo=new Cd_Coleccion(Integer.parseInt(request.getParameter("id")));
        cdo.setNombre_col(request.getParameter("nombre_col"));
        cdo.setCod_tienda(Integer.parseInt(request.getParameter("cod_tienda")));
        cdo.setPvpC(Double.parseDouble(request.getParameter("pvpC")));
        cdo.setPromotor(Integer.parseInt(request.getParameter("promotor")));
        cdo.setGrupo(Integer.parseInt(request.getParameter("grupo")));
    
        resp=ccdao.update(cdo);
        
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
        
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        index(request,response);
    
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_Coleccion cdo=new Cd_Coleccion(Integer.parseInt(request.getParameter("id")));
        
        resp=ccdao.eliminar(cdo.getId());
        
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
    
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        rd.forward(request,response);
        
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_Coleccion cdo=new Cd_Coleccion(Integer.parseInt(request.getParameter("id")));
        
        cdo=ccdao.consultarId(cdo.getId());
        request.setAttribute("cdo", cdo);
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
    
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        rd.forward(request,response);
    
    }

    private void redi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
       List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
    
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        rd.forward(request,response);
    
    
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
    
        rd=request.getRequestDispatcher("/Coleccion/index.jsp");
        rd.forward(request,response);
        
    }

    private void index2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        List<Cd_Coleccion> listacdo = ccdao.consultar();
        request.setAttribute("listacdo", listacdo);
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
    
        rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
        
    }

    
    
    

}
