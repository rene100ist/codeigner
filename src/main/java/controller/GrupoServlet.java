
package controller;

import conexion.Conexion;
import dao.ArtistasDao;
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
import modelo.Grupo;


public class GrupoServlet extends HttpServlet {
    Conexion conn=new Conexion();
    GrupoDao gdao=new GrupoDao(conn);
    boolean resp;
    RequestDispatcher rd;
    //listar nombreartista se necesita traer del dao original
    ArtistasDao adao=new ArtistasDao(conn);
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch(action){
            case "insert":insert(request,response);break;
            case "update":update(request,response);break;
            case "eliminar":eliminar(request,response);break;
            case "consultarId":consultarId(request,response);break;
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
        Grupo g= new Grupo(0);
        g.setNombre(request.getParameter("nombre"));
        g.setArtista(Integer.parseInt(request.getParameter("artista")));
        
        resp=gdao.insert(g);
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        rd=request.getRequestDispatcher("/Grupo/index.jsp");
        response.sendRedirect("/TiendaMusica/grupo?action=index");

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Grupo g= new Grupo(Integer.parseInt(request.getParameter("id")));
        g.setNombre(request.getParameter("nombre"));
        g.setArtista(Integer.parseInt(request.getParameter("artista")));
        
        resp=gdao.update(g);
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        rd=request.getRequestDispatcher("/Grupo/index.jsp");
        index(request,response);
        
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Grupo g= new Grupo(Integer.parseInt(request.getParameter("id")));
        
        resp=gdao.eliminar(g.getId());
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        rd=request.getRequestDispatcher("/Grupo/index.jsp");
        rd.forward(request, response);
        
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Grupo g = new Grupo(Integer.parseInt(request.getParameter("id")));
        g=gdao.consultarId(g.getId());
        request.setAttribute("g", g);
        
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
        
        rd=request.getRequestDispatcher("/Grupo/index.jsp");
        rd.forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Artistas> listar=adao.consultar();
        request.setAttribute("listar", listar);
        
        List<Grupo> listag=gdao.consultar();
        request.setAttribute("listag", listag);
        
        rd=request.getRequestDispatcher("/Grupo/index.jsp");
        rd.forward(request, response);
        
    }



}
