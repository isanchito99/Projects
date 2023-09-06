<%-- 
    Document   : error
    Created on : 23 may. 2023, 20:28:07
    Author     : isr10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="gisi.ivanweb.Registro" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error 404 - Página no encontrada</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                margin-top: 150px;
            }

            h1 {
                font-size: 36px;
            }

            p {
                font-size: 18px;
            }

            a {
                color: #1e88e5;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%
            Registro.registroLog("La página de error 404 fue cargada.");
        %>
        <h1>Error 404</h1>
        <p>Lo sentimos, se ha producido un error.</p>
        <p><a href="index.jsp">Volver a la página de inicio</a></p>
    </body>
</html>
