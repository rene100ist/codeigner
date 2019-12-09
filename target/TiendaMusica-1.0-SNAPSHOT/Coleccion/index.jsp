<%-- 
    Document   : index
    Created on : 11-29-2019, 02:46:45 PM
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
                nueva coleccion
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">Ingresando Coleccion</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <!-- ================    formulario   =============================================== -->
                            <form action="/TiendaMusica/coleccion?action=insert" method="post">
                                <div class="row">
                                    <div class="col-8"
                                         <label>Nombre Coleccion: </label>
                                        <input type="text" class="form-control" required name="nombre_col"><br>
                                        <label>#Tienda: </label>
                                        <input type="number" class="form-control" required name="cod_tienda"><br>
                                        <label>Precio venta de Coleccion</label>
                                        <input type="number" class="form-control" required name="pvpC"><br>
                                        <!-- ================  lista de promotor traido  =============================================== -->
                                        <label> Promotor </label>
                                        <select name="promotor" id="promotor" required>
                                            <option class="control-form" value="">Seleccione un promotor</option>
                                            <c:forEach items="${listaco}" var="co">
                                                <option value="${co.getId()}">${co.getNombre()}</option>
                                            </c:forEach>
                                        </select><br><br>
                                        <!-- =====================  FIN =============================================== -->
                                        <!-- ================  lista de grupo traido  =============================================== -->
                                        <label> Grupo </label>
                                        <select name="grupo" id="grupo" required>
                                            <option class="control-form" value="">Seleccione un grupo</option>
                                            <c:forEach items="${listag}" var="g">
                                                <option value="${g.getId()}">${g.getNombre()}</option>
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
                            <td>Nombre Coleccion</td>
                            <td>Codigo tienda</td>
                            <td>Precio Venta Coleccion</td>
                            <td>Promotor</td>
                            <td>Grupo</td>
                            <td style="display: ${hid}">Acciones</td>
                        </tr>
                    </thead>
                    <% int cod = 1; %>
                    <c:forEach items="${listacdo}" var="ver">
                        <tbody>
                            <tr>
                                <td><% out.print(cod); %></td>
                                <td>${ver.getNombre_col()}</td>
                                <td>${ver.getCod_tienda()}</td>
                                <td>${ver.getPvpC()} $</td>
                                <td>${ver.getNombrePromo()}</td>
                                <td>${ver.getNombGrupo()}</td>
                                <td style="display: ${hid}">
                                    <a onclick="mColeccion('${ver.getId()}', '${ver.getNombre_col()}', '${ver.getCod_tienda()}', '${ver.getPvpC()}', '${ver.getPromotor()}'), '${ver.getGrupo()}'" data-toggle="modal" data-target="#modificar" class="btn btn-warning">Modificar</a>
                                    <a class="btn btn-danger" href="/TiendaMusica/coleccion?action=eliminar&id=${ver.id}">ELiminar</a>
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
                            <h5 class="modal-title" id="exampleModalLongTitle">Modificar Coleccion</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="/TiendaMusica/coleccion?action=update" method="post">
                                <label>Codigo: </label>
                                <input type="text" class="form form-control" required readonly="" name="id" id="id">
                                <label>Nombre Coleccion: </label>
                                <input type="text" class="form form-control" required name="nombre_col" id="nombre_col">
                                <label>Codigo Tienda: </label>
                                <input type="text" class="form form-control" required name="cod_tienda" id="cod_tienda">
                                <label>Precio venta Coleccion: </label>
                                <input type="text" class="form form-control" required name="pvpC" id="pvpC">
                                <br>
                                <!-- ================  lista de promotor traido  =============================================== -->
                                <label>Promotor  </label>
                                <select name="promotor" id="promotor" required>
                                    <option class="control-form" value="">Seleccione un promotor</option>
                                    <c:forEach items="${listaco}" var="co">
                                        <option value="${co.getId()}">${co.getNombre()}</option>
                                    </c:forEach>
                                </select><br><br>
                                <!-- ================  FIN  =============================================== -->
                               <!-- ================  lista de grupo traido  =============================================== -->
                                        <label> Grupo </label>
                                        <select name="grupo" id="grupo" required>
                                            <option class="control-form" value="">Seleccione un grupo</option>
                                            <c:forEach items="${listag}" var="g">
                                                <option value="${g.getId()}">${g.getNombre()}</option>
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








        </div>     
        <script>
            function mColeccion(id, nombre_col, cod_tienda, pvpC, promotor,grupo) {
                document.getElementById("id").value = id;
                document.getElementById("nombre_col").value = nombre_col;
                document.getElementById("cod_tienda").value = cod_tienda;
                document.getElementById("pvpC").value = pvpC;
                document.getElementById("promotor").value = promotor;
                document.getElementById("grupo").value=grupo;
            }
        </script>
    </body>
</html>
