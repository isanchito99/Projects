
// Path: src\main\java\gisi\pruebacopilot\Kids.java
// Compare this snippet from src\main\java\gisi\pruebacopilot\PruebaCopilot.java:
// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
//  */
// 
// package gisi.pruebacopilot;
// 
// /**
//  *
//  * @author isr10
//  */
// public class PruebaCopilot {
// 
//     public static void main(String[] args) {
//        
//         int limiteNiños=52;
//         for (int i = 0; i < limiteNiños; i++) {
//             String idkid="Niño"+i;
//             Kids niños = new Kids(idkid);
//             kids.start();
//         }
//         
//     }
// }
// 
package gisi.pruebacopilot;

public class Kids extends Thread {

    private String idkid;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private Garden jardin;

    public Kids(String idkid, String nombre, String apellido, int edad, String sexo, Garden jardin) {
        this.idkid = idkid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.jardin = jardin;

    }

    public String getIdkid() {
        return idkid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setIdkid(String idkid) {
        this.idkid = idkid;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void run() {
        jardin.entrarNiño(idkid);
        while (true) {
            try {
                int selector = 0;
                System.out.println("Hola soy " + nombre + " " + apellido + "  tengo " + edad + " años" + " y soy " + sexo);
                int randomJugar = (int) (Math.random() * 7000 - 4000 + 1) + 4000;
                int randomComer = (int) (Math.random() * 9000 - 5000 + 1) + 5000;
                int randomBeber = (int) (Math.random() * 4000 - 1000 + 1) + 1000;
                int randoomDormir = (int) (Math.random() * 19000 - 15000 + 1) + 15000;
                selector = 0 + (int) ((4 - 0) * Math.random());
                if (selector == 0) {
                    jardin.Play(idkid);
                    Thread.sleep(randomJugar);
                    jardin.noPlay(idkid);
                }
                if (selector == 1) {
                    jardin.Eat(idkid);
                    Thread.sleep(randomComer);
                    jardin.noEat(idkid);
                }
                if (selector == 2) {
                    jardin.Drink(idkid);
                    Thread.sleep(randomBeber);
                    jardin.noDrink(idkid);
                }
                if (selector == 3) {
                    jardin.Sleep(idkid);
                    Thread.sleep(randoomDormir);
                    jardin.noSleep(idkid);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}