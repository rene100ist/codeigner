<%-- 
    Document   : index
    Created on : 11-28-2019, 04:43:30 PM
    Author     : rene.linaresusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    String usuario;
    if (sesion.getAttribute("usuario") != null) {
        usuario = sesion.getAttribute("usuario").toString();
    } else {
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body >

        <%@include file="Resources/navbar.jsp" %>
        <div class="container">       
            <form method="post" action="usua?action=salir">
                <input class="btn btn-danger" type="submit" value="Cerrar Sesion">
            </form>
            <br>
         
        </div>
           <!-- ======== CARRUSEL ================================================ -->
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" >
                    <div class="carousel-item active">
                        <img src="Resources/images/hs.png" alt="" class="d-block w-100" style="width: 10px; height: 600px;"/>
                    </div>
                    <div class="carousel-item">
                        <img src="Resources/images/SharedImage-18729.jpg" alt="" class="d-block w-100" style="width: 10px; height: 600px;"/>
                    </div>
                    <div class="carousel-item">
                        <img src="Resources/images/acdc.jpg" alt="" class="d-block w-100" style="width: 10px; height: 600px;"/>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">atras</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">siguiente</span>
                </a>
            </div>
            <!-- ======== FIN ================================================ -->
    </body>
</html>
