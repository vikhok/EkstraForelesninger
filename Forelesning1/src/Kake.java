public class Kake {

    private String størrelse;
    private String type;
    private double pris;
    private boolean glutenfri;

    Kake(String nyStørrelse, String nyType, double nyPris) {
        størrelse = nyStørrelse;
        type = nyType;
        pris = nyPris;
        glutenfri = true;
    }

    public double GiMegHvilkenPris() {
        return pris;
    }

    public double giMegFinalePrisen(int antallKaker) {
        return pris * antallKaker;
    }

    public double halvPrisPåKake() {
        return pris / 2;
    }

}