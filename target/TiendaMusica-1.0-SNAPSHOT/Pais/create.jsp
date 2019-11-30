<%-- 
    Document   : create
    Created on : 11-28-2019, 08:41:14 AM
    Author     : rene.linaresusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body >
         <%@include file="../Resources/navbar.jsp" %>
        <div class="container">
            <div class="row"><h2><br>Ingresando Pais</h2></div>
            <div class="row">
                <div class="col-4"><br>
                    <form action="/TiendaMusica/pais?action=insert" method="post">
                        <label>Pais:</label>
                        <input type="text" class="form form-control" name="nombre" value="">
                        <label>Direccion</label>
                        <input type="text" class="form form-control" name="direccion" value="">
                        <label>Codigo Postal</label>
                        <input type="text" class="form form-control" name="codigo_postal" value="">
                        <br>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
