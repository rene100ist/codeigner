/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.ArtistasDao;
import dao.ColeccionDao;
import dao.CompaniaDao;
import dao.IndividualDao;
import dao.PistasDao;
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
import modelo.Cd_individual;
import modelo.Compania;
import modelo.Pistas;

public class IndividualServlet extends HttpServlet {
    Conexion conn=new Conexion();
    IndividualDao idao=new IndividualDao(conn);
    boolean resp,msg;
    RequestDispatcher rd;
    ArtistasDao adao=new ArtistasDao(conn);
    PistasDao pidao=new PistasDao(conn);
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch(action){
            case "insert":insert(request,response);break;
            case "update":update(request,response);break;
            case "eliminar":eliminar(request,response);break;
            case "consultarId":consultarId(request,response);break;
            case "index":index(request,response);break;
            case "redi":insert(request,response);break;
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
        Cd_individual cdi=new Cd_individual(0);
        cdi.setNombre_cd(request.getParameter("nombre_cd"));
        cdi.setCod_tienda(Integer.parseInt(request.getParameter("cod_tienda")));
        cdi.setPvp(Double.parseDouble(request.getParameter("pvp")));
        cdi.setArtista(Integer.parseInt(request.getParameter("artista")));
        cdi.setPista(Integer.parseInt(request.getParameter("pista")));
        
        resp=idao.insert(cdi);
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        List<Pistas> listapi=pidao.consultar();
        request.setAttribute("listapi", listapi);
        rd=request.getRequestDispatcher("/Individual/index.jsp");
        response.sendRedirect("/TiendaMusica/individual?action=index");
        
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Cd_individual cdi=new Cd_individual(Integer.parseInt(request.getParameter("id")));
        cdi.setNombre_cd(request.getParameter("nombre_cd"));
        cdi.setCod_tienda(Integer.parseInt(request.getParameter("cod_tienda")));
        cdi.setPvp(Double.parseDouble(request.getParameter("pvp")));
        cdi.setArtista(Integer.parseInt(request.getParameter("artista")));
        cdi.setPista(Integer.parseInt(request.getParameter("pista")));
        
        resp=idao.update(cdi);
        List<Artistas> listar=adao.consultar();
        List<Cd_individual> listacindi=idao.consultar();
        request.setAttribute("listar", listar);
        request.setAttribute("listacindi", listacindi);
        List<Pistas> listapi=pidao.consultar();
        request.setAttribute("listapi", listapi);
        rd=request.getRequestDispatcher("/Individual/index.jsp");
        index(request,response);
        
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_individual cdi=new Cd_individual(Integer.parseInt(request.getParameter("id")));
        
        resp=idao.eliminar(cdi.getId());
        List<Artistas> listar=adao.consultar();
        List<Cd_individual> listacindi=idao.consultar();
        request.setAttribute("listar", listar);
        request.setAttribute("listacindi", listacindi);
        List<Pistas> listapi=pidao.consultar();
        request.setAttribute("listapi", listapi);
        rd=request.getRequestDispatcher("/Individual/index.jsp");
        rd.forward(request,response);
        
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cd_individual cdi=new Cd_individual(Integer.parseInt(request.getParameter("id")));
        cdi=idao.consultarId(cdi.getId());
        request.setAttribute("cdi", cdi);
        
        List<Artistas> listar=adao.consultar();
        List<Cd_individual> listacindi=idao.consultar();
        request.setAttribute("listar", listar);
        request.setAttribute("listacindi", listacindi);
        List<Pistas> listapi=pidao.consultar();
        request.setAttribute("listapi", listapi);
        rd=request.getRequestDispatcher("/Individual/index.jsp");
        rd.forward(request,response);
        
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Artistas> listar=adao.consultar();
        List<Cd_individual> listacindi=idao.consultar();
        
        List<Pistas> listapi=pidao.consultar();
        request.setAttribute("listapi", listapi);
        
        request.setAttribute("listar", listar);
        request.setAttribute("listacindi", listacindi);
        
        rd=request.getRequestDispatcher("/Individual/index.jsp");
        rd.forward(request,response);
        
        
    }


}
