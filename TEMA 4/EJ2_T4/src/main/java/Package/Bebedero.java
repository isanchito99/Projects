
package Package;
import java.util.concurrent.Semaphore;

public class Bebedero {
    private Semaphore lleno = new Semaphore(8); //el bebedero tiene capacidad para 8 pollos
    //solo necesitamos un semaforo que nos diga si el bebedero está lleno, ya que al no haber un consumidor no será 
    //necesario crear un semaforo "vacio" ni al tener una seccion critica con alguna variable compartida tampoco es necesario
    //crear un semaforo para garantizar la exclucion mutua
    
    public void ocupar_bebedero(){
        try{
            lleno.acquire(); //restamos -1 a lleno
        }
        catch (InterruptedException ie){}
    }
    
    public void soltar_bebedero(){
        lleno.release(); //sumamos +1 a lleno
    }
}
