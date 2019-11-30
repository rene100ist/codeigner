package controller;

import conexion.Conexion;
import dao.EstiloMusicaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estilo_musica;

public class EstiloMusicaServlet extends HttpServlet {

    Conexion conn = new Conexion();
    EstiloMusicaDao emdao = new EstiloMusicaDao(conn);
    RequestDispatcher rd;
    boolean resp, msg;

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
        Estilo_musica em = new Estilo_musica(0);
        em.setNombre(request.getParameter("nombre"));

        resp = emdao.insert(em);
        rd = request.getRequestDispatcher("/EMusica/index.jsp");
        response.sendRedirect("/TiendaMusica/emusica?action=index");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Estilo_musica em = new Estilo_musica(Integer.parseInt(request.getParameter("id")));
        em.setNombre(request.getParameter("nombre"));

        resp = emdao.update(em);
        List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
        rd = request.getRequestDispatcher("/EMusica/index.jsp");
        index(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Estilo_musica em = new Estilo_musica(Integer.parseInt(request.getParameter("id")));

        resp = emdao.eliminar(em.getId());
        List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
        rd = request.getRequestDispatcher("/EMusica/index.jsp");
        rd.forward(request, response);
    }

    private void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Estilo_musica em = new Estilo_musica(Integer.parseInt(request.getParameter("id")));

        em = emdao.consultarId(em.getId());
        request.setAttribute("em", em);
        rd = request.getRequestDispatcher("/EMusica/reg.jsp");
        rd.forward(request, response);
    }

    private void redi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        rd = request.getRequestDispatcher("/EMusica/index.jsp");
        rd.forward(request, response);

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Estilo_musica> listaem = emdao.consultar();
        request.setAttribute("listaem", listaem);
        rd = request.getRequestDispatcher("/EMusica/index.jsp");
        rd.forward(request, response);

    }

}
