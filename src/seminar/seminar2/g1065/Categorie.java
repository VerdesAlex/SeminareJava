package seminar.seminar2.g1065;

public enum Categorie {
    TERENURI(211), CONSTRUCTII(212),ECHIPAMENTE_UTILAJE(2131), MIJLOACE_TRANSPORT (2133), MOBILIER (214);
    private int simbol;

    Categorie(int simbol) {
        this.simbol = simbol;
    }

    public int getSimbol() {
        return simbol;
    }
}
