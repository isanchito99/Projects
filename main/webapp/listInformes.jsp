<%-- 
    Document   : listInformes
    Created on : 9 jun. 2023, 16:01:56
    Author     : isr10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.concurrent.TimeUnit" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href=".\css\styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>INFORMES</title>
    <style>
        /* Estilo para la tabla */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        /* Estilo para el encabezado de la tabla */
        thead {
            background-color: #f2f2f2;
        }

        thead th {
            padding: 10px;
            font-weight: bold;
            text-align: left;
        }

        /* Estilo para las celdas de datos */
        tbody td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
        }

        /* Estilo para las filas impares */
        tbody tr:nth-child(odd) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <div class="header">
        <ul>
            <li><a href="index.jsp"><img src=".\img\logo.jpg" alt="Logo"></a></li>
            <li><a href="https://www.uah.es/es/">Contacto</a></li>
            <li><a href="https://www.uah.es/es/">Acerca de nosotros</a></li>
            <li class="company-name">Ingenieros al Peso S.A</li>
        </ul>
        <br>
    </div>

    <!-- Tabla para mostrar los informes de usuarios y proyectos -->
    <table> 
        <thead> 
            <tr> 
                <th scope="col">ID</th> 
                <th scope="col">ID Usuario Proyecto</th>
                <th scope="col">ID Proyecto</th>  
                <th scope="col">Fecha Alta</th> 
                <th scope="col">Fecha Baja</th> 
                <th scope="col">Tiempo Trabajado</th>
            </tr> 
        </thead> 
        <tbody> 
            <c:forEach items="${usuariosP}" var="usuarioP"> 
                <tr> 
                    <td scope="row"><c:out value="${usuarioP.id}" /></td>
                    <td><c:out value="${usuarioP.id_usuario}" /></td>                 
                    <td><c:out value="${usuarioP.id_proyecto}" /></td>
                    <td><c:out value="${usuarioP.fecha_alta}" /></td>
                    <td><c:out value="${usuarioP.fecha_baja}" /></td>
                    <td>
                        <!-- Calcular la diferencia de tiempo trabajado en horas y minutos -->
                        <c:set var="fechaAlta" value="${usuarioP.fecha_alta.time}" />
                        <c:set var="fechaBaja" value="${usuarioP.fecha_baja.time}" />
                        <c:set var="diferenciaMillis" value="${fechaBaja - fechaAlta}" />
                        <c:set var="diferenciaHoras" value="${TimeUnit.MILLISECONDS.toHours(diferenciaMillis)}" />
                        <c:set var="diferenciaMinutes" value="${TimeUnit.MILLISECONDS.toMinutes(diferenciaMillis)}" />
                        <c:out value="${diferenciaHoras} horas = " />
                        <c:out value="${diferenciaMinutes} minutos " />
                    </td>
                </tr> 
            </c:forEach> 
        </tbody> 
    </table> 

    <br>
    <br>
    
    <!-- Formulario para agregar usuarios_proyectos -->
    <form method="post" action="servletUsuariosProyectos">
        <label for="usuariosProyectosId">ID de usuarios_proyectos:</label>
        <input type="text" name="usuariosProyectosId" id="usuariosProyectosId" required><br>
        <label for="idUsuario">ID de usuario:</label>
        <input type="text" name="idUsuario" id="idUsuario" required><br>
        <label for="idProyecto">ID de proyecto:</label>
        <input type="text" name="idProyecto" id="idProyecto" required><br>
        <label for="fechaAlta">Fecha de alta:</label>
        <input type="datetime-local" name="fechaAlta" id="fechaAlta" required><br>
        <label for="fechaBaja">Fecha de baja:</label>
        <input type="datetime-local" name="fechaBaja" id="fechaBaja"><br><br>
        <input type="submit" value="Agregar usuarios_proyectos">
    </form>

    <footer>
        <p>&copy; 2023 Ivan Sanchez Ranz | Arquitectura Web C/S</p>
    </footer>
</body>
</html>


