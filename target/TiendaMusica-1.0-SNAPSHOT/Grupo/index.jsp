<%-- 
    Document   : index
    Created on : 12-04-2019, 03:57:42 PM
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
   <!-- ================                         ingresando compañia            =============================================== -->
   <!-- Button trigger modal -->
<button style="display: ${hid}" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  nuevo Grupo
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
          <h5 class="modal-title" id="exampleModalCenterTitle">Ingresando Grupo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <div class="modal-body">
         <!-- ================    formulario   =============================================== -->
        <form action="/TiendaMusica/grupo?action=insert" method="post">
            <div class="row">
                <div class="col-6"
            <label>Nombre Grupo: </label>
            <input type="text" class="form-control" required name="nombre"><br>
            <!-- ================  lista de artista traido  =============================================== -->
            <label> Artista </label>
            <select name="artista" id="artista" required>
                <option class="control-form" value="">Seleccione un artista</option>
                <c:forEach items="${listar}" var="ar">
                    <option value="${ar.getId()}">${ar.getNombre()}</option>
                </c:forEach>
            </select>
             <!-- =====================  FIN =============================================== -->
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

<!-- ================  listado de compañia =============================================== -->

<div class="row">
    <table class="table table-bordered table-dark table-hover">
        <thead>
            <tr>
                <td>Codigo</td>
                <td>Nombre Grupo</td>
                <td>Artista</td>
                <td style="display: ${hid}">Acciones</td>
            </tr>
        </thead>
        <% int cod =1; %>
        <c:forEach items="${listag}" var="ver">
            <tbody>
                <tr>
                    <td><% out.print(cod); %></td>
                    <td>${ver.getNombre()}</td>
                    <td>${ver.getNombArtista()}</td>
                    <td style="display: ${hid}">
                        <a onclick="mGrupo('${ver.getId()}', '${ver.getNombre()}', '${ver.getNombArtista()}')" data-toggle="modal" data-target="#modificar" class="btn btn-warning">Modificar</a>
                        <a class="btn btn-danger" href="/TiendaMusica/grupo?action=eliminar&id=${ver.id}">Eliminar</a>
                    </td>
                </tr>
            </tbody>
        <% cod++; %>
        </c:forEach>
    </table>
</div>

      <!-- ========================================================================================= -->
            <!-- =============================== MODIFICAR MODAL========================================================== -->
            <!-- Button trigger modal -->
            <!-- Modal -->                 
            <div class="modal fade" id="modificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Modificar Grupo</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="/TiendaMusica/grupo?action=update" method="post">
                                <label>Codigo: </label>
                                <input type="text" class="form form-control" readonly="" name="id" id="id">
                                <label>Nombre Grupo: </label>
                                <input type="text" class="form form-control" required name="nombre" id="nombre">
                               <br>

                                <!-- ================  lista de cdindividual traido  =============================================== -->
                                <label> Artista </label>
                                <select name="artista" id="artista" required>
                                    <option class="control-form" value="">Seleccione un artista</option>
                                    <c:forEach items="${listar}" var="ar">
                                        <option value="${ar.getId()}">${ar.getNombre()}</option>
                                    </c:forEach>
                                </select><br><br>
                                <!-- =====================  FIN =============================================== -->
                               
                                <br>
                                <button type="submit" class="btn btn-warning">Guardar</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
<!-- ================================================================================================================
 ============================================      FIN     ==================================== -->








</div> 
                                            <script>
            function mGrupo(id, nombre, artista) {
                document.getElementById("id").value = id;
                document.getElementById("nombre").value = nombre;
                document.getElementById("artista").value = artista;
            }
        </script>
    </body>
</html>
