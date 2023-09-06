/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JTextPane;

public class Furgoneta {

    ArrayList<String> F1 = new ArrayList<>();
    ArrayList<String> F2 = new ArrayList<>();
    private JTextPane textoF1;
    private JTextPane textoF2;
    private Registro log;
    private Lock cerrojo = new ReentrantLock();

    public Furgoneta(JTextPane textoF1, JTextPane textoF2, Registro log) {
        this.textoF1 = textoF1;
        this.textoF2 = textoF2;
        this.log = log;

    }

    public void dejarF1(String carta) {
        cerrojo.lock();
        F1.add(carta);
        elementosArraylistF1();
        String mensaje = "Se ha dejado la carta: " + carta + " en la Furgoneta1";
        log.registroLog(mensaje);
        cerrojo.unlock();

    }

    public void dejarF2(String carta) {
        cerrojo.lock();
        F2.add(carta);
        elementosArraylistF2();
        String mensaje = "Se ha dejado la carta: " + carta + " en la Furgoneta2";
        log.registroLog(mensaje);
        cerrojo.unlock();
    }

    public void elementosArraylistF1() {

        textoF1.setText(F1.toString());

    }

    public void elementosArraylistF2() {

        textoF2.setText(F2.toString());

    }

    public String elementosArraylistF1Distribuida() {

        return F1.toString();

    }

    public String elementosArraylistF2Distribuida() {

        return F2.toString();

    }
}
