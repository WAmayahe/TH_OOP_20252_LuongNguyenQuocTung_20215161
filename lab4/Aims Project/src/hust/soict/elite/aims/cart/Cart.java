package hust.soict.elite.aims.cart;

import hust.soict.elite.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The item '" + media.getTitle() + "' has been added to the cart.");
            // BỔ SUNG: In ra số lượng item hiện tại trong giỏ theo đúng yêu cầu tài liệu
            System.out.println("Current number of items in the cart: " + itemsOrdered.size());
        } else {
            System.out.println("The item '" + media.getTitle() + "' is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The item '" + media.getTitle() + "' has been removed from the cart.");
        } else {
            System.out.println("The item '" + media.getTitle() + "' was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void filterById(int id) {
        System.out.println("--- Filter Results (ID: " + id + ") ---");
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No item found with ID: " + id);
    }

    public void filterByTitle(String title) {
        System.out.println("--- Filter Results (Title containing: '" + title + "') ---");
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No item found matching title: " + title);
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title.");
    }

    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost.");
    }

    public void clear() {
        itemsOrdered.clear();
    }
}