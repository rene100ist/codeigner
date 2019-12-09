<%-- 
    Document   : index
    Created on : 11-28-2019, 08:41:21 AM
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
            <div class="row">
                <a style="display: ${hid}" class="btn btn-primary" href="/TiendaMusica/pais?action=redi">Ingresar PAis</a>
                </div>
            <div class="row">
                <h1>Listado de Pais</h1>
                    <table class="table table-dark table-hover table-bordered">
                        <thead>
                            <tr>
                                <td>Codigo</td>
                                <td>Nombre Pais</td>
                                <td>Direccion</td>
                                <td>Codigo Postal</td>
                                <td style="display: ${hid}" >Acciones</td>
                            </tr>
                        </thead>
                        <% int cod = 1; %>
                        <c:forEach items="${listap}" var="ver">
                            <tbody>
                                <tr>
                                    <td><% out.print(cod); %></td>
                                    <td>${ver.getNombre()}</td>
                                    <td>${ver.getDireccion()}</td>
                                    <td>${ver.getCodigo_postal()}</td>
                                    <td style="display: ${hid}">
                                        <a class="btn btn-warning" href="/TiendaMusica/pais?action=consultarId&id=${ver.id}">Modificar</a>
                                        <a style="display: ${hid}" class="btn btn-danger" href="/TiendaMusica/pais?action=eliminar&id=${ver.id}">Eliminar</a>
                                    </td>
                                </tr>
                            </tbody> 
                            <% cod++;%>
                        </c:forEach>
                    </table>
                </div>
            </div>
    </body>
</html>
