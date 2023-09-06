package gisi.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        // TODO code application logic here
        Socket conexion;
        DataInputStream entrada;
        DataOutputStream salida;
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int j = 0;
        
        try {
            while (true) {

                conexion = new Socket("localhost", 5000);
                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());
                //recibo la matriz del servidor y la muestro por pantalla
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 4; l++) {
                        int asiento = entrada.readInt();
                        System.out.print(asiento + " ");
                    }
                    System.out.println("");
                }

                System.out.println("Introduce el numero de la fila: ");
                i = sc.nextInt();
                System.out.println("Introduce el numero de la columna: ");
                j = sc.nextInt();
                if (i > 9 || j > 3) {
                    System.out.println("Error, el numero de la fila o columna no es correcto");
                    break;
                }
                salida.writeInt(i);
                salida.writeInt(j);
                System.out.println("El valor de la matriz en la posicion " + i + " " + j);

                // Cuando el cliente intenta realizar una compra de billete, el servidor le
                // responde una de las siguientes opciones:

                // 1. Reservado: En este caso, el cliente, al recibir la respuesta, muestra un
                // mensaje por la salida estándar indicando que la compra se ha realizado
                // correctamente y finaliza su ejecución
                // 2. Ocupado: Junto con la lista de los asientos que se encuentran libres
                // actualmente. En este caso, el cliente, al recibir la respuesta, solicita otro
                // asiento hasta que logre comprar uno que está libre
                // 3. Vagón completo: En este caso, el cliente, al recibir la respuesta, la
                // muestra por salida estándar y finaliza su ejecución.
                String respuesta = entrada.readUTF();
                

                if (respuesta.equals("Reservado")) {
                    System.out.println("La compra se ha realizado correctamente");
                    //MOSTAR LOS ASIENTOS
                    
                    
                    break;
                } else if (respuesta.equals("Ocupado")) {
                    System.out.println("El asiento esta ocupado");
                    //MOSTAR LOS ASIENTOS
                    
                    
                } else {
                    System.out.println("El vagón esta completo");

                    break;
                }
                entrada.close();
                salida.close();
                conexion.close();

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
