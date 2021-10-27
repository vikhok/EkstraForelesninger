import java.util.ArrayList;

public class Spotify {

    ArrayList<String> songs;

    public Spotify() {
        songs = new ArrayList<>();
    }

    public void addSongs() {
        songs.add("Blinding lights");
        songs.add("Starboy");
        songs.add("The hills");
        songs.add("Save your tears");
        songs.add("Eye of the tiger");
    }

    public void listAllSongs1() {
        int index = 0;
        while (index < songs.size()) {
            System.out.println(songs.get(index));
            index++;
        }
    }

    public void listAllSongs2() {
        for (String sang : songs) {
            System.out.println(sang);
        }
    }

}
