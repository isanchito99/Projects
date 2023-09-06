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
public class Consumidor extends Thread{ //el consumidor cada segundo leerá la temperatura de la variable compartida y la mostrara por pantalla
    private Temperatura temperatura;

    public Consumidor(Temperatura temperatura) {
        this.temperatura = temperatura;
    }
    
    public void run(){
        
        while (true){
            try{
               sleep(1000); //cada segundo escribe la variable compartida por pantalla 
            }
            catch(Exception e){
                System.out.println("error");
            }
            temperatura.getTemperatura();
        }

        
    }
}
