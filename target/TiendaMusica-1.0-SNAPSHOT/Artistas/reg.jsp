<%-- 
    Document   : reg
    Created on : 11-29-2019, 11:36:21 AM
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
            <div class="row"><h2><br>Actualizando Artista</h2></div>
            <div class="row">
                <div class="col-4"><br>
                    <form action="/TiendaMusica/artistas?action=update" method="post">
                        <label>Codigo: </label>
                        <input type="text" class="form form-control" readonly="" name="id" value="${ar.id}">
                        <label>Nombre: </label>
                        <input type="text" class="form form-control" name="nombre" value="${ar.nombre}">
                        <label>Nombre Grupo: </label>
                        <input type="text" class="form form-control" name="grupo" value="${ar.grupo}">
                        <br>
                        <!-- ================  lista de pais traido  =============================================== -->
                        <label>Sede:  </label>
                        <select name="pais" id="pais">
                            <option class="control-form" value="">Seleccione un pais</option>
                            <c:forEach items="${listap}" var="pa">
                                <option value="${pa.getId()}">${pa.getNombre()}</option>
                            </c:forEach>
                        </select><br><br>
                        <!-- ================  FIN  =============================================== -->
                        <!-- ================  lista de estilo musical traido  =============================================== -->
                        <label> Estilo Musical </label>
                        <select name="estilo_musical" id="estilo_musical">
                            <option class="control-form" value="">Seleccione un estilo</option>
                            <c:forEach items="${listaem}" var="em">
                                <option value="${em.getId()}">${em.getNombre()}</option>
                            </c:forEach>
                        </select>
                        <!-- =====================  FIN =============================================== -->
                        <br>
                        <button type="submit" class="btn btn-warning">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
