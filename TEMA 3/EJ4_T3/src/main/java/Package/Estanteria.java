/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.util.concurrent.locks.*;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class Estanteria {
    ArrayList<String> comandas = new ArrayList<>();
    Lock cerrojo = new ReentrantLock();
    Condition llena = cerrojo.newCondition();
    Condition vacia = cerrojo.newCondition();
    
    public void dejar_comanda(String comanda){
        try{
            cerrojo.lock();
            while (comandas.size()==20){ 
               try{
                   llena.await(); //mientras que la estanteria este llena, no se depositaran mas comandas
               }
               catch(Exception e){}
            }
            //cuando la estanteria ya no este llena:
            comandas.add(comanda); //añadimos la comanda a la estanteria
            System.out.println(comanda+" dejada"); //imprimos mensaje por pantalla
            vacia.signal(); //sacamos un camarero de la cola en caso de que la estanteria estuviese vacia
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    public void cocinar_comanda(){
        try{
            cerrojo.lock();
            while (comandas.isEmpty()){ 
                try{
                    vacia.await(); //mientras que la estanteria este vacia y no haya comandas, el cocinero se pondra a la cola
                }
                catch (Exception e){}
            }
            //cuando la estanteria ya no este vacia:
            System.out.println(comandas.get(0)+" cocinada"); //imprimimos mensaje por pantalla
            comandas.remove(0); //el cocinero quitara la primera comanda para cocinarla
            llena.signal(); //en caso que la estanteria estuviese llena, sacamos de la cola a un camarero para que traiga mas comandas
        }
        finally{
            cerrojo.unlock();
        }
    }
}
