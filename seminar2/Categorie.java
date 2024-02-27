package g1065.seminar.seminar2;

public enum Categorie {
    TERENURI(211), CONSTRUCTII(212), ECHIPAMENTE_UTILAJE(2131), MIJLOACE_TRANSPORT (2133), MOBILIER (214);
    private int simbol;

    public int getSimbol() {
        return simbol;
    }

    Categorie(int simbol){
        this.simbol=simbol;
    }
}
