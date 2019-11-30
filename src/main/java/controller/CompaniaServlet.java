package controller;

import conexion.Conexion;
import dao.CompaniaDao;
import dao.PaisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Compania;
import modelo.Pais;

public class CompaniaServlet extends HttpServlet {

    Conexion conn = new Conexion();
    CompaniaDao codao = new CompaniaDao(conn);
    RequestDispatcher rd;
    boolean resp, msg;
    PaisDao pdao=new PaisDao(conn);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insert":
                insert(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "consultarId":
                consultarId(request, response);
                break;
            case "index":
                index(request, response);
                break;
            case "redi":
                redi(request, response);
                break;
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
        Compania co = new Compania(0);
        co.setNombre(request.getParameter("nombre"));
        co.setPais(Integer.parseInt(request.getParameter("pais")));

        resp = codao.insert(co);
        msg = (resp) ? true : false;
        List<Pais> listap = pdao.consultar();
        request.setAttribute("listap", listap);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/Compania/index.jsp");
        response.sendRedirect("/TiendaMusica/compania?action=index");

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Compania co = new Compania(Integer.parseInt(request.getParameter("id")));
        co.setNombre(request.getParameter("nombre"));
        co.setPais(Integer.parseInt(request.getParameter("pais")));

        resp = codao.update(co);
        msg = (resp) ? true : false;
        request.setAttribute("msg", msg);
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listaco", listaco);
        rd = request.getRequestDispatcher("/Compania/index.jsp");
        index(request, response);

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Compania co = new Compania(Integer.parseInt(request.getParameter("id")));

        resp = codao.eliminar(co.getId());
         List<Pais> listap = pdao.consultar();
        List<Compania> listaco = codao.consultar();
        request.setAttribute("listap", listap);
        request.setAttribute("listaco", listaco);
        rd = request.getRequestDispatcher("/Compania/index.jsp");
        rd.forward(request, response);
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Compania co = new Compania(Integer.parseInt(request.getParameter("id")));

        co = codao.consultarId(co.getId());
        request.setAttribute("co", co);
        List<Pais> listap = pdao.consultar();
        request.setAttribute("listap", listap);
        rd = request.getRequestDispatcher("/Compania/reg.jsp");
        rd.forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pais> listap = pdao.consultar();
        List<Compania> listaco = codao.consultar();
        
        request.setAttribute("listaco", listaco);
        request.setAttribute("listap", listap);
        
        rd = request.getRequestDispatcher("/Compania/index.jsp");
        rd.forward(request, response);

    }

    private void redi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Pais> listap = pdao.consultar();
           List<Compania> listaco = codao.consultar();
        
        request.setAttribute("listaco", listaco);
        request.setAttribute("listap", listap);
        rd = request.getRequestDispatcher("/Compania/index.jsp");
        rd.forward(request, response);
        
    }

}
