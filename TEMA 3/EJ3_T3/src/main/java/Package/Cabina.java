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
public class Cabina extends Thread {
    private String voto;
    private Recuento sistema_recuento;

    public Cabina(Recuento sistema_recuento) {
        this.sistema_recuento = sistema_recuento;
    }
    
    public void run(){
        for (int i = 0; i < 100; i++) { //cada hilo simulara un total de 100 votos (para poner un fin a la votacion)
            int n_random= (int) (Math.random()*5); //numero random entre 0 y 4 (incluido)

            switch(n_random){ //elegimos el partido votado
                case 0: 
                    voto="Partido 1";
                    break;
                case 1: 
                    voto="Partido 2";
                    break;
                case 2: 
                    voto="Partido 3";
                    break;
                 default:
                     voto="Partido 4";
            }
            sistema_recuento.contabilizar_voto(voto); //guardamos el voto en la variable compartida
            sistema_recuento.sumar_voto(); //sumamos el voto al partido correspondiente
        }
    }
}
