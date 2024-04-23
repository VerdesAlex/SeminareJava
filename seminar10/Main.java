package g1065.seminar.seminar10;

public class Main {
    public static volatile boolean stopScenariu;

    public static void main(String[] args){
        try{
            Muzeu muzeu= new Muzeu(30);
            Intrare intrare = new Intrare(5, muzeu);
            Iesire iesire = new Iesire(3,muzeu);
            iesire.start();
            intrare.start();
            Thread.sleep(50);
            stopScenariu=true;
        }
        catch (InterruptedException ex){
            System.err.println(ex);
        }
    }
}
