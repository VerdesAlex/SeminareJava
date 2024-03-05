package seminar.seminar2.g1065;

public class Locatie {

    private String denumire, adresa;

    public String getDenumire() {
        return denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Locatie(String denumire, String adresa){
        this.denumire=denumire;
        this.adresa=adresa;
    }

    @Override
    public String toString() {
        return "Locatie{" +
                "denumire='" + denumire + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
