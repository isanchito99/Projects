package TCP;
import java.io.*;
import java.net.*;
import java.time.LocalDate;

public class Servidor
{
    public static void main(String args[])
    {
        ServerSocket servidor;
        Socket conexion;
        DataOutputStream salida;
        DataInputStream entrada;
        try
        {
            servidor = new ServerSocket(5000); // Creamos un ServerSocket en el puerto 5000
            System.out.println("---Iniciando servidor---");
            while(true){
            conexion = servidor.accept();

            entrada = new DataInputStream(conexion.getInputStream());  // Abrimos los canales de E/S
            salida = new DataOutputStream(conexion.getOutputStream());
            
            String fecha_nacimiento = entrada.readUTF();    //Leemos el primer mensaje del cliente
            System.out.println("Fecha recibida del cliente: "+fecha_nacimiento);
            
            //tenemos un string hay que convertirlo a LocalDate:
            String[] fecha_separada = fecha_nacimiento.split("-"); //obtenemos por separado el dia, mes y año
            int año = Integer.parseInt(fecha_separada[2]);
            int mes = Integer.parseInt(fecha_separada[1]);
            int dia = Integer.parseInt(fecha_separada[0]);
            
            LocalDate fecha = LocalDate.of(año,mes,dia);
            LocalDate fecha_actual = LocalDate.now();
            
            int dias_actuales = fecha_actual.getYear()*365+ fecha_actual.getDayOfYear();
            int dias_nacimiento = fecha.getYear()*365 + fecha.getDayOfYear();
            int edad = (dias_actuales-dias_nacimiento)/365;
           
            salida.writeInt(edad);
            System.out.println("Edad enviada al cliente");
            
            entrada.close();
            salida.close();
            conexion.close();   
            }
        } 
        catch (IOException e) {}
    }
}
