package UDP;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente
{
    public static void main(String args[])
    {
        String numero;
        Scanner input = new Scanner(System.in);
        try
        {
            DatagramSocket socket = new DatagramSocket();
            InetAddress destino = InetAddress.getByName("localhost");
            
            System.out.println("Indroduzca un numero: ");
            numero = input.next();
            
            byte[] buf = numero.getBytes();
            
            DatagramPacket paquete = new DatagramPacket(buf, buf.length,destino,5000);
            
            socket.send(paquete);
            System.out.println("Paquete enviado: "+numero);
            
            byte[] buffer = new byte[256];
            DatagramPacket paquete_vuelta = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquete_vuelta);
            String respuesta = new String (paquete_vuelta.getData());
            
            System.out.println("Resultado recibido del servidor --> "+respuesta);
            socket.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
