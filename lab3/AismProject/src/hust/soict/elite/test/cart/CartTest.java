package hust.soict.elite.test.cart; // Đặt đúng package test

// Import các lớp từ package aims
import hust.soict.elite.aims.cart.Cart;
import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart cart = new Cart();
        
        // Tạo các đối tượng DVD mới và thêm vào giỏ
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);
        
        // 
        // Kiểm tra phương thức in giỏ hàng
        cart.print();
        
        // To-do: Kiểm tra các phương thức tìm kiếm (nếu bạn đã cài đặt trong Cart.java)
        // Ví dụ: cart.searchById(1); 
        //        cart.searchByTitle("Aladdin");

        