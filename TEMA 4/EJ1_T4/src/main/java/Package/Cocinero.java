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
public class Cocinero extends Thread {
    private Estanteria estanteria;

    public Cocinero(Estanteria estanteria) {
        this.estanteria = estanteria;
    }
    
    public void run(){
        while (!Main.jornada_terminada) {  //hasta que no haya mas comandas los hilos cocineros seguiran cocinando
            estanteria.cocinar_comanda();
            try{
                sleep(400);
            }
            catch(Exception e){}
        }
    }
}
