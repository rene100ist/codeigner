<%-- 
    Document   : index
    Created on : 12-05-2019, 10:26:23 AM
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
                <h1>Listado de Ediciones</h1>
                    <table class="table table-dark table-hover table-bordered">
                        <thead>
                            <tr>
                                <td>Codigo</td>
                                <td>Fecha edicion</td>
                                <td class="bg-info">Compañia Actual</td>
                                <td>Compañia Antigua</td>
                                <td class="bg-info">Coleccion Actual</td>
                                <td>Coleccion Antigua</td>
                            </tr>
                        </thead>
                        <% int cod = 1; %>
                        <c:forEach items="${listade}" var="ver">
                            <tbody>
                                <tr>
                                    <td ><% out.print(cod); %></td>
                                    <td >${ver.getFecha()}</td>
                                    <td >${ver.getNewComp()}</td>
                                    <td >${ver.getOldComp()}</td>
                                    <td >${ver.getColeccion()}</td>
                                    <td >${ver.getOldColeccion()}</td> 
                                </tr>
                            </tbody> 
                            <% cod++;%>
                        </c:forEach>
                    </table>
                </div>
            </div>
    </body>
</html>
