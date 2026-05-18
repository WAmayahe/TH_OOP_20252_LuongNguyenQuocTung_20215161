package hust.soict.elite.test.cart;

import hust.soict.elite.aims.cart.Cart;
import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // To-do: Test the search methods here
        System.out.println("\n--- Testing Search Methods ---");
        // Giả sử ID của Star Wars là 2 (tùy thuộc vào thứ tự tạo đĩa)
        cart.searchById(2); 
        cart.searchByTitle("Aladdin");
        cart.searchByTitle("Iron Man"); // Đĩa này không có, sẽ báo not found
    }
}
