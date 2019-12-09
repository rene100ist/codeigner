/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import dao.UsuDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author rene.linaresusam
 */
public class UsuaServlet extends HttpServlet {
    Conexion conn=new Conexion();
    UsuDao udao=new UsuDao(conn);
    RequestDispatcher rd;
    String msg;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String action=request.getParameter("action");
      switch(action){
          case "insert":insert(request,response);break;
          case "login":login(request,response);break;
          case "salir":salir(request,response);break;
          default:
              throw new AssertionError();
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
        Usuario user=new Usuario(0);
        user.setUsuario(request.getParameter("usuario"));
        user.setPass(request.getParameter("pass"));
        
        boolean resp= udao.insert(user);
        
        rd=request.getRequestDispatcher("login.jsp");
        response.sendRedirect("login.jsp");
        
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario=request.getParameter("usuario");
        String pass=request.getParameter("pass");
        
        try {
            if(udao.login(usuario, pass)){
                HttpSession session= request.getSession();
                session.setAttribute("usuario", usuario);
                
                int rol=udao.roles(usuario, pass);
                session.setAttribute("rol", rol);
                switch(udao.roles(usuario, pass)){
                    case 1:
                        response.sendRedirect("index.jsp");
                        break;
                    case 2:
                        response.sendRedirect("index.jsp");
                        break;
                }
            }else{
                 response.sendRedirect("/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        /*
        boolean resp;
        resp=udao.login(usuario, pass);
        
        if(resp){
            HttpSession session= request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("/TiendaMusica/pais?action=index");
        }else{
            msg="no existe usuario o clave";
            request.setAttribute("msg", msg);
            rd=request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        */
        
        
    }

    private void salir(HttpServletRequest request, HttpServletResponse response) throws IOException {
         HttpSession salir= request.getSession(false);
        if(salir != null){
            salir.invalidate();
        }
        response.sendRedirect("/TiendaMusica/login.jsp");
        
    }



}
