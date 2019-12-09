<%-- 
    Document   : index
    Created on : 11-29-2019, 10:47:58 AM
    Author     : rene.linaresusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion= request.getSession();
    int rol=Integer.parseInt(String.valueOf(sesion.getAttribute("rol")));
    if(sesion.getAttribute("usuario") !=null){
        String usuario=sesion.getAttribute("usuario").toString();
    }else{
        response.sendRedirect("login.jsp");
    }
    if(rol != 1){
        session.setAttribute("hid", "none");
    }else{
        session.setAttribute("hid", "");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="../Resources/navbar.jsp" %>
         <div class="container">
             
   <!-- ======================================================================================================================= -->
   <!-- ================                         ingresando Estilo Musica            =============================================== -->
         <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  nuevo Estilo
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
          <h5 class="modal-title" id="exampleModalCenterTitle">Ingresando Estilo Musical</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         <!-- ================    formulario   =============================================== -->
        <form action="/TiendaMusica/emusica?action=insert" method="post">
            <div class="row">
                <div class="col-6"
            <label>Nombre: </label>
            <input type="text" class="form-control" required name="nombre"><br>
           
                </div>
            </div>
            <br>
            <input type="submit" value="GUARDAR" class="btn btn-secondary">
        </form>
     <!-- =====================  FIN =============================================== -->
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- ================  listado de estilo =============================================== -->

<div class="row">
    <table class="table table-bordered table-dark table-hover">
        <thead>
            <tr>
                <td>Codigo</td>
                <td>Nombre</td>
                <td>Acciones</td>
            </tr>
        </thead>
        <% int cod =1; %>
        <c:forEach items="${listaem}" var="ver">
            <tbody>
                <tr>
                    <td><% out.print(cod); %></td>
                    <td>${ver.getNombre()}</td>
                    <td>
                        <a class="btn btn-warning" href="/TiendaMusica/emusica?action=consultarId&id=${ver.id}">Modificar</a>
                        <a class="btn btn-danger" href="/TiendaMusica/emusica?action=eliminar&id=${ver.id}">ELiminar</a>
                    </td>
                </tr>
            </tbody>
        <% cod++; %>
        </c:forEach>
    </table>
</div>










</div>     
    </body>
</html>
             
             
             
             
         </div>
    </body>
</html>
