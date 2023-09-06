/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class Estanteria {
    ArrayList<String> comandas = new ArrayList<>();
    
    public synchronized void dejar_comanda(String comanda){ //metodo synchronized, solo 1 objeto puede acceder a la SC
        while (comandas.size()==20){ 
            try{
                wait(); //mientras que la estanteria este llena, no se depositaran mas comandas
            }
            catch(InterruptedException ie){}
        }
        //cuando la estanteria ya no este llena:
        comandas.add(comanda); //añadimos la comanda a la estanteria
        System.out.println(comanda+" dejada"); //imprimos mensaje por pantalla
        notifyAll(); //NOTIFICAMOS QUE LA ESTANTERIA NO ESTA VACIA Y HAY UNA COMANDA PARA COCINAR
    }
    
    public synchronized void cocinar_comanda(){
        while (comandas.isEmpty()){ 
            try{
                wait(); //mientras que la estanteria este vacia y no haya comandas, el cocinero esperara
            }
            catch (Exception e){}
        }
        //cuando la estanteria ya no este vacia:
        System.out.println(comandas.get(0)+" cocinada"); //imprimimos mensaje por pantalla
        comandas.remove(0); //el cocinero quitara la primera comanda para cocinarla
        notifyAll(); //NOTIFICAMOS QUE LA ESTANTERIA NO ESTA LLENA Y SE PUEDEN DEPOSITAR COMANDAS
        
    }
}
