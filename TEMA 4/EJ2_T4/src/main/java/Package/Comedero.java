
package Package;
import java.util.concurrent.Semaphore;
public class Comedero {
    private Semaphore lleno = new Semaphore(4); //el comedero tiene capacidad para 4 pollos
    //solo necesitamos un semaforo que nos diga si el comedero está lleno, ya que al no haber un consumidor no será 
    //necesario crear un semaforo "vacio" ni al tener una seccion critica con alguna variable compartida tampoco es necesario
    //crear un semaforo para garantizar la exclucion mutua
    
    public void ocupar_comedero(){
        try{
            lleno.acquire(); //restamos -1 a lleno
        }
        catch (InterruptedException ie){}
    }
    
    public void soltar_comedero(){
        lleno.release(); //sumamos +1 a lleno
    }
}
