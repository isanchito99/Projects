
package Principal;

public class Persona extends Thread {

    private Buzon buzon;
    private String identificador;
    private String carta1;
    private String carta2;
    private Registro log;
    private Pausar pausa;

    public Persona(Buzon buzon, String identificador, Registro log, Pausar pausa) {
        this.buzon = buzon;
        this.identificador = identificador;
        this.log = log;
        this.pausa = pausa;

    }

    public void run() {
        try {

            int tiempo_aleatorio = (int) (Math.random() * (800 - 400 + 1) + 400);
            carta1 = identificador + "-C1";
            carta2 = identificador + "-C2";
            char caracter1 = carta1.charAt(carta1.length() - 1);
            char caracter2 = carta2.charAt(carta2.length() - 1);

            if (caracter1 == '1') {
                pausa.mirar();
                buzon.dejarCarta(carta1);
                String mensajeC1 = "Se deja la carta: " + carta1 + " en el buzón";
                pausa.mirar();
                log.registroLog(mensajeC1);
                sleep(tiempo_aleatorio);
            }
            if (caracter2 == '2') {
                pausa.mirar();
                buzon.dejarCarta(carta2);
                String mensajeC2 = "Se deja la carta: " + carta2 + " en el buzón";
                pausa.mirar();
                log.registroLog(mensajeC2);
                sleep(tiempo_aleatorio);
            }

        } catch (Exception e) {
        }

    }

}
