/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jorge
 */
public class Operaciones extends UnicastRemoteObject implements InterfaceOperaciones{
    
    public Operaciones() throws RemoteException {}
    
    @Override
    public int multiplicar(int numero1, int numero2) throws RemoteException{
       return numero1*numero2;
    }
    
    @Override
    public int elevar(int numero1, int numero2) throws RemoteException{
       return (int)(Math.pow(numero1, numero2));
    }
}
