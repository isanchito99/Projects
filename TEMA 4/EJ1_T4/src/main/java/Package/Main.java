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
    
    public static boolean jornada_terminada=false;
    public static int numero_comandas_random= (int) (Math.random()*20+20);//comandas random entre 20 y 40 que atendera cada camarero
    
    
    public static void main(String[] args) {
        System.out.println("Cada camarero atendera: "+numero_comandas_random+" comandas");
        
        Estanteria estanteria = new Estanteria();
        
        Camarero camarero1 = new Camarero(estanteria, 1);
        Camarero camarero2 = new Camarero(estanteria, 2);
        Cocinero cocinero1 = new Cocinero(estanteria);
        Cocinero cocinero2 = new Cocinero(estanteria);
        
        camarero1.start();
        camarero2.start();
        cocinero1.start();
        cocinero2.start();
        
        try{
            camarero1.join(); camarero2.join();
        }
        catch(Exception e){}
        jornada_terminada=true; //cuando terminen los camareros de atender las comandas la jornada terminara y avisaremos a los cocineros que han terminado
      }
    
}
