/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package gisi.controlador;

import gisi.ivanweb.BBDDConnection;
import gisi.ivanweb.Registro;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author isr10
 */
@WebServlet(name = "Login", value = "/Login")
/**
 * 
 */
public class Login extends HttpServlet {

    String forward;
   /* private final String userID = "admin";
    private final String password = "admin";
    private final String clienteID = "usuario";
    private final String cliPassword = "usuario";*/
    private Connection connection;
    private Registro registro;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        forward = "index.jsp";
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        
        String user = request.getParameter("usuario");
        String pwd = request.getParameter("password");
        String[] credentials = getUserCredentials(user, pwd);
        String tipoUser=getTipoUsuario(user, pwd);
        if (credentials!=null&&credentials[0].equals(user) && credentials[1].equals(pwd) ) {
            if(tipoUser.equals("A")){
            
            Cookie loginCookie = new Cookie("user", user);
            Cookie cookie = new Cookie("msg", "4558858858585");
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.addCookie(cookie);
            response.sendRedirect("RRHH.jsp");
            
            }else if (tipoUser.equals("U")){
                
             
            Cookie loginCookie = new Cookie("user", user);
            Cookie cookie = new Cookie("msg", "4558858858585");
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.addCookie(cookie);
            response.sendRedirect("Clientes.jsp");

            }
            else{
                System.out.println("NO ENTRA EN NINGUNO");}

        }  else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out = response.getWriter();
            out.println("<div style=\"color: purple; font-weight: bold; text-align: center;\">");
            out.println("Usuario o contraseña incorrectos.");
            out.println("<br>");
            out.println("Por favor ingreselo correctamente.");
            out.println("</div>");
            rd.include(request, response);
        }

    }
/**
 * 
 * @param username //devuelve el username de la BBDD
 * @param password //devuelve la contraseña de la BBDD
 * @return 
 */
    public String[] getUserCredentials(String username, String password) {
        String[] credentials = new String[2];

        try {
            // Establecer la conexión con la base de datos
            connection = BBDDConnection.getConnection();

            // Crear la consulta preparada para obtener los datos del usuario
            String query = "SELECT username,password FROM usuarios WHERE username = ? AND password=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Obtener los valores de la consulta
                credentials[0] = resultSet.getString("username");
                credentials[1] = resultSet.getString("password");

            } else {
                // El usuario no existe en la base de datos
                credentials = null;
            }

            // Cerrar la conexión y liberar recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            credentials = null;
        }

        return credentials;
    }
/**
 * 
 * @param username //devuelve el username de la BBDD
 * @param password //devuelve la contraseña de la BBDD
 * @return 
 */
    public String getTipoUsuario(String username, String password) {
        String tipoUsuario = "";
        
        try {
            // Establecer la conexión con la base de datos
            connection = BBDDConnection.getConnection();

            // Crear la consulta preparada para obtener los datos del usuario
            String query = "SELECT tipo_usuario FROM usuarios WHERE username = ? AND password=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Obtener los valores de la consulta
                tipoUsuario = resultSet.getString("tipo_usuario");

            } else {
                // El usuario no existe en la base de datos
                System.out.println("Error");
            }

            // Cerrar la conexión y liberar recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return tipoUsuario;
    }

}
