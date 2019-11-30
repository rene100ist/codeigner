/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.PaisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pais;

/**
 *
 * @author rene.linaresusam
 */
public class PaisServlet extends HttpServlet {

    Conexion conn=new Conexion();
    PaisDao pdao=new PaisDao(conn);
    RequestDispatcher rd;
    boolean resp,msg;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch(action){
            case "insert":insert(request,response);break;
            case "update":update(request,response);break;
            case "eliminar":eliminar(request,response);break;
            case "consultarId":consultarId(request,response);break;
            case "index":index(request,response);break;
            case "redi":redi(request,response);break;
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
        Pais pa=new Pais(0);
        pa.setNombre(request.getParameter("nombre"));
        pa.setDireccion(request.getParameter("direccion"));
        pa.setCodigo_postal(request.getParameter("codigo_postal"));
        
        resp=pdao.insert(pa);
        msg=(resp)?true:false;
        request.setAttribute("msg", msg);
        rd=request.getRequestDispatcher("/Pais/create.jsp");
        response.sendRedirect("/TiendaMusica/pais?action=index");
        
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Pais pa=new Pais(Integer.parseInt(request.getParameter("id")));
        pa.setNombre(request.getParameter("nombre"));
        pa.setDireccion(request.getParameter("direccion"));
        pa.setCodigo_postal(request.getParameter("codigo_postal"));
        
        resp=pdao.update(pa);
        msg=(resp)?true:false;
        List<Pais> listap=pdao.consultar();
        request.setAttribute("listap", listap);
        request.setAttribute("msg", msg);
        rd=request.getRequestDispatcher("/Pais/index.jsp");
        index(request,response);
        
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Pais pa=new Pais(Integer.parseInt(request.getParameter("id")));
        
        resp=pdao.eliminar(pa.getId());
        msg=(resp)?true:false;
        request.setAttribute("msg", msg);
        List<Pais> listap=pdao.consultar();
        request.setAttribute("listap", listap);
        rd=request.getRequestDispatcher("/Pais/index.jsp");
        rd.forward(request, response);
        
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Pais pa=new Pais(Integer.parseInt(request.getParameter("id")));
        
        pa=pdao.consultarId(pa.getId());
        request.setAttribute("pa", pa);
        rd=request.getRequestDispatcher("/Pais/reg.jsp");
        rd.forward(request, response);
        
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Pais> listap=pdao.consultar();
        request.setAttribute("listap", listap);
        rd=request.getRequestDispatcher("/Pais/index.jsp");
        rd.forward(request, response);
        
        
    }

    private void redi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        rd=request.getRequestDispatcher("/Pais/create.jsp");
        rd.forward(request, response);
        
        
    }

  
}
