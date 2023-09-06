/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Cliente {

   
    public static void main(String[] args) {
        int respuesta;
        try{
            Scanner entrada = new Scanner(System.in);
            
            System.out.println("Introduzca el primer numero:");
            int numero1 = entrada.nextInt();
            System.out.println("Introduzca el segundo numero:");
            int numero2 = entrada.nextInt();
            String operacion = "";
            System.out.println("Introduzca la operacion que desea realizar (multiplicar o elevar)");
            operacion= entrada.next();
            while (!operacion.equals("multiplicar") && !operacion.equals("elevar")){
                System.out.println("Operacion no valida (multiplicar o elevar)");
                System.out.println("Introduzca la operacion que desea realizar (multiplicar o elevar)");
                operacion=entrada.next();
            }
            
            InterfaceOperaciones obj = (InterfaceOperaciones) Naming.lookup("//127.0.0.1/ObjetoOperaciones");
            if (operacion.equals("multiplicar")){
                respuesta= obj.multiplicar(numero1, numero2);
            }
            else{
                respuesta = obj.elevar(numero1, numero2);
            }
            System.out.println("El resultado de "+operacion+ " ambos numeros es: "+respuesta);
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
