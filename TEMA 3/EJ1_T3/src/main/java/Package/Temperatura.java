/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.util.concurrent.locks.*;

/**
 *
 * @author jorge
 */
public class Temperatura { //variable compartida
    private double temperatura;
    private Lock cerrojo = new ReentrantLock();

    public Temperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    public void resta(){
        cerrojo.lock();
        try{
            temperatura=temperatura - 0.05;
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    public void suma(){
        cerrojo.lock();
        try{
            temperatura=temperatura + 0.05;
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    public void getTemperatura(){
        cerrojo.lock();
        try{
            String cad = String.valueOf(temperatura);
            cad=cad.substring(0,4); //quitamos decimales no relevantes
            System.out.println(cad);
        }
        finally{
            cerrojo.unlock();
        }
    }
}
