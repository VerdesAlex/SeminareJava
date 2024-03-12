package seminar.seminar2.g1065;

import java.util.Date;

public class ObiectInventar extends ElementPatrimonial{
    private String gestionar;

    public ObiectInventar() {
    }

    public ObiectInventar(long nrInventar) {
        super(nrInventar);
    }

    public ObiectInventar(String denumire, long nrInventar, double valoare, Date dataAchizitie,
                          Locatie locatie, String gestionar) {
        super(denumire, nrInventar, valoare, dataAchizitie, locatie);
        this.gestionar = gestionar;
    }

    public String getGestionar() {
        return gestionar;
    }

    public void setGestionar(String gestionar) {
        this.gestionar = gestionar;
    }

    @Override
    public String toString() {
        return "{" + super.toString()+
                " " + gestionar + "} ";
    }
}
