package test1065.acasa.acasa1;

import java.util.Objects;

public class Element implements Comparable<Element>{
    private int linie;
    private int coloana;
    private double element;

    public Element() {

    }

    public Element(int linie, int coloana, double element) {
        this.linie = linie;
        this.coloana = coloana;
        this.element = element;
    }

    public int getLinie() {
        return linie;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    public int getColoana() {
        return coloana;
    }

    public void setColoana(int coloana) {
        this.coloana = coloana;
    }

    public double getElement() {
        return element;
    }

    public void setElement(double element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element1 = (Element) o;
        return linie == element1.linie && coloana == element1.coloana && Double.compare(element, element1.element) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linie, coloana, element);
    }

    @Override
    public String toString() {
        return "Element{" +
                "linie=" + linie +
                ", coloana=" + coloana +
                ", element=" + element +
                '}';
    }

    @Override
    public int compareTo(Element o) {
        if(element < o.element)
            return -1;
        if(element > o.element)
            return 1;
        return 0;
    }
}
