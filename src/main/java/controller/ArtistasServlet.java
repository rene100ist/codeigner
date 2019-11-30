/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.ArtistasDao;
import dao.EstiloMusicaDao;
import dao.PaisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Artistas;
import modelo.Estilo_musica;
import modelo.Pais;

/**
 *
 * @author rene.linaresusam
 */
public class ArtistasServlet extends HttpServlet {
    Conexion conn=new Conexion();
    ArtistasDao adao=new ArtistasDao(conn);
    RequestDispatcher rd;
    boolean resp,msg;
    PaisDao pdao=new PaisDao(conn);
    EstiloMusicaDao emdao=new EstiloMusicaDao(conn);
  
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
        Artistas ar=new Artistas(0);
        ar.setNombre(request.getParameter("nombre"));
        ar.setGrupo(request.getParameter("grupo"));
        ar.setPais(Integer.parseInt(request.getParameter("pais")));
        ar.setEstilo_musical(Integer.parseInt(request.getParameter("estilo_musical")));
        
        resp=adao.insert(ar);
        msg=(resp)?true:false;
        request.setAttribute("msg", msg);
         List<Pais> listap = pdao.consultar();
        request.setAttribute("listap", listap);
        List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
        
        rd=request.getRequestDispatcher("/Artistas/index.jsp");
        response.sendRedirect("/TiendaMusica/artistas?action=index");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Artistas ar=new Artistas(Integer.parseInt(request.getParameter("id")));
        ar.setNombre(request.getParameter("nombre"));
        ar.setGrupo(request.getParameter("grupo"));
        ar.setPais(Integer.parseInt(request.getParameter("pais")));
        ar.setEstilo_musical(Integer.parseInt(request.getParameter("estilo_musical")));
        
        resp=adao.update(ar);
        msg=(resp)?true:false;
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        rd=request.getRequestDispatcher("/Artistas/index.jsp");
        index(request,response);
        
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Artistas ar=new Artistas(Integer.parseInt(request.getParameter("id")));
         List<Pais> listap = pdao.consultar();
        request.setAttribute("listap", listap);
        List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
        resp=adao.eliminar(ar.getId());
        msg=(resp)?true:false;
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        rd=request.getRequestDispatcher("/Artistas/index.jsp");
        rd.forward(request,response);
        
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Artistas ar=new Artistas(Integer.parseInt(request.getParameter("id")));
        
        ar=adao.consultarId(ar.getId());
        request.setAttribute("ar", ar);
         List<Pais> listap = pdao.consultar();
        request.setAttribute("listap", listap);
           List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
        rd=request.getRequestDispatcher("/Artistas/reg.jsp");
        rd.forward(request,response);
        
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Pais> listap = pdao.consultar();
        request.setAttribute("listap", listap);
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
           List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
        rd=request.getRequestDispatcher("/Artistas/index.jsp");
        rd.forward(request,response);
        
        
    }

    private void redi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pais> listap = pdao.consultar();
        request.setAttribute("listap", listap);
           List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
         List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        rd=request.getRequestDispatcher("/Artistas/index.jsp");
        rd.forward(request,response);
        
        
    }


}
