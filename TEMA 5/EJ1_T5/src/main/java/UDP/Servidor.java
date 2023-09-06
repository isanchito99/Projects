package UDP;
import java.io.*;
import java.net.*;
import java.time.LocalDate;

public class Servidor
{
    public static void main(String args[])
    {
        try
        {
            DatagramSocket socket = new DatagramSocket(5000);
            System.out.println("---Iniciando servidor---");
            
            byte[] buf = new byte[256];
            DatagramPacket paquete = new DatagramPacket(buf , buf.length);
            socket.receive(paquete);
            String fecha_nacimiento = new String(paquete.getData());
            System.out.println("Mensaje recibido del cliente: "+fecha_nacimiento);
            
            //tenemos un string hay que convertirlo a LocalDate:
            String[] fecha_separada = fecha_nacimiento.split("-"); //obtenemos por separado el dia, mes y año
            int año = Integer.parseInt(fecha_separada[2].trim());
            int mes = Integer.parseInt(fecha_separada[1].trim());
            int dia = Integer.parseInt(fecha_separada[0].trim());
            
            LocalDate fecha = LocalDate.of(año,mes,dia);
            LocalDate fecha_actual = LocalDate.now();
            
            int dias_actuales = fecha_actual.getYear()*365+ fecha_actual.getDayOfYear();
            int dias_nacimiento = fecha.getYear()*365 + fecha.getDayOfYear();
            int edad = (dias_actuales-dias_nacimiento)/365;
            String edad_string = String.valueOf(edad);
            
            buf = edad_string.getBytes();
            DatagramPacket paquete_respuesta = new DatagramPacket(buf, buf.length,paquete.getAddress(),paquete.getPort());
            socket.send(paquete_respuesta);
            System.out.println("Mesaje enviado al cliente: "+edad_string);
            
            socket.close();
        } 
        catch (IOException e) {}
    }
}
