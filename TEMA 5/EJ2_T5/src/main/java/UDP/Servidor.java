package UDP;
import java.io.*;
import java.net.*;

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
            String numero = new String(paquete.getData());
            System.out.println("Mensaje recibido del cliente: "+numero);
            
            
            int n = Integer.parseInt(numero.trim());
            String resultado = es_primo(n);
            
            buf = resultado.getBytes();
            DatagramPacket paquete_respuesta = new DatagramPacket(buf, buf.length,paquete.getAddress(),paquete.getPort());
            socket.send(paquete_respuesta);
            System.out.println("Resultado enviado al cliente: "+resultado);
            
            socket.close();
        } 
        catch (IOException e) {}
    }
    
    public static String es_primo(int numero){
        int divisores=0;
        
        for (int i = 1; i <=numero; i++) {
            if(numero%i == 0){
                divisores++;
            }
        }
        
        if (divisores==2) return "Es primo";
        else return "No es primo";
    }
    
}
