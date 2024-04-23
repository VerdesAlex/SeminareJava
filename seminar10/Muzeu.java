package g1065.seminar.seminar10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Muzeu {
    private int v;

    private Deque<Integer> vizitatori = new ArrayDeque<>();

    public Muzeu(int v) {
        this.v = v;
    }

    public synchronized void iesire(int m){
        while(vizitatori.isEmpty()){
            try {
                wait();
            }
            catch (InterruptedException ex){}
        }
        int nrIesiti=Math.min(m,vizitatori.size());
        System.out.println("Ies "+nrIesiti+ " vizitatori:");
        for(int i = 0;i<nrIesiti;i++){
            System.out.print(vizitatori.pollLast()+" ");
        }
        System.out.println();
        afisare();
        notifyAll();
    }

    public synchronized void intrare(List<Integer> grup){
        while( vizitatori.size() + grup.size() > v){
            try
            {
                wait();
            }
            catch(InterruptedException ex){
            }
        }
        System.out.println("Intra "+grup.size() + " vizitatori:" );
        for(int vizitator : grup)
            vizitatori.addFirst(vizitator);
        afisare();
        notifyAll();
    }

    private void afisare(){
        System.out.println("Vizitatori in muzeu: ");
        for(int v: vizitatori){
            System.out.print(v+" ");
        }
        System.out.println();
    }

}
