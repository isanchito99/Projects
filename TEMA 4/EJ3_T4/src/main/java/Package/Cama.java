
package Package;

public class Cama {
    private int sitios_disponibles=10;
    
    public synchronized void ocupar_cama(){
        while(sitios_disponibles==0){
            System.out.println("LA CAMA ESTA LLENA");
            try{
                wait();
            }
            catch(InterruptedException ie){}
        }
        sitios_disponibles--;
    }
    
    public synchronized  void soltar_cama(){
        sitios_disponibles++;
        notify();
    }
}
