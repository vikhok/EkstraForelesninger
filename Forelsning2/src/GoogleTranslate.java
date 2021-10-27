import java.util.HashMap;

public class GoogleTranslate {

    HashMap<String, String> engelskeOrd;

    public GoogleTranslate() {
        engelskeOrd = new HashMap<>();
    }

    public void addToGoogleTranslate() {
        engelskeOrd.put("Skole", "School");
        engelskeOrd.put("Bil", "Car");
        engelskeOrd.put("Hund", "Dog");
    }

    public String oversettOrd(String ord) {
        return engelskeOrd.get(ord);
    }
}
