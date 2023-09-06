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
public class Productor extends Thread { //el productor estará cada 100 ms leyendo la temperatura ambiente y escribiéndola en la var. compartida
    private Temperatura temperatura;

    public Productor(Temperatura temperatura) {
        this.temperatura = temperatura;
    }
    
    private boolean resta; //variable booleana para controlar si sumamos o restamos a la temp.
    
    public void run(){
        while(true){
            int random = (int) (Math.random()*2);
            if (random==0) resta=true; //dependiendo del numero random incrementamos y disminuimos la temp.
            else resta=false;

            if (resta) temperatura.resta();
            else temperatura.suma();

            try{
               sleep(100); //duerme 100 ms 
            }
            catch(Exception e){
                System.out.println("error");
            }
        }

        
    }
}
