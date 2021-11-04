// i denne metoden kan vi f.eks. lage objekt fra Kake klasse og kjøre de ulike metodene som ligger der
public class Main {
    public static void main(String[] args) {

        //Lager objekt, en Stor Marsipan kake for 299.9 kr, dette objektet brukes for å kalle på metodene vi lagde.
        Kake marsipanKake1 = new Kake("Stor","Marsipan",299.9);

        //oppgave 1
        System.out.println("Pris på kaken:");
        System.out.println(marsipanKake1.GiMegHvilkenPris());

        //oppgave 2, 50% rabatt
        System.out.println("Halvprisen er:");
        System.out.println(marsipanKake1.GiMegHvilkenPris());

        //oppgave 3, pris på 5 marsipankaker
        System.out.println("Final pris på antall kaker du vil kjøpe:");
        System.out.println(marsipanKake1.giMegFinalePrisen(5));

        //oppgave 4, Hvilken kake vil du ha, er det Gullrot eller?
        System.out.println("Svar basert på om du vil ha GullrotKake eller ikke:");
        System.out.println(marsipanKake1.vilDuHaKake("Gullrotkake"));
    }
}