<%-- 
    Document   : RRHH
    Created on : 18 may. 2023, 18:12:29
    Author     : isr10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Formulario de RRHH</title>
  <link rel="stylesheet" type="text/css" href=".\css\styles.css">
    <style>
    /* Estilos CSS adicionales */
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
  <div class="formRRHH">
    <h1>INGENIEROS AL PESO S.A</h1>
    <h1>RRHH</h1>
   
    <form>
      <label>
        <!-- Botón para listar empresas -->
        <button id="buttonRRHH" type="button"><a href="servletConsultas?action=listEmpresas"" id="links">Lista Empresas</a> </button>
      </label>
      <label>
        <!-- Botón para listar proyectos -->
        <button id="buttonRRHH" type="button"><a href="servletConsultas?action=listProyectos"" id="links">Lista Proyectos</a></button>
      </label>
      <label>
        <!-- Botón para listar marcajes -->
        <button id="buttonRRHH" type="button"><a href="servletConsultas?action=listMarcajes"" id="links">Listar Marcajes</a></button>
      </label>
      <label>
        <!-- Botón para listar usuarios -->
        <button id="buttonRRHH" type="button"><a href="servletConsultas?action=listUsuarios"" id="links">Listar Usuarios</a></button>
      </label>
      <label>
        <!-- Botón para ver/solicitar informes -->
        <button id="buttonInformes" type="button"><a href="servletConsultas?action=listInformes"" id="linksInformes">Ver/Solicitar Informes</a></button>
      </label>
    </form>
  </div>
    
  <footer>
    <p>&copy; 2023 Ivan Sanchez Ranz | Arquitectura Web C/S</p>
  </footer>
</body>
</html>
