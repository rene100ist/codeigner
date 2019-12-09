<%-- 
    Document   : reg
    Created on : 11-28-2019, 08:41:27 AM
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
            <div class="row"><h2><br>Actualizando Pais</h2></div>
            <div class="row">
                <div class="col-4"><br>
                    <form action="/TiendaMusica/pais?action=update" method="post">
                        <label>Codigo:</label>
                        <input type="text" class="form form-control" required readonly="" name="id" value="${pa.id}">
                        <label>Pais:</label>
                        <input type="text" class="form form-control" required name="nombre" value="${pa.nombre}">
                        <label>Direccion</label>
                        <input type="text" class="form form-control" required name="direccion" value="${pa.direccion}">
                        <label>Codigo Postal</label>
                        <input type="text" class="form form-control" required name="codigo_postal" value="${pa.codigo_postal}">
                        <br>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
