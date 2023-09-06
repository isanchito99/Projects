package TCP;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente
{
    public static void main(String args[])
    {
        Socket cliente;
        DataInputStream entrada;
        DataOutputStream salida;
        int numero;
        Scanner input = new Scanner(System.in);
        try
        {
            cliente = new Socket(InetAddress.getLocalHost(),5000);
            entrada = new DataInputStream(cliente.getInputStream()); 
            salida = new DataOutputStream(cliente.getOutputStream());
            
            System.out.println("Introduzca un numero: ");
            numero = input.nextInt();
            
            salida.write(numero); // Enviamos el numero al servidor
            System.out.println("Se ha enviado al servidor el numero: "+numero);
            
            String respuesta = entrada.readUTF();
            System.out.println("Resultado recibido del servidor --> "+respuesta);
            
            entrada.close();
            salida.close();
            cliente.close();    // Cerramos la conexión
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
