/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author jorge
 */
public class Servidor {

    
    public static void main(String[] args) {
        try{
            Operaciones operaciones = new Operaciones();
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("//127.0.0.1/ObjetoOperaciones", operaciones);
            System.out.println("El objeto operaciones ha quedado registrado");
        }
        catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
}
