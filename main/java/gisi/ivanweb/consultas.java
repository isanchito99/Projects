/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gisi.ivanweb;

import gisi.model.empresas;
import gisi.model.marcajes;
import gisi.model.proyectos;
import gisi.model.usuarios;
import gisi.model.usuarios_proyectos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author isr10
 */
public class consultas {

    private Connection connection;
    private Registro registro;

    public consultas() {

        //      connection = BBDDConnection.getConnection();
    }

    /**
     * Calcula el tiempo de la jornada laboral
     *
     * @param fechaAlta
     * @param fechaBaja
     * @return
     */
    public String calcularTiempoTrabajado(Date fechaAlta, Date fechaBaja) {
        long diffInMilliseconds = fechaBaja.getTime() - fechaAlta.getTime();
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(diffInMilliseconds);

        // Calcular horas, minutos y segundos
        long hours = diffInSeconds / 3600;
        long minutes = (diffInSeconds % 3600) / 60;
        long seconds = diffInSeconds % 60;

        return hours + " horas, " + minutes + " minutos, " + seconds + " segundos";
    }
    // LISTAR EMPRESAS

    public List<empresas> getAllEmpresas() {
        /**
         *
         */
        List<empresas> empresasDB = new ArrayList<empresas>();
        try {
            connection = BBDDConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from empresa");
            registro.registroLog("Empresas listadas\n");
            while (rs.next()) {
                empresas empresa = new empresas();
                empresa.setEmpresaid(rs.getInt("id_empresa"));
                empresa.setNombreEmpresa(rs.getString("nombre_empresa"));
                empresasDB.add(empresa);

            }
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e + "\n");
        }
        return empresasDB;

    }

    public void addEmpresa(empresas empresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into empresa(id_empresa,nombre_empresa) values (?, ? )");
            preparedStatement.setInt(1, empresa.getEmpresaid());
            preparedStatement.setString(2, empresa.getNombreEmpresa());
            preparedStatement.executeUpdate();
            registro.registroLog("Empresas añadida\n");
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e);
        }
    }

    public void deleteEmpresa(int empresaid) {
        registro.registroLog("Empresa " + empresaid + " eliminado\n");
        try {
            System.out.println("Aqui llega");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM empresa WHERE id_empresa =?;");
            // Parameters start with 1 
            preparedStatement.setInt(1, empresaid);
            preparedStatement.executeUpdate();
            registro.registroLog("Empresa " + empresaid + " eliminada\n");

            System.out.println("Aqui llega 2");
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e);
        }

    }
    //LISTAR MARCAJES 

    public List<marcajes> getAllMarcajes() {
        List<marcajes> marcajesDB = new ArrayList<marcajes>();

        try {
            connection = BBDDConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from marcajes;");
            registro.registroLog("Marcajes listados\n");
            while (rs.next()) {
                marcajes marcaje = new marcajes();
                marcaje.setMarcajesid(rs.getInt("id"));
                marcaje.setFecha_marcajes(rs.getDate("fecha"));
                marcaje.setTipo_marcaje(rs.getString("tipo_marcaje"));
                marcaje.setIdUsuarios(rs.getInt("id_usuario"));

                marcajesDB.add(marcaje);

            }
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e + "\n");
        }
        return marcajesDB;
    }

    public void deleteMarcajes(int marcajesid) {
        registro.registroLog("Marcaje " + marcajesid + " eliminado\n");
        try {
            System.out.println("Aqui llega");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM marcajes WHERE id =?;");
            // Parameters start with 1 
            preparedStatement.setInt(1, marcajesid);
            preparedStatement.executeUpdate();
            registro.registroLog("Marcajes " + marcajesid + " eliminada\n");

            System.out.println("Aqui llega 2");
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e);
        }
    }
    //LISTAR PROYECTOS

    public List<proyectos> getAllProyectos() {
        List<proyectos> proyectosDB = new ArrayList<proyectos>();

        try {
            connection = BBDDConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from proyectos;");
            registro.registroLog("Proyectos listados\n");
            while (rs.next()) {
                proyectos proyecto = new proyectos();
                proyecto.setProyectoid(rs.getInt("id_proyecto"));
                proyecto.setNombreProyecto(rs.getString("nombre"));
                proyecto.setEmpresaid(rs.getInt("id_empresa"));
                proyectosDB.add(proyecto);

            }
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e + "\n");
        }
        return proyectosDB;
    }

    public void deleteProyectos(int proyectosid) {
        registro.registroLog("Proyecto " + proyectosid + " eliminado\n");
        try {
            System.out.println("Aqui llega");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM proyectos WHERE id_proyecto=?;");
            // Parameters start with 1 
            preparedStatement.setInt(1, proyectosid);
            preparedStatement.executeUpdate();
            registro.registroLog("Proyectos " + proyectosid + " eliminada\n");

            System.out.println("Aqui llega 2");
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e);
        }
    }

    //LISTAR USUARIOS
    public List<usuarios> getAllUusuarios() {
        List<usuarios> usuariosDB = new ArrayList<usuarios>();

        try {
            connection = BBDDConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuarios;");
            registro.registroLog("Usuarios listados\n");
            while (rs.next()) {
                usuarios usuario = new usuarios();
                usuario.setUserid(rs.getInt("id_user"));
                usuario.setUsuario(rs.getString("username"));
                usuario.setContrasena(rs.getString("password"));
                usuario.setDni(rs.getString("dni"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setFecha_alta(rs.getDate("fecha_alta"));
                usuario.setFecha_baja(rs.getDate("fecha_baja"));
                usuario.setTipo_usuario(rs.getString("tipo_usuario"));
                usuariosDB.add(usuario);

            }
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e + "\n");
        }
        return usuariosDB;
    }

    public List<usuarios> loginUsuarios() {
        List<usuarios> usuariosDBLogin = new ArrayList<usuarios>();

        try {
            connection = BBDDConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select username,password from usuarios;");
            registro.registroLog("Usuarios listados\n");
            while (rs.next()) {
                usuarios usuario = new usuarios();
                usuario.setUsuario(rs.getString("username"));
                usuario.setContrasena(rs.getString("password"));
                usuariosDBLogin.add(usuario);

            }
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e + "\n");
        }
        return usuariosDBLogin;
    }

    public void deleteUsuarios(int usuariosid) {
        registro.registroLog("Usuario " + usuariosid + " eliminado\n");
        try {
            System.out.println("Aqui llega");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usuarios WHERE id_user=?;");
            // Parameters start with 1 
            preparedStatement.setInt(1, usuariosid);
            preparedStatement.executeUpdate();

            //------------------------------------------------------------------------------------------------------------
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e);
        }
    }

    public List<usuarios_proyectos> getAllUusuariosProyectos() {
        List<usuarios_proyectos> usuariosPDB = new ArrayList<usuarios_proyectos>();

        try {
            connection = BBDDConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuarios_proyectos;");
            while (rs.next()) {
                usuarios_proyectos usuarioP = new usuarios_proyectos();
                usuarioP.setId(rs.getInt("id"));
                usuarioP.setId_proyecto(rs.getInt("id_user"));
                usuarioP.setId_usuario(rs.getInt("id_proyecto"));
                usuarioP.setFecha_alta(rs.getTimestamp("fecha_alta"));
                usuarioP.setFecha_baja(rs.getTimestamp("fecha_baja"));
                usuariosPDB.add(usuarioP);

            }
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e + "\n");
        }
        return usuariosPDB;
    }

    public void addMarcaje(marcajes marcaje) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into marcajes(id,fecha,tipo_marcaje,id_usuario) values (?,?,?,?);");
            //insert into marcajes(id,fecha,tipo_marcaje,id_usuario) values (7, '2023-01-23 12:45:56','E',2 );
            preparedStatement.setInt(1, marcaje.getMarcajesid());
            preparedStatement.setTimestamp(2, new Timestamp(marcaje.getFecha_marcajes().getTime()));
            preparedStatement.setString(3, marcaje.getTipo_marcaje());
            preparedStatement.setInt(4, marcaje.getIdUsuarios());
            preparedStatement.executeUpdate();

            //------------------------------------------------------------------------------------------------------------
            int marcajesid = marcaje.getMarcajesid();
            Timestamp fecha_marcajes = new Timestamp(marcaje.getFecha_marcajes().getTime());
            Registro.registroLog("Marcaje insertado - Marcajes ID: " + marcajesid + ", Fecha Marcajes: " + fecha_marcajes + "\n");
        } catch (SQLException e) {
            registro.registroLog("SQL Exception: " + e);
        }
    }

    public void updateMarcajes(marcajes marcaje) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update marcajes set  fecha=?, tipo_marcaje=?, id_usuario=?" + " where id=?");
// Parameters start with 1 
            // preparedStatement.setInt(1, marcaje.getMarcajesid());
            preparedStatement.setTimestamp(1, new Timestamp(marcaje.getFecha_marcajes().getTime()));
            preparedStatement.setString(2, marcaje.getTipo_marcaje());
            preparedStatement.setInt(3, marcaje.getIdUsuarios());
            preparedStatement.setInt(4, marcaje.getMarcajesid());
            preparedStatement.executeUpdate();

            int marcajesid = marcaje.getMarcajesid();
            Timestamp fecha_marcajes = new Timestamp(marcaje.getFecha_marcajes().getTime());
            Registro.registroLog("Marcaje actualizado - Marcajes ID: " + marcajesid + ", Fecha Marcajes: " + fecha_marcajes + "\n");
        } catch (SQLException e) {
            System.out.println("SQL Exception de los MARCAJES: " + e);
        }
    }

}
