package hust.soict.elite.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, String director, float cost, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' has been added to CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' already exists in this CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track '" + track.getTitle() + "' removed.");
        } else {
            System.out.println("Track not found.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + artist + " (Total length: " + getLength() + " mins)");
            System.out.println("----------------------------------------");
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("ERROR: Cannot play CD '" + this.getTitle() + "' because it has no tracks.");
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - Artist: " + artist + " - " + getLength() + " mins: " + getCost() + "$";
    }
}