package g1065.seminar.seminar10;

public class Iesire extends Thread{
    private int m;
    private Muzeu muzeu;

    public Iesire(int m, Muzeu muzeu) {
        this.m = m;
        this.muzeu = muzeu;
    }

    @Override
    public void run() {
        while(!Main.stopScenariu){
            int nrVizitatori=(int)(Math.random()*m);
            muzeu.iesire(nrVizitatori);
        }
    }
}
