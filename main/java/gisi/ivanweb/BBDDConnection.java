/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gisi.ivanweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author isr10
 */
public class BBDDConnection {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        Registro registro;
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3307/rrhh";
        String user = "root";
        String password = "root";
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
            
            //Aquí hacemos uso de la conexión
            //Guardar en log que hemos realizado correctamente la conexión

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e);

        } catch (ClassNotFoundException e) {
            System.out.println("Error clase no encontrada: " + e);
        }

        return connection;
    }
}
