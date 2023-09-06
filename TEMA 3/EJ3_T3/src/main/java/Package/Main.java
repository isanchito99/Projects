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
        Recuento recuento = new Recuento();
        
        Cabina cabina1 = new Cabina(recuento);
        Cabina cabina2 = new Cabina(recuento);
        Cabina cabina3 = new Cabina(recuento);
        Cabina cabina4 = new Cabina(recuento);
        
        cabina1.start();
        cabina2.start();
        cabina3.start();
        cabina4.start();
        
        try{
            cabina1.join(); cabina2.join(); cabina3.join(); cabina4.join(); //esperamos a que termine la votacion
        }
        catch(Exception e){}
        
        recuento.mostrar_resultado(); //mostramos el resultado
    }
    
}
