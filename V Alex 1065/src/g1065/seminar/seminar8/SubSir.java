package g1065.seminar.seminar8;

import java.util.Arrays;

public class SubSir<T> extends Sir<T>, Comparable<T> implements  Runnable{
    private int p, u;

    public SubSir() {
    }

    public SubSir(T[] x, int p, int u) {
        super(x);
        this.p = p;
        this.u = u;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public void sort(){
        Arrays.sort(x,p,u);
    }

    @Override
    public void run() {
        sort();
    }

//    @Override
//    public T[] aloc(int n) {
//        return null;
//    }
}
