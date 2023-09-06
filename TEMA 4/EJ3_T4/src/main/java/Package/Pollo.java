
package Package;


public class Pollo extends Thread {
    private int n_pollo;
    private Comedero comedero;
    private Bebedero bebedero;
    private Cama cama;
    private String[] acciones = new String[4];

    public Pollo(int n_pollo, Comedero comedero, Bebedero bebedero, Cama cama) {
        this.n_pollo = n_pollo;
        this.comedero = comedero;
        this.bebedero = bebedero;
        this.cama = cama;
        acciones[0]="pasear";
        acciones[1]="comer";
        acciones[2]="beber";
        acciones[3]="dormir";
    }

    
    public String accion_aleatoria(String[] acciones){ //metodo para seleccionar aletoriamente la accion a realizar por el pollo
        int numero_aleatorio= (int) (Math.random()*4); //numero random entre 0 y 3
        if (numero_aleatorio==0) return acciones[0];
        else if (numero_aleatorio==1) return acciones[1];
        else if (numero_aleatorio==2) return acciones[2];
        else return acciones[3];
    }
    
    public void run (){
        try{ //comienza el ciclo paseando
            sleep((int) (5000+Math.random()*5000)); //numero aleatorio entre 5000 y 9000 ms
        }
        catch(InterruptedException ie){}
        System.out.println("El pollo "+n_pollo+ " "+"ha paseado");
        
        while (true){
            String accion_aleatoria= accion_aleatoria(acciones);
            switch(accion_aleatoria){
                case "pasear":
                    try{
                        sleep((int) (5000+Math.random()*5000)); //numero aleatorio entre 5000 y 9000 ms
                    }
                    catch(InterruptedException ie){}
                    System.out.println("El pollo "+n_pollo+ " "+"ha paseado");
                    break;
                case "comer":
                    comedero.ocupar_comedero(); //antes de comer vemos si hay hueco en el comedero, si no lo hay el pollo esperara a que lo haya
                    try{
                        sleep((int) (2000+Math.random()*5000)); //numero aleatorio entre 2000 y 6000 ms
                    }
                    catch(InterruptedException ie){}
                    comedero.soltar_comedero(); //cuando haya comido, dejara el comedero
                    System.out.println("El pollo "+n_pollo+ " "+"ha comido"); //mostramos mensaje por pantalla
                    break;
                case "beber":
                    bebedero.ocupar_bebedero();
                    try{
                        sleep((int) (1000+Math.random()*3000)); //numero aleatorio entre 1000 y 3000 ms
                    }
                    catch(InterruptedException ie){}
                    bebedero.soltar_bebedero();
                    System.out.println("El pollo "+n_pollo+ " "+"ha bebido");
                    break;
                case "dormir":
                    cama.ocupar_cama();
                    try{
                        sleep((int) (15000+Math.random()*5000)); //numero aleatorio entre 15000 y 19000 ms
                    }
                    catch(InterruptedException ie){}
                    cama.soltar_cama();
                    System.out.println("El pollo "+n_pollo+ " "+"ha dormido");
                    break;
                default:
                    System.out.println("Error");
            }
        }
        
        
    }
}
