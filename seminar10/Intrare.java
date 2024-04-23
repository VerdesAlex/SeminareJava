package g1065.seminar.seminar10;

import java.util.ArrayList;
import java.util.List;

public class Intrare extends Thread{
    private int n;
    private Muzeu muzeu;

    private int idVizitator=1;

    public Intrare(int n, Muzeu muzeu) {
        this.n = n;
        this.muzeu = muzeu;
    }

    @Override
    public void run() {
        while (!Main.stopScenariu){
            int nrVizitatori = (int)(Math.random()*n);
            List<Integer> grup = new ArrayList<>();
            for (int i = 0; i < nrVizitatori; i++) {
                grup.add(idVizitator++);
            }
            muzeu.intrare(grup);
        }
    }
}
