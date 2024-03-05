package seminar.seminar2.g1065;

import java.util.Date;

public class MijlocFix extends ElementPatrimonial {
    private Categorie categorie;
    private int durataNormata;

    public MijlocFix() {
    }

    public MijlocFix(long nrInventar) {
        super(nrInventar);
    }

    public MijlocFix(Categorie categorie, int durataNormata) {
        this.categorie = categorie;
        this.durataNormata = durataNormata;
    }

    public MijlocFix(String denumire, long nrInventar, double valoare, Date dataAchizitie, Locatie locatie, Categorie categorie, int durataNormata) throws Exception{
        super(denumire, nrInventar, valoare, dataAchizitie, locatie);
        if(durataNormata <0||durataNormata >100)
            throw new Exception("Durata normata invalida!");
        this.categorie = categorie;
        this.durataNormata = durataNormata;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int durataNormata() {
        return durataNormata;
    }

    public void setdurataNormata(int durataNormata) throws Exception {
        if(durataNormata < 0 || durataNormata >100){
            throw  new Exception("Durata normata invalida");
        }
        this.durataNormata = durataNormata;
    }

    

    @Override
    public String toString() {
        return "MijlocFix{" + super.toString()+
                "categorie=" + categorie +
                ", durataNormata=" + durataNormata +
                "} ";
    }
}
