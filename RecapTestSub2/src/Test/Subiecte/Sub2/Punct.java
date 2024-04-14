package Test.Subiecte.Sub2;

import java.io.Serializable;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Punct implements Comparable<Punct>, Serializable {
    private String figura;
    private String eticheta;
    private double coordOX;
    private double coordOY;

    private static int nrPct=0;

    public Punct() {
        nrPct++;
    }

    public Punct(String figura, String eticheta, double coordOX, double coordOY) {
        this.figura = figura;
        this.eticheta = eticheta;
        this.coordOX = coordOX;
        this.coordOY = coordOY;
        nrPct++;
    }

    public static int getNrPct() {
        return nrPct;
    }

    @Override
    public String toString() {
        return "Punct{" +
                "figura='" + figura + '\'' +
                ", eticheta='" + eticheta + '\'' +
                ", coordOX=" + coordOX +
                ", coordOY=" + coordOY +
                '}';
    }

    public static void setNrPct(int nrPct) {
        Punct.nrPct = nrPct;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public double getCoordOX() {
        return coordOX;
    }

    public void setCoordOX(double coordOX) {
        this.coordOX = coordOX;
    }

    public double getCoordOY() {
        return coordOY;
    }

    public void setCoordOY(double coordOY) {
        this.coordOY = coordOY;
    }

    public double distanta(){
        return sqrt(pow(coordOX,2)+pow(coordOY,2));
    }

    @Override
    public int compareTo(Punct o) {
        if(this.distanta()>o.distanta())
            return 1;
        if(this.distanta()<o.distanta())
            return -1;
        return 0;
    }
}
