//Denne klassen passer for en kakebutikk der vi har valgt noen felt, og laget en del metoder.
public class Kake {

    //Ønskede felt
   private String størrelse;
   private String type;
   private double pris;
   private boolean glutenfri;

   //Lag en constructor men ta hensyn til at akkurat nå alle kaker vi selger er glutenfrie!
   //Ellers så vi har mange ulike typer og størrelser og dermed priser.
    Kake(String nyStørrelse, String nyType, double nyPris) {
        størrelse = nyStørrelse;
        type = nyType;
        pris = nyPris;
        glutenfri = true;
    }

    //Lag en metode som returnere hvilken pris kaken har?
    public double GiMegHvilkenPris() {
        return pris;
    }

    //Lag en metode som regner ut prisen på antall kaker kunden kjøper?
    public double giMegFinalePrisen(int antallKaker) {
        return  pris * antallKaker;
    }

    //Lag en metode som gir 50% rabatt på den ene kaken fordi den skal gå ut på dato snart (Hint: pris / 2) ?
    public double halvPrisPåKake() {
        return  pris / 2;
    }

    //Lag en metode som sjekker om typen er gullrotkake, hvis ja print «Jeg vil kjøpe», hvis ikke «vil ikke, takk!»
    public String vilDuHaKake(String kakeType) {
        if(kakeType.equals("Gullrotkake")) {
            return "JA, jeg vil gjerne ha!";
        }
        else {
            return "Ellers, takk!";
        }
    }
}
