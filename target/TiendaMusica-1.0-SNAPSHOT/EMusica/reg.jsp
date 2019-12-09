<%-- 
    Document   : reg
    Created on : 11-29-2019, 10:53:13 AM
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
            <div class="row"><h2><br>Actualizando Estilo Musical</h2></div>
            <div class="row">
                <div class="col-4"><br>
                    <form action="/TiendaMusica/emusica?action=update" method="post">
                        <label>Codigo: </label>
                        <input type="text" class="form form-control" readonly="" name="id" value="${em.id}">
                        <label>Nombre: </label>
                        <input type="text" class="form form-control" required name="nombre" value="${em.nombre}">
                        <br>
                     
                        <br>
                        <button type="submit" class="btn btn-warning">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
        
        
    </body>
</html>
