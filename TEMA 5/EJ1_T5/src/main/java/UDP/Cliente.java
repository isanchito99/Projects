package UDP;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente
{
    public static void main(String args[])
    {
        String fecha_nacimiento;
        Scanner input = new Scanner(System.in);
        try
        {
            DatagramSocket socket = new DatagramSocket();
            
            System.out.println("Introduzca su fecha de nacimiento (formato dd-mm-yyyy):");
            fecha_nacimiento= input.next();
            
            byte[] buf = fecha_nacimiento.getBytes();
            InetAddress destino = InetAddress.getLocalHost();
            DatagramPacket paquete = new DatagramPacket(buf, buf.length,destino,5000);
            
            socket.send(paquete);
            System.out.println("Paquete enviado: "+fecha_nacimiento);
            
            byte[] buffer = new byte[256];
            DatagramPacket paquete_vuelta = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquete_vuelta);
            String respuesta = new String (paquete_vuelta.getData());
            
            System.out.println("Mensaje recibido del servidor: "+respuesta+ " años");
            socket.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
