package hust.soict.elite.aims.store;
import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < 100) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Added to store: " + dvd.getTitle());
        }
    }

public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                // Dịch chuyển các phần tử phía sau lên trước
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Xóa phần tử cuối
                qtyInStore--;
                System.out.println("Removed from store: " + dvd.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD is not found in the store.");
        }
    }