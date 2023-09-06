
package Package;

import java.util.concurrent.Semaphore;

public class Cama {
     private Semaphore lleno = new Semaphore(10); //la cama tiene capacidad para 10 pollos
    //solo necesitamos un semaforo que nos diga si la cama está llena, ya que al no haber un consumidor no será 
    //necesario crear un semaforo "vacio" ni al tener una seccion critica con alguna variable compartida tampoco es necesario
    //crear un semaforo para garantizar la exclucion mutua
     
    public void ocupar_cama(){
        try{
            lleno.acquire();
        }
        catch(InterruptedException ie){}
    }
    
    public void soltar_cama(){
        lleno.release();
    }
}
