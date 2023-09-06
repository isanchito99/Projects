<%-- 
    Document   : listMarcajes
    Created on : 4 jun. 2023, 16:09:41
    Author     : isr10
--%>

<%-- 
    Document   : informationRRHH
    Created on : 24 may. 2023, 23:04:39
    Author     : isr10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href=".\css\styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
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

    <!-- Tabla para mostrar los marcajes -->
    <table> 
        <thead> 
            <tr> 
                <th scope="col">Marcaje</th> 
                <th scope="col">Fecha del Marcaje</th>
                <th scope="col">Tipo de Marcaje</th> 
                <th scope="col">Usuario asociado</th> 
            </tr> 
        </thead> 
        <tbody> 
            <c:forEach items="${marcajes}" var="marcaje"> 
                <tr> 
                    <td scope="row"><c:out value="${marcaje.marcajesid}" /></td>
                    <td><c:out value="${marcaje.fecha_marcajes}" /></td>
                    <td><c:out value="${marcaje.tipo_marcaje}" /></td>
                    <td><c:out value="${marcaje.idUsuarios}" /></td>
                    <td><a href="servletConsultas?action=deleteMarcajes&id=<c:out value="${marcaje.marcajesid}"/>">Delete</a></td> 
                </tr> 
            </c:forEach> 
        </tbody> 
    </table> 

    <footer>
        <p>&copy; 2023 Ivan Sanchez Ranz | Arquitectura Web C/S</p>
    </footer>
</body>
</html>
