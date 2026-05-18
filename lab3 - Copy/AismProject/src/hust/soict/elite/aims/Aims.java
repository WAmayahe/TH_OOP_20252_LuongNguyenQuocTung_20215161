package hust.soict.elite.aims;

import hust.soict.elite.aims.cart.Cart;
import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đối tượng DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Thêm vào giỏ
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // In ra tổng tiền (Sử dụng hàm totalCost() bạn đã viết ở Cart)
        System.out.println("Total Cost is: " + anOrder.totalCost());
        
        // Thử xóa một đĩa và in lại tổng tiền
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost after removing Star Wars is: " + anOrder.totalCost());
    }
}