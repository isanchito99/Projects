/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jorge
 */
public class Temperaturas {
    ArrayList<Double> temperaturas = new ArrayList<>(); //buffer compartido
    private Lock cerrojo = new ReentrantLock();
    Condition lleno = cerrojo.newCondition();

    
    public void añadir(double temperatura){
        try{
            cerrojo.lock();
            while (temperaturas.size()==10){
                try{
                    lleno.await(); // mientras el buffer este lleno, el productor esperará
                }
                catch (Exception e){}
            }
            temperaturas.add(temperatura); //cuando no este lleno, añadira la temperatura leida
        }
        finally{
            cerrojo.unlock();
        }
    }

    public void eliminar_escrito(){ //eliminamos del buffer la temperatura ya escrita en pantalla, es decir, la primera:
        cerrojo.lock();
        try{
            temperaturas.remove(temperaturas.get(0));
            lleno.signal(); //cuando eliminemos la temperatura leida el buffer ya no estara lleno y podremos seguir añadiendo mas
            // en este caso no es necesario añadir otra condition de vacio porque el buffer nunca estara vacio ya que el productor
            //duerme 100 ms y el consumidor duerme 1 seg
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    public void getTemperatura(){
        cerrojo.lock();
        try{
            double temperatura = temperaturas.get(0); //cogemos la primera temperatura del buffer compartido
            String cad = String.valueOf(temperatura);
            cad=cad.substring(0,4); //quitamos decimales no relevantes
            System.out.println(cad); //la mostramos en pantalla
        }
        finally{
            cerrojo.unlock();
        }
    }
}
