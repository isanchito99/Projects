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
public class Camarero extends Thread {
    private Estanteria estanteria;
    private int numero_camarero;
    private int contador_comanda;
    private String comanda;
    public Camarero(Estanteria estanteria, int numero_camarero) {
        this.estanteria = estanteria;
        this.numero_camarero=numero_camarero;
    }
    
    
    public void run(){
        if (this.numero_camarero==1) contador_comanda=1;
        else contador_comanda=Main.numero_comandas_random+1;
        
        for (int i = 0; i < Main.numero_comandas_random; i++) { 
            comanda = "Comanda "+contador_comanda;
            contador_comanda++;
            estanteria.dejar_comanda(comanda); //el camarero deja la comanda en la estanteria
            
            try{
                sleep(500); //cada camarero deja una comanda cada 500 ms
            }
            catch(Exception e){}
        }
    }
}
