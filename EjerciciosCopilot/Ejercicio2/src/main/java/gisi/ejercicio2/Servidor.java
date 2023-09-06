/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package gisi.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author isr10
 */
public class Servidor {

    public static void main(String[] args) {

        int[][] matriz = new int[10][4];

        ServerSocket servidor;
        Socket conexion;
        DataInputStream entrada;
        DataOutputStream salida;
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado");
            while (true) {

                conexion = servidor.accept();
                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());

                // El servidor debe mantener una matriz de dimensión 10 filas x 4 columnas que
                // representa los asientos de un vagón de tren
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
                
                //muestro la matriz de asientos y se la envio al cliente
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.print(matriz[i][j] + " ");
                        //se le envio al cliente
                        salida.writeInt(matriz[i][j]);
                    }
                    System.out.println("");
                   
                }
                int i = entrada.readInt();
                int j = entrada.readInt();
                String respuesta = "";

                if (i > 10 || j > 4) {
                    System.out.println("Error, el numero de la fila o columna no es correcto");
                    break;
                }

                if (matriz[i][j] == 0) {
                    matriz[i][j] = 1;
                    respuesta = "Reservado";
                    salida.writeUTF(respuesta);
                    System.out.println("El asiento esta libre");
                    
                } else if (matriz[i][j] == 1) {
                    respuesta = "Ocupado";
                    salida.writeUTF(respuesta);
                    System.out.println("El asiento esta ocupado");
                    
                } else {
                    respuesta = "Completo";
                    salida.writeUTF(respuesta);
                    System.out.println("El vagón esta completo");
                }
                System.out.println("LOS ASIENTOS RESULTANTES SON: ");
                for (int k = 0; k < matriz.length; k++) {
                    for (int l = 0; l < matriz[k].length; l++) {
                        System.out.print(matriz[k][l] + " ");
                        //se le envio al cliente
                        salida.writeInt(matriz[k][l]);
                    }
                    System.out.println("");
                   
                }

            }
            entrada.close();
            salida.close();
            conexion.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
