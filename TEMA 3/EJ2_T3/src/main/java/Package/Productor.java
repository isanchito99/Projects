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
public class Productor extends Thread{ //cada 100 ms lee la temperatura ambiente y la escribe en la var. compartida
    private Temperaturas temperaturas; //buffer compartido

    public Productor(Temperaturas temperatura) {
        this.temperaturas = temperatura;
    }
    
    private boolean resta; //variable booleana para controlar si sumamos o restamos a la temp.
    
    private double temperatura_actual=20;
    
    public void run(){
        
        while(true){
            int random = (int) (Math.random()*2);
            if (random==0) resta=true; //dependiendo del numero random incrementamos y disminuimos la temp.
            else resta=false;

            if (resta) temperatura_actual=temperatura_actual - 0.1;
            else temperatura_actual=temperatura_actual + 0.1;
            
            temperaturas.añadir(temperatura_actual); //añadimos al buffer compartido la temperatura actual

            try{
               sleep(100); //duerme 100 ms 
            }
            catch(Exception e){
                System.out.println("error");
            }
        }

        
    }
}
