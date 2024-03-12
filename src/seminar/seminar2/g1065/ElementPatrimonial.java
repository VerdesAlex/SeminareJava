package seminar.seminar2.g1065;

import java.util.Date;

public abstract class ElementPatrimonial implements Comparable<ElementPatrimonial> {
    protected String denumire;
    protected long nrInventar;
    protected double valoare;
    protected Date dataAchizitie;
    protected Locatie locatie;

    public ElementPatrimonial() {
    }

    public ElementPatrimonial(long nrInventar) {
        this.nrInventar = nrInventar;
    }

    public ElementPatrimonial(String denumire, long nrInventar, double valoare,
                              Date dataAchizitie, Locatie locatie) {
        this.denumire = denumire;
        this.nrInventar = nrInventar;
        this.valoare = valoare;
        this.dataAchizitie = dataAchizitie;
        this.locatie = locatie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public long getNrInventar() {
        return nrInventar;
    }

    public void setNrInventar(long nrInventar) {
        this.nrInventar = nrInventar;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public Date getDataAchizitie() {
        return dataAchizitie;
    }

    public void setDataAchizitie(Date dataAchizitie) {
        this.dataAchizitie = dataAchizitie;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementPatrimonial that = (ElementPatrimonial) o;

        return nrInventar == that.nrInventar;
    }

    @Override
    public int hashCode() {
        return (int) (nrInventar ^ (nrInventar >>> 32));
    }

    @Override
    public int compareTo(ElementPatrimonial elementPatrimonial) {
        if(dataAchizitie==null || elementPatrimonial.dataAchizitie==null){
            return 0;
        }
        return dataAchizitie.before(elementPatrimonial.dataAchizitie)?-1:1;
    }

    @Override
    public String toString() {
        return "{" +
                denumire +
                "," + nrInventar +
                "," + valoare +
                "," + (dataAchizitie!=null?Main.fmt.format(dataAchizitie):"") +
                "," + locatie +
                '}';
    }
}
