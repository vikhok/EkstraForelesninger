public class Main {

    public static void main(String[] args) {

        //Lage objekt fra TinderApp klasse
        TinderApp tinderApp = new TinderApp();

        //Aksessere metodene gjennom objektet:

        tinderApp.addNewMatch("Sara");
        tinderApp.addNewMatch("Lara");
        tinderApp.addNewMatch("Yara");
        tinderApp.addNewMatch("Klara");

        System.out.println("Antall matches:");
        System.out.println(tinderApp.antallMatches());
        System.out.println("Matchene:");
        System.out.println(tinderApp.getMatches());

        //Remove one match
        tinderApp.removeMatch("Klara");
        System.out.println("Matchene etter at en ble fjernet:");
        System.out.println(tinderApp.getMatches());


        //Lage objekt fra GoogleTranslate klasse
        GoogleTranslate translator = new GoogleTranslate();

        //Aksessere metodene gjennom objektet:

        translator.addToGoogleTranslate();

        System.out.println("Hva er Bil på engelsk?");
        System.out.println(translator.oversettOrd("Bil"));
        System.out.println("Hva er Hund på engelsk?");
        System.out.println(translator.oversettOrd("Hund"));


        //Lage objekt fra Loops klasse
        Loops l = new Loops();

        //Aksessere metodene gjennom objektet:

        l.tellTil10();
        l.tilTil10MedWhileLoop();


        //Lage objekt fra Spotify klasse
        Spotify sp = new Spotify();

        // Adde sanger til lista
        sp.addSongs();

        //Liste alle sanger i lista på 2 forskjellige måter
        sp.listAllSongs1();
        sp.listAllSongs2();
    }
}