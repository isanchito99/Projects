/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pausar {

    private boolean cerrado = false;
    private Lock cerrojo = new ReentrantLock();
    private Condition parar = cerrojo.newCondition();

    public void mirar() {
        cerrojo.lock();
        try {
            while (cerrado) {
                try {
                    parar.await();
                } catch (InterruptedException ie) {
                }
            }
        } finally {
            cerrojo.unlock();
        }
    }

    /**
     * Método para abrir el cerrojo y avisar a los objetos que estén parados
     */
    public void abrir() {
        cerrojo.lock();
        try {
            cerrado = false;
            parar.signalAll();
        } finally {
            cerrojo.unlock();
        }
    }

    /**
     * Método para cerrar el cerrojo
     */
    public void cerrar() {
        cerrojo.lock();
        try {
            cerrado = true;
        } finally {
            cerrojo.unlock();
        }
    }

}
