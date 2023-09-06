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
        Temperatura temperatura = new Temperatura(20.0);
        Productor productor = new Productor(temperatura);
        Consumidor consumidor = new Consumidor(temperatura);
        
        productor.start();
        consumidor.start();
    }
    
}
