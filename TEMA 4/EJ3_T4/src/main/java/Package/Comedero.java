
package Package;
public class Comedero {
    private int sitios_disponibles=4; //capacidad actual del comedero, inicial en 4
    
    public synchronized void ocupar_comedero(){ //al ser un método synchronized solo puede acceder un objeto a la SC
        while (sitios_disponibles==0){
            System.out.println("EL COMEDERO ESTA LLENO");
            try{
               wait(); //mientras el comedero esté lleno, el pollo esperará
            }
            catch(InterruptedException ie){}   
        }
        sitios_disponibles--; //cuando el comedor tenga ya sitio quitaré 1 sitio libre
    }
    
    public synchronized void soltar_comedero(){
        sitios_disponibles++; //libero un sitio en el comedor
        notify(); //notificamos a 1 pollo que hay un nuevo hueco libre
    }
}
