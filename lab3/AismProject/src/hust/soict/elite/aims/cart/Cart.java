package hust.soict.elite.aims.cart;

import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // 1. Thêm 1 DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added: " + disc.getTitle());
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // 2.1. Overloading: Thêm một danh sách DVD (Mảng)
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                addDigitalVideoDisc(disc);
            } else {
                System.out.println("The cart is full. Cannot add more discs.");
                break;
            }
        }
    }

    // 2.2. Overloading: Thêm 2 DVD cùng lúc
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("The cart is almost full. Cannot add both discs.");
        }
    }

    // Tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // 6. Phương thức in danh sách giỏ hàng
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". DVD - " + itemsOrdered[i].getTitle() + " - " 
                + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - " 
                + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}