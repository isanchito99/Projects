package Distribuida;

import Principal.Interfaz;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemoto extends UnicastRemoteObject implements Distribuida {

    private Interfaz interfaz;

    public ObjetoRemoto(Interfaz interfaz) throws RemoteException {

        this.interfaz = interfaz;
    }

    public String buzonTexto() throws RemoteException, InterruptedException {

        String texto = interfaz.buzonTexto();

        return texto;
    }

    public String cantidadBuzon() throws RemoteException, InterruptedException {
        String texto = interfaz.cantidadBuzon();

        return texto;
    }

    public String F1Texto() throws RemoteException, InterruptedException {
        String texto = interfaz.F1Texto();

        return texto;
    }

    public String F2Texto() throws RemoteException, InterruptedException {
        String texto = interfaz.F2Texto();

        return texto;
    }
}
