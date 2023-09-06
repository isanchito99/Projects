/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package gisi.controlador;

import gisi.ivanweb.BBDDConnection;
import gisi.ivanweb.Registro;
import gisi.ivanweb.consultas;
import gisi.model.marcajes;
import gisi.model.usuarios_proyectos;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ivan
 */
public class servletConsultas extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //private static String INSERT_OR_EDIT = "/error.jsp";
    private static String ERROR = "/error.jsp";
    private static String LIST_EMPRESAS = "/listEmpresas.jsp";
    private static String LIST_PROYECTOS = "/listProyectos.jsp";
    private static String LIST_MARCAJES = "/listMarcajes.jsp";
    private static String LIST_USUARIOS = "/listUsuarios.jsp";
    private static String LIST_EMPLEADOS = "/listEmpleados.jsp";
    private static String LIST_INFORMES = "/listInformes.jsp";
    private static String LIST_MARCAJE_CLIENTE = "/marcajeCliente.jsp";

    private consultas cons;
    private Registro registro;

    public servletConsultas() {
        super();
        cons = new consultas();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";

        String action = request.getParameter("action");
        //LISTAR PERSONAS
        if (action.equalsIgnoreCase("listProyectos")) {

            forward = LIST_PROYECTOS;
            request.setAttribute("proyectos", cons.getAllProyectos());
            System.out.println("FUNCIONA PROYECTOS");
            System.out.println(cons.getAllProyectos());
        } else if (action.equalsIgnoreCase("listMarcajes")) {

            forward = LIST_MARCAJES;
            request.setAttribute("marcajes", cons.getAllMarcajes());
            System.out.println("FUNCIONA MARCAJES");
            System.out.println(cons.getAllMarcajes());
        } else if (action.equalsIgnoreCase("listMarcajesClientes")) {

            forward = LIST_MARCAJE_CLIENTE;
            request.setAttribute("marcajes", cons.getAllMarcajes());
            System.out.println("FUNCIONA MARCAJES EN LOS CLIENTES");
            System.out.println(cons.getAllMarcajes());
        } else if (action.equalsIgnoreCase("listEmpresas")) {
            forward = LIST_EMPRESAS;
            request.setAttribute("empresas", cons.getAllEmpresas());
            System.out.println("FUNCIONA EMPRESAS");
            System.out.println(cons.getAllEmpresas());

        } else if (action.equalsIgnoreCase("listUsuarios")) {
            forward = LIST_USUARIOS;
            request.setAttribute("usuarios", cons.getAllUusuarios());
            System.out.println("FUNCIONA USUARIOS");
            System.out.println(cons.getAllUusuarios());

        } else if (action.equalsIgnoreCase("listEmpleados")) {
            forward = LIST_EMPLEADOS;
            request.setAttribute("usuariosP", cons.getAllUusuariosProyectos());
            request.setAttribute("usuarios", cons.getAllUusuarios());
            System.out.println("FUNCIONA USUARIOS");
            System.out.println(cons.getAllUusuariosProyectos());

        } else if (action.equalsIgnoreCase("listInformes")) {
            
            forward = LIST_INFORMES;
            request.setAttribute("usuariosP", cons.getAllUusuariosProyectos());
            System.out.println("FUNCIONA INFORMES");
            System.out.println(cons.getAllUusuariosProyectos());

        } //CONSULTAS DE BORRADO
        else if (action.equalsIgnoreCase("deleteEmpresa")) {
            System.out.println("1");
            int empresaid = Integer.parseInt(request.getParameter("id_empresa"));
            cons.deleteEmpresa(empresaid);
            System.out.println("2");
            forward = LIST_EMPRESAS;
            request.setAttribute("empresas", cons.getAllEmpresas());
            System.out.println("3");
        } else if (action.equalsIgnoreCase("deleteMarcajes")) {
            System.out.println("1");
            int marcajeid = Integer.parseInt(request.getParameter("id"));
            cons.deleteMarcajes(marcajeid);
            System.out.println("2");
            forward = LIST_MARCAJES;
            request.setAttribute("marcajes", cons.getAllMarcajes());
            System.out.println("3");

        } else if (action.equalsIgnoreCase("deleteProyectos")) {
            System.out.println("1");
            int proyectoid = Integer.parseInt(request.getParameter("id_proyecto"));
            cons.deleteProyectos(proyectoid);
            System.out.println("2");
            forward = LIST_PROYECTOS;
            request.setAttribute("proyectos", cons.getAllProyectos());
            System.out.println("3");

        } else if (action.equalsIgnoreCase("deleteUsuarios")) {
            System.out.println("1");
            int usuarioid = Integer.parseInt(request.getParameter("id_user"));
            cons.deleteUsuarios(usuarioid);
            System.out.println("2");
            forward = LIST_USUARIOS;
            request.setAttribute("usuarios", cons.getAllUusuarios());
            System.out.println("3");

        } else {
            System.out.println("NO FUNCIONA");
            forward = ERROR;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

        //return;
    }

    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //USADO PARA AÑADIR MARCAJES POR PARTE DE LOS CLIENTES
        Registro registro;

        marcajes marcaje = new marcajes();

        try {
           
            marcaje.setMarcajesid(Integer.parseInt(request.getParameter("marcajesid")));
            String fecha = request.getParameter("altadate");
            //Cambio de formato
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            Date dateAlta = in.parse(fecha);
            marcaje.setFecha_marcajes(dateAlta);
            marcaje.setTipo_marcaje(request.getParameter("tipoMarcaje"));
            marcaje.setIdUsuarios(Integer.parseInt(request.getParameter("iduser")));
            String marcajeid = request.getParameter("marcajesid");
            boolean estaid = existeMarcajeId(marcajeid);
            //cons.addMarcaje(marcaje);
            if (!estaid) {
                System.out.println("ENTRA AL INSERTAR");
                cons.addMarcaje(marcaje);
            } else {
                System.out.println("ENTRA AL ACTUALIZAR");
                marcaje.setMarcajesid(Integer.parseInt(marcajeid));
                cons.updateMarcajes(marcaje);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        request.setAttribute("marcajes", cons.getAllMarcajes());
        RequestDispatcher view = request.getRequestDispatcher(LIST_MARCAJES);
        view.forward(request, response);
        return;
    }

    /*
    String fechaAltaStr = request.getParameter("altadate");
String fechaBajaStr = request.getParameter("bajadate");
DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
try {
    LocalDate fechaAlta = LocalDate.parse(fechaAltaStr, dateFormatter);
    LocalDate fechaBaja = LocalDate.parse(fechaBajaStr, dateFormatter);
    userP.setFecha_alta(fechaAlta);
    userP.setFecha_baja(fechaBaja);
} catch (DateTimeParseException e) {
    e.printStackTrace(); // Otra forma de manejo de errores
}*/
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean existeMarcajeId(String marcajesId) {
        String query = "SELECT id FROM marcajes WHERE id = ?";
        try ( Connection connection = BBDDConnection.getConnection();  
          PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, marcajesId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
