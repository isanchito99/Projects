<%-- 
    Document   : index
    Created on : 18 may. 2023, 18:03:36
    Author     : isr10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <meta charset="UTF-8">
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
  
  <div class="container">
    <div class="login-form">
      <h2>Iniciar sesión</h2>
      <form method="POST" action="Login">
        <label for="username">Nombre de usuario:</label>
        <input type="text" value="" name="usuario" id="username" onclick="document.getElementById('user').value=''" required>
        <!-- El campo de texto para el nombre de usuario -->
        <label for="password">Contraseña:</label>
        <input type="password" value="" name="password" id="password" required>
        <!-- El campo de texto para la contraseña -->
        <br>
        <input type="submit" value="Iniciar sesión" id="button_login">
        <!-- Botón para enviar el formulario de inicio de sesión -->
      </form>
    </div>
  </div>
  
  <footer>
    <p>&copy; 2023 Ivan Sanchez Ranz | Arquitectura Web C/S</p>
  </footer>
</body>
</html>
