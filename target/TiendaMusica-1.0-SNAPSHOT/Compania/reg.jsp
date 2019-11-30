<%-- 
    Document   : reg
    Created on : 11-29-2019, 10:37:15 AM
    Author     : rene.linaresusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="row"><h2><br>Actualizando Compania</h2></div>
            <div class="row">
                <div class="col-4"><br>
                    <form action="/TiendaMusica/compania?action=update" method="post">
                        <label>Codigo: </label>
                        <input type="text" class="form form-control" readonly="" name="id" value="${co.id}">
                        <label>Nombre: </label>
                        <input type="text" class="form form-control" name="nombre" value="${co.nombre}">
                        <br>
                         <!-- ================  lista de pais traido  =============================================== -->
                        <label>Sede:  </label>
                        <select name="pais" id="pais">
                            <option class="control-form" value="">Seleccione un pais</option>
                            <c:forEach items="${listap}" var="pa">
                                <option value="${pa.getId()}">${pa.getNombre()}</option>
                            </c:forEach>
                        </select>
                         <!-- ================  FIN  =============================================== -->
                        <br>
                        <button type="submit" class="btn btn-warning">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
