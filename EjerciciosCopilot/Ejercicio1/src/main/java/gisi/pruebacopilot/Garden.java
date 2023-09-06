package gisi.pruebacopilot;

public class Garden {

    private int maxKids;
    private int maxKidsInPlay;
    private int maxKidsInEat;
    private int maxKidsInSleep;
    private int maxKidsInDrink;

    private int kidsInPlay=0;
    private int kidsInEat=0;
    private int kidsInSleep=0;
    private int kidsInDrink=0;

    public Garden(int maxKidsInPlay, int maxKidsInEat, int maxKidsInSleep, int maxKidsInDrink) {
        this.maxKidsInPlay = maxKidsInPlay;
        this.maxKidsInEat = maxKidsInEat;
        this.maxKidsInSleep = maxKidsInSleep;
        this.maxKidsInDrink = maxKidsInDrink;
    }

    public int getMaxKids() {
        return maxKids;
    }

    public int getMaxKidsInPlay() {
        return maxKidsInPlay;
    }

    public int getMaxKidsInEat() {
        return maxKidsInEat;
    }

    public int getMaxKidsInSleep() {
        return maxKidsInSleep;
    }

    public int getMaxKidsInDrink() {
        return maxKidsInDrink;
    }

    public void setMaxKids(int maxKids) {
        this.maxKids = maxKids;
    }

    public void setMaxKidsInPlay(int maxKidsInPlay) {
        this.maxKidsInPlay = maxKidsInPlay;
    }

    public void setMaxKidsInEat(int maxKidsInEat) {
        this.maxKidsInEat = maxKidsInEat;
    }

    public void setMaxKidsInSleep(int maxKidsInSleep) {
        this.maxKidsInSleep = maxKidsInSleep;
    }

    public void setMaxKidsInDrink(int maxKidsInDrink) {
        this.maxKidsInDrink = maxKidsInDrink;
    }

    public void entrarNiño(String idkid) {
        System.out.println("El niño " + idkid + " ha entrado en el parque");
    }

    public synchronized void Play(String idkid) throws InterruptedException {
        while (kidsInPlay >= maxKidsInPlay) {
            wait();
        }
        System.out.println("El niño " + idkid + " está jugando");
        kidsInPlay++;
    }

    public synchronized void noPlay(String idkid) throws InterruptedException{
        System.out.println("El niño " + idkid + " deja de  jugar");
        kidsInPlay--;
        notifyAll();
    }

    public synchronized void Eat(String idkid)throws InterruptedException {
        while (kidsInEat >= maxKidsInEat) {
            wait();
        }
        System.out.println("El niño " + idkid + " está comiendo");
        kidsInEat++;

    }

    public synchronized void noEat(String idkid) throws InterruptedException {
        System.out.println("El niño " + idkid + " deja de comer");
        kidsInEat--;
        notifyAll();
    }

    public synchronized void Sleep(String idkid) throws InterruptedException {
        while (kidsInSleep >= maxKidsInSleep) {
            wait();
        }
        System.out.println("El niño " + idkid + " está durmiendo");
        kidsInSleep++;
    }

    public  synchronized void noSleep(String idkid)throws InterruptedException {

        System.out.println("El niño " + idkid + " deja de dormir");
        kidsInSleep--;
        notifyAll();
    }

    public synchronized void Drink(String idkid)throws InterruptedException {
        while (kidsInDrink >= maxKidsInDrink) {
            wait();
        }
        System.out.println("El niño " + idkid + " está bebiendo");
        kidsInDrink++;

    }

    public synchronized void noDrink(String idkid)throws InterruptedException {
        System.out.println("El niño " + idkid + " deja de beber");
        kidsInDrink--;
        notifyAll();
    }
}
