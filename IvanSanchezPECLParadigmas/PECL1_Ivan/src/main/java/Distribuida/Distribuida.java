
package Distribuida;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Distribuida extends Remote {

    String buzonTexto() throws RemoteException, InterruptedException;

    String cantidadBuzon() throws RemoteException, InterruptedException;

    String F1Texto() throws RemoteException, InterruptedException;

    String F2Texto() throws RemoteException, InterruptedException;

}
