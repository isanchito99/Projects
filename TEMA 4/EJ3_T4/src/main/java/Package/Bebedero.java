
package Package;

public class Bebedero {
    private int sitios_disponibles=8;
    
    public synchronized void ocupar_bebedero(){
        while(sitios_disponibles==0){
            System.out.println("EL BEBEDERO ESTA LLENO");
            try{
                wait();
            }
            catch(InterruptedException ie){}
        }
        sitios_disponibles--;
    }
    
    public synchronized void soltar_bebedero(){
        sitios_disponibles++;
        notify();
    }
}
