/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package gisi.pruebacopilot;

/**
 *
 * @author isr10
 */
public class PruebaCopilot {

    public static void main(String[] args) {
        Garden jardin=new Garden(10,4,8,10);
        int fullKids = 52;
        String gender;
        for (int i = 0; i < fullKids; i++) {
            int randomGender = (int) (Math.floor(Math.random() + 1.5));
            if (randomGender == 1) {
                gender = "MALE";
            } else {
                gender = "FEMALE";
            }
            String idkid = "Niño" + i;
            Kids niños = new Kids(idkid, "nombre" + i, "apellido" + i, 8, gender,jardin);
            niños.start();
        }

    }
}
