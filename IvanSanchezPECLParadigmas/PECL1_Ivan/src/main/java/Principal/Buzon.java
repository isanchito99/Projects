/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JTextPane;

public class Buzon {

    ArrayList<String> cartas = new ArrayList<>();
    private int capacidad;
    private JTextPane nCartas;
    private JTextPane bufferbuzon;

    public Buzon(int capacidad, JTextPane nCartas, JTextPane bufferbuzon) {
        this.capacidad = capacidad;
        this.nCartas = nCartas;
        this.bufferbuzon = bufferbuzon;
    }

    public synchronized void dejarCarta(String carta) throws InterruptedException {

        try {
            while (cartas.size() == capacidad) { //si el buffer esta lleno
                wait();
            }
            cartas.add(carta);
            cantidadCartas();
            elementosArraylist();

        } finally {
            notifyAll();

        }
    }

    public synchronized String cogerCarta(String carta) throws InterruptedException {
        try {

            while (cartas.isEmpty()) { //si el buffer esta lleno
                wait();
            }
            String cartaCogida = cartas.get(0);
            cartas.remove(0);
            cantidadCartas();
            elementosArraylist();
            return cartaCogida;
        } finally {
            notifyAll();

        }

    }

    public void cantidadCartas() {

        int cantidadCartas = cartas.size();
        String cantidad = Integer.toString(cantidadCartas);
        nCartas.setText(cantidad);

    }

    public void elementosArraylist() {

        String devolver = (cartas.toString() + "\t");
        bufferbuzon.setText(devolver);

    }

    public String cantidadCartasDistribuida() {

        int cantidadCartas = cartas.size();
        String cantidad = Integer.toString(cantidadCartas);
        nCartas.setText(cantidad);

        return cantidad;
    }

    public String elementosArraylistDistribuida() {

        String devolver = (cartas.toString() + "\t");

        return devolver;

    }
}
