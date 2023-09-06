/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jorge
 */
public interface InterfaceOperaciones extends Remote {
    int multiplicar(int numero1, int numero2) throws RemoteException;
    int elevar(int numero1, int numero2) throws RemoteException;
}
