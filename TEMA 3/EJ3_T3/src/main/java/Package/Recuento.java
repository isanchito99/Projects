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
public class Recuento {
    private int votos_partido1=0;
    private int votos_partido2=0;
    private int votos_partido3=0;
    private int votos_partido4=0;
    private String voto;
    private boolean contando_voto=false;
    
    private Lock cerrojo = new ReentrantLock();
    Condition esperar= cerrojo.newCondition();
    
    
    public void sumar_voto(){ //sumamos el voto contabilizado al partido votado
        try{
            cerrojo.lock();
            switch(this.voto){
                case "Partido 1": 
                    votos_partido1++;
                    break;
                case "Partido 2": 
                    votos_partido2++;
                    break;
                case "Partido 3": 
                    votos_partido3++;
                    break;
                default:
                    votos_partido4++;
            }
            contando_voto=false;
            esperar.signal(); //cuando se termina de sumar el voto se despierta un hilo y se pone contando_voto a false
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    public void contabilizar_voto(String votacion){ //contabilizamos el voto guardandolo en la variable comapartida
        try{
            cerrojo.lock();
            while(contando_voto){ //mientras se este contando otro voto no se debe depositar otro
               try{
                   esperar.await();
               } 
               catch(Exception e){}
            }
            //cuando el voto anterior ya esté sumado:
            this.voto=votacion; //guardamos el voto
            contando_voto=true; //ponemos contando_voto a true para que otro hilo no pueda cambiar el valor de la variable mientras se suma el voto
        }
        finally{
            cerrojo.unlock();
        }
    }
    
    public void mostrar_resultado(){ //mostramos el resultado de las elecciones tras depositar 400 votos (hemos creado en el main 4 cabinas)
        System.out.println("El resultado de la votacion ha sido:");
        System.out.println("");
        System.out.println("Partido 1: "+votos_partido1);
        System.out.println("Partido 2: "+votos_partido2);
        System.out.println("Partido 3: "+votos_partido3);
        System.out.println("Partido 4: "+votos_partido4);
    }
}
