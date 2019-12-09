<%-- 
    Document   : index
    Created on : 12-02-2019, 02:00:11 PM
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
            <!-- ================                         ingresando Cd Individual            =============================================== -->
            <!-- Button trigger modal -->
            <button style="display: ${hid}" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                nueva PISTA
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">Ingresando Pista</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <!-- ================    formulario   =============================================== -->
                            <form action="/TiendaMusica/pistas?action=insert" method="post">
                                <div class="row">
                                    <div class="col-8"
                                         <label>Nombre Cancion: </label>
                                        <input type="text" class="form-control" required name="nombre"><br>
                                        <label>Duracion: </label>
                                        <input type="time" class="form-control" required name="duracion"><br>
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
                            <td>Nombre Cancion</td>
                            <td>Duracion</td>
                            <td style="display: ${hid}">Acciones</td>
                        </tr>
                    </thead>
                    <% int cod = 1; %>
                    <c:forEach items="${listap}" var="ver">
                        <tbody>
                            <tr>
                                <td><% out.print(cod); %></td>
                                <td>${ver.getNombre()}</td>
                                <td>${ver.getDuracion()} &nbsp;minutos</td>
                                <td style="display: ${hid}">
                                    <a onclick="mPistas('${ver.getId()}', '${ver.getNombre()}', '${ver.getDuracion()}')" data-toggle="modal" data-target="#modificar" class="btn btn-warning">Modificar</a>
                                    <a class="btn btn-danger" href="/TiendaMusica/pistas?action=eliminar&id=${ver.id}">ELiminar</a>
                                </td>
                            </tr>
                        </tbody>
                        <% cod++;%>
                    </c:forEach>
                </table>
            </div>


<!-- ============================================================================================================================== -->
            <!-- =============================== MODIFICAR MODAL========================================================== -->
            <!-- Button trigger modal -->
            <!-- Modal -->
            <div class="modal fade" id="modificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Modificar Pista</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="/TiendaMusica/pistas?action=update" method="post">
                                <label>Codigo: </label>
                                <input type="text" class="form form-control" readonly="" name="id" id="id">
                                <label>Nombre Cancion: </label>
                                <input type="text" class="form form-control" required name="nombre" id="nombre">
                                <label>Duracion: </label>
                                <input type="time" class="form form-control" required name="duracion" id="duracion">
                                <br>
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
<!-- ============================================================================================================================== -->
<!-- =======                FIN                     =========================================================================== -->




        </div>    
     <script>
            function mPistas(id, nombre, duracion) {
                document.getElementById("id").value = id;
                document.getElementById("nombre").value = nombre;
                document.getElementById("duracion").value = duracion;
            }
        </script>
    </body>
</html>
