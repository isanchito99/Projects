package TCP;
import java.io.*;
import java.net.*;

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
            System.out.println("---Servidor iniciado---");
            conexion = servidor.accept();

            entrada = new DataInputStream(conexion.getInputStream());  // Abrimos los canales de E/S
            salida = new DataOutputStream(conexion.getOutputStream());
            
            int numero = entrada.read();    //Leemos el primer mensaje del cliente
            System.out.println("Numero recibido del cliente: "+numero);
            
            String resultado = es_primo(numero);
            salida.writeUTF(resultado);  // Le respondemos
            System.out.println("Resultado enviado al cliente");
            
            entrada.close();
            salida.close();
            conexion.close();   
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
