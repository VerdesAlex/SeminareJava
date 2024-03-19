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

    @Override
    public double uzura() {
        Date dataCurenta = new Date();
        long diferentaMilisec = dataCurenta.getTime()-dataAchizitie.getTime();
        int diferentaZile= (int)(diferentaMilisec/86400000);
        return  diferentaZile>365?1:diferentaZile/365.0;
    }
}
