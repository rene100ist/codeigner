<%-- 
    Document   : index
    Created on : 12-02-2019, 10:28:01 AM
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
                nuevo cd Individual
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">Ingresando CD Individual</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <!-- ================    formulario   =============================================== -->
                            <form action="/TiendaMusica/individual?action=insert" method="post">
                                <div class="row">
                                    <div class="col-8"
                                         <label>Nombre Cd: </label>
                                        <input type="text" class="form-control" required name="nombre_cd"><br>
                                        <label>Codigo Tienda: </label>
                                        <input type="number" class="form-control" required name="cod_tienda"><br>
                                        <label>Precio Venta: </label>
                                        <input type="number" class="form-control" required name="pvp"><br>
                                        <!-- ================  lista de artista traido  =============================================== -->
                                        <label> Artista </label>
                                        <select name="artista" id="artista" required>
                                            <option class="control-form" value="">Seleccione un artista</option>
                                            <c:forEach items="${listar}" var="ar">
                                                <option value="${ar.getId()}">${ar.getNombre()}</option>
                                            </c:forEach>
                                        </select><br><br>
                                        <!-- =====================  FIN =============================================== -->
                                        <!-- ================  lista de Pista traido  =============================================== -->
                                        <label> Pista </label>
                                        <select name="pista" id="pista" required>
                                            <option class="control-form" value="">Seleccione una Pista</option>
                                            <c:forEach items="${listapi}" var="pi">
                                                <option value="${pi.getId()}">${pi.getNombre()} ${pi.getDuracion()}</option>
                                            </c:forEach>
                                        </select><br><br>
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
                            <td>Nombre CD</td>
                            <td>Codigo Tienda</td>
                            <td>PRecio venta</td>
                            <td>Artista</td>
                            <td>Pistas</td>
                            <td style="display: ${hid}">Acciones</td>
                        </tr>
                    </thead>
                    <% int cod = 1; %>
                    <c:forEach items="${listacindi}" var="ver">
                        <tbody>
                            <tr>
                                <td><% out.print(cod); %></td>
                                <td>${ver.getNombre_cd()}</td>
                                <td>${ver.getCod_tienda()}</td>
                                <td>${ver.getPvp()} $</td>
                                <td>${ver.getNombArtista()}</td>
                                <td>${ver.getNombPista()}</td>
                                <td style="display: ${hid}">
                                    <a onclick="mIndividual('${ver.getId()}', '${ver.getNombre_cd()}', '${ver.getCod_tienda()}', '${ver.getPvp()}', '${ver.getNombArtista()}')" data-toggle="modal" data-target="#modificar" class="btn btn-warning">Modificar</a>
                                    <a class="btn btn-danger" href="/TiendaMusica/individual?action=eliminar&id=${ver.id}">ELiminar</a>
                                </td>
                            </tr>
                        </tbody>
                        <% cod++;%>
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
                            <h5 class="modal-title" id="exampleModalLongTitle">Modificar CD Individual</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="/TiendaMusica/individual?action=update" method="post">
                                <label>Codigo: </label>
                                <input type="text" class="form form-control" readonly="" name="id" id="id">
                                <label>Nombre CD: </label>
                                <input type="text" class="form form-control" name="nombre_cd" id="nombre_cd">
                                <label>Codigo Tienda: </label>
                                <input type="number" class="form form-control" name="cod_tienda" id="cod_tienda">
                                <label>Precio Venta: </label>
                                <input type="number" class="form-control" name="pvp" id="pvp"><br>

                                <!-- ================  lista de cdindividual traido  =============================================== -->
                                <label> Artista </label>
                                <select name="artista" id="artista">
                                    <option class="control-form" value="">Seleccione un artista</option>
                                    <c:forEach items="${listar}" var="ar">
                                        <option value="${ar.getId()}">${ar.getNombre()}</option>
                                    </c:forEach>
                                </select><br><br>
                                <!-- =====================  FIN =============================================== -->
                                <!-- ================  lista de Pista traido  =============================================== -->
                                        <label> Pista </label>
                                        <select name="pista" id="pista">
                                            <option class="control-form" value="">Seleccione una Pista</option>
                                            <c:forEach items="${listapi}" var="pi">
                                                <option value="${pi.getId()}">${pi.getNombre()} ${pi.getDuracion()}</option>
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
            function mIndividual(id, nombre_cd, cod_tienda, pvp, artista,pista) {
                document.getElementById("id").value = id;
                document.getElementById("nombre_cd").value = nombre_cd;
                document.getElementById("cod_tienda").value = cod_tienda;
                document.getElementById("pvp").value = pvp;
                document.getElementById("artista").value = artista;
                document.getElementById("pista").value = pista;
            }
        </script>
    </body>
</html>
