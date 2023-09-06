/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import static java.lang.Thread.sleep;
import javax.swing.JTextPane;

public class Empleado extends Thread {

    private Buzon buzon;
    private Furgoneta furgoneta;
    private String identificador;
    private String carta;
    private JTextPane texto;
    private Registro log;
    private Pausar pausa;

    public Empleado(Buzon buzon, Furgoneta furgoneta, String identificador, JTextPane texto, Registro log, Pausar pausa) {
        this.buzon = buzon;
        this.furgoneta = furgoneta;
        this.identificador = identificador;
        this.texto = texto;
        this.log = log;
        this.pausa = pausa;

    }

    public void run() {
        while (true) {
            try {

                int tiempo_aleatorio = (int) (Math.random() * (700 - 400 + 1) + 400);
                pausa.mirar();
                String cartaEmpleado = buzon.cogerCarta(carta);
                String mensajeCogerCarta = "Carta: " + cartaEmpleado + " cogida del buzón por el " + identificador;
                pausa.mirar();
                irBuzon(texto, mensajeCogerCarta);
                sleep(200); //LO HACEMOS PARA QUE SE VEA EL TEXTO DEL MENSAJE, EN CASO DE NO HACERLO EL MENSAJE NO SE LLEGA A APRECIAR EN LA INTERFAZ
                log.registroLog(mensajeCogerCarta);

                char caracter = cartaEmpleado.charAt(cartaEmpleado.length() - 1);

                if (caracter == '1') {

                    pausa.mirar();
                    furgoneta.dejarF1(cartaEmpleado);
                    String mensajeE1 = "Carta: " + cartaEmpleado + " enviada a la Furgoneta 1";

                    pausa.mirar();
                    log.registroLog(mensajeE1);
                    textoEmpleado(texto, mensajeE1);
                    sleep(tiempo_aleatorio);
                    pausa.mirar();
                    volverBuzon(texto);
                    sleep(300); //LO HACEMOS PARA QUE SE VEA EL TEXTO DEL MENSAJE, EN CASO DE NO HACERLO EL MENSAJE NO SE LLEGA A APRECIAR EN LA INTERFAZ
                }
                if (caracter == '2') {

                    pausa.mirar();
                    furgoneta.dejarF2(cartaEmpleado);
                    String mensajeE2 = "Carta: " + cartaEmpleado + " enviada a la Furgoneta 2";
                    pausa.mirar();
                    log.registroLog(mensajeE2);
                    textoEmpleado(texto, mensajeE2);
                    sleep(tiempo_aleatorio);
                    pausa.mirar();
                    volverBuzon(texto);
                    sleep(300); //LO HACEMOS PARA QUE SE VEA EL TEXTO DEL MENSAJE, EN CASO DE NO HACERLO EL MENSAJE NO SE LLEGA A APRECIAR EN LA INTERFAZ
                }

            } catch (Exception e) {
            }

        }
    }

    public void textoEmpleado(JTextPane texto, String mensaje) {

        texto.setText(mensaje);

    }

    public void irBuzon(JTextPane texto, String mensaje) {
        texto.setText(mensaje);

    }

    public void volverBuzon(JTextPane texto) {
        texto.setText("Volviendo al Buzon");
        

    }
}
