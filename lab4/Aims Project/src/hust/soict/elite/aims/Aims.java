package hust.soict.elite.aims;

import hust.soict.elite.aims.cart.Cart;
import hust.soict.elite.aims.media.*;
import hust.soict.elite.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 24.95f);
        Book book = new Book(2, "Java Core", "Education", 15.00f);
        book.addAuthor("Cay Horstmann");
        
        CompactDisc cd = new CompactDisc(3, "Thanh Xuan", "Pop", "Phan Manh Quynh", 30.0f, "Ha Anh Tuan");
        cd.addTrack(new Track("Track 1", 4));
        cd.addTrack(new Track("Track 2", 5));

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    viewStoreMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    viewCartMenu();
                    break;
                case 0:
                    System.out.println("Application closed. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStoreMenu() {
        int choice;
        do {
            System.out.println();
            store.printStore();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Fix lỗi kẹt phím Enter

            switch (choice) {
                case 1: // See details
                    System.out.print("Enter item title: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        System.out.println("\n[DETAILS]: " + m.toString());
                        System.out.println("--------------------------------");
                        System.out.println("1. Add this item to cart");
                        if (m instanceof Playable) {
                            System.out.println("2. Play this item");
                        }
                        System.out.println("0. Back");
                        System.out.println("--------------------------------");
                        System.out.print("Choose option: ");
                        int subChoice = scanner.nextInt();
                        scanner.nextLine(); // Fix Enter
                        
                        if (subChoice == 1) {
                            cart.addMedia(m);
                        } else if (subChoice == 2) {
                            if (m instanceof Playable) {
                                ((Playable) m).play();
                            } else {
                                System.out.println("This item cannot be played (Books cannot be played!).");
                            }
                        }
                    } else {
                        System.out.println("Item not found in store!");
                    }
                    break;

                case 2: 
                    System.out.print("Enter item title to add: ");
                    Media mAdd = store.searchByTitle(scanner.nextLine());
                    if (mAdd != null) {
                        cart.addMedia(mAdd);
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 3: 
                    System.out.print("Enter item title to play: ");
                    Media mPlay = store.searchByTitle(scanner.nextLine());
                    if (mPlay != null) {
                        if (mPlay instanceof Playable) {
                            ((Playable) mPlay).play();
                        } else {
                            System.out.println("CRITICAL: This item is a Book. Books cannot be played!");
                        }
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 4: 
                    viewCartMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    // 3. UPDATE STORE MENU
    public static void updateStoreMenu() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.print("Choose option (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.println("Choose media type: 1. DVD / 2. CD / 3. Book");
            int type = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter ID: "); int id = scanner.nextInt(); scanner.nextLine();
            System.out.print("Enter Title: "); String title = scanner.nextLine();
            System.out.print("Enter Category: "); String category = scanner.nextLine();
            System.out.print("Enter Cost: "); float cost = scanner.nextFloat(); scanner.nextLine();

            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(id, title, category, "Unknown Director", 120, cost));
            } else if (type == 2) {
                store.addMedia(new CompactDisc(id, title, category, "Unknown Director", cost, "Unknown Artist"));
            } else if (type == 3) {
                store.addMedia(new Book(id, title, category, cost));
            } else {
                System.out.println("Invalid type!");
            }
        } else if (choice == 2) {
            System.out.print("Enter item title to remove from store: ");
            Media mRem = store.searchByTitle(scanner.nextLine());
            if (mRem != null) {
                store.removeMedia(mRem);
            } else {
                System.out.println("Item not found in store!");
            }
        }
    }

    public static void viewCartMenu() {
        int choice;
        do {
            System.out.println();
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Fix Enter

            switch (choice) {
                case 1: // Filter medias
                    System.out.print("Filter by (1. ID / 2. Title): ");
                    int fChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    if (fChoice == 1) {
                        System.out.print("Enter ID to filter: ");
                        cart.filterById(scanner.nextInt());
                        scanner.nextLine(); 
                    } else if (fChoice == 2) {
                        System.out.print("Enter title keyword to filter: ");
                        cart.filterByTitle(scanner.nextLine());
                    }
                    break;

                case 2: // Sort medias
                    System.out.print("Sort by (1. Title / 2. Cost): ");
                    int sChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    if (sChoice == 1) {
                        cart.sortCartByTitle();
                    } else if (sChoice == 2) {
                        cart.sortCartByCost();
                    }
                    break;

                case 3: 
                    System.out.print("Enter item title to remove: ");
                    Media mRem = cart.searchByTitle(scanner.nextLine());
                    if (mRem != null) {
                        cart.removeMedia(mRem);
                    } else {
                        System.out.println("This item is not in your cart!");
                    }
                    break;

                case 4: 
                    System.out.print("Enter item title to play: ");
                    Media mP = cart.searchByTitle(scanner.nextLine());
                    if (mP != null) {
                        if (mP instanceof Playable) {
                            ((Playable) mP).play();
                        } else {
                            System.out.println("CRITICAL: The selected item is a Book. Books cannot be played!");
                        }
                    } else {
                        System.out.println("Item not found in your cart!");
                    }
                    break;

                case 5: // Place order
                    System.out.println("An order has been created successfully!");
                    cart.clear(); 
                    choice = 0; 
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }
}