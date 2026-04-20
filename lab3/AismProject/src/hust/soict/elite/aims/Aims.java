package hust.soict.elite.aims; // Khai báo package khớp với thư mục chứa file

// Import các lớp từ các package con để sử dụng
import hust.soict.elite.aims.cart.Cart;
import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // 1. Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // 2. Tạo các đối tượng DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // --- GỌI CÁC HÀM NẠP CHỒNG (OVERLOADING) ---
        
        // Cách 1: Thêm 2 DVD cùng lúc (Phần 2.2 trong Lab)
        anOrder.addDigitalVideoDisc(dvd1, dvd2);

        // Cách 2: Thêm một mảng các DVD (Phần 2.1 trong Lab)
        DigitalVideoDisc[] dvdList = {dvd3, new DigitalVideoDisc("Mulan")};
        anOrder.addDigitalVideoDisc(dvdList);

        // 3. In tổng tiền để kiểm tra kết quả
        System.out.println("Total Cost is: " + anOrder.totalCost());
    }
}