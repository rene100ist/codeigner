<%-- 
    Document   : reg
    Created on : 11-29-2019, 04:13:44 PM
    Author     : rene.linaresusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../Resources/navbar.jsp" %>

        <div class="container">
            <div class="row"><h2><br>Actualizando Coleccion</h2></div>
            <div class="row">
                <div class="col-4"><br>
                    <form action="/TiendaMusica/coleccion?action=update" method="post">
                        <label>Codigo: </label>
                        <input type="number" class="form form-control" readonly="" name="isbn" value="${cdo.isbn}">
                        <label>Nombre Coleccion: </label>
                        <input type="text" class="form form-control" name="nombre_col" value="${cdo.nombre_col}">
                        <label>#Tienda </label>
                        <input type="number" class="form form-control" name="cod_tienda" value="${cdo.cod_tienda}">
                        <label>Precio Venta Coleccion: </label>
                        <input type="text" class="form form-control" name="pvpC" value="${cdo.pvpC}">
                        <label>promotor</label>
                        <input class="form form-control" name="promotor" value="${cdo.promotor}">
                        <br>
                        <!-- ================  lista de promotor traido  =============================================== -->
                        <label> Promotor </label>
                        <select name="promotor" id="promotor">
                            <option class="control-form" value="">Seleccione un promotor</option>
                            <c:forEach items="${listaco}" var="co">
                                <option value="${co.getId()}">${co.getNombre()}</option>
                            </c:forEach>
                        </select><br><br>
                        <!-- =====================  FIN =============================================== -->

                        <br>
                        <button type="submit" class="btn btn-warning">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
