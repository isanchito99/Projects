/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

/**
 *
 * @author jorge
 */
public class Consumidor extends Thread { //cada segundo lee la var. compartida y escribe el valor por pantalla
    private Temperaturas temperaturas; //buffer compartido

    public Consumidor(Temperaturas temperatura) {
        this.temperaturas = temperatura;
    }
    
    public void run(){
        
        while (true){
            try{
               sleep(1000); //cada segundo escribe la variable compartida por pantalla 
            }
            catch(Exception e){
                System.out.println("error");
            }
            temperaturas.getTemperatura();
            temperaturas.eliminar_escrito();
        }

        
    }
}
