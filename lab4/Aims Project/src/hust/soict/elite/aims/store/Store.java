package hust.soict.elite.aims.store;

import hust.soict.elite.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The item '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The item '" + media.getTitle() + "' already exists in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The item '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The item was not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("============ STORE ============");
        if (itemsInStore.isEmpty()) {
            System.out.println("[Store is empty]");
        } else {
            for (Media m : itemsInStore) {
                System.out.println(m.toString());
            }
        }
        System.out.println("===============================");
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
}