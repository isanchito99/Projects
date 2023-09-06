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
public class Main {

    
    public static void main(String[] args) {
        Temperaturas temperaturas = new Temperaturas();
        Productor productor = new Productor(temperaturas);
        Consumidor consumidor = new Consumidor(temperaturas);
        
        productor.start();
        consumidor.start();
    }
    
}
