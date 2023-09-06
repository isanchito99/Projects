package TCP;
import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Cliente
{
    public static void main(String args[])
    {
        Socket cliente;
        DataInputStream entrada;
        DataOutputStream salida;
        String fecha_nacimiento;
        Scanner input = new Scanner(System.in);
        try
        {
            cliente = new Socket(InetAddress.getLocalHost(),5000);
            entrada = new DataInputStream(cliente.getInputStream()); 
            salida = new DataOutputStream(cliente.getOutputStream());
            
            System.out.println("Introduza su fecha de nacimiento (Formato dd-mm-yyyy):");
            fecha_nacimiento= input.next();
            
            salida.writeUTF(fecha_nacimiento);// Enviamos el primer numero al servidor
            System.out.println("Se ha enviado al servidor la fecha de nacimiento: "+fecha_nacimiento);
            
            int respuesta = entrada.readInt();
            System.out.println("Resultado recibido del servidor -> "+respuesta +" años");
            
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
