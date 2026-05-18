package hust.soict.elite.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength() + " mins");
        } else {
            System.out.println("ERROR: Cannot play DVD '" + this.getTitle() + "' because length is 0 or negative.");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " mins: " + getCost() + "$";
    }
}