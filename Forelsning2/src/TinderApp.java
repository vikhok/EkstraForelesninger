import java.util.ArrayList;

public class TinderApp {

    //Felt
    private ArrayList<String> matches;

    //Constructor
    public TinderApp() {
        matches = new ArrayList<>();
    }

    public void addNewMatch(String nymatch) {
        matches.add(nymatch);
    }

    //Hente alle matchene
    public ArrayList<String> getMatches() {
        return matches;
    }

    //Hente antall matcher
    public int antallMatches() {
        return matches.size();
    }

    public void removeMatch(String match) {
        matches.remove(match);
    }
}
