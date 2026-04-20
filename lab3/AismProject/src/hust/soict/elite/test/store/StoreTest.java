package hust.soict.elite.test.store; // Đặt đúng package test

// Import các lớp từ package aims
import hust.soict.elite.aims.store.Store;
import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo một kho hàng mới
        Store store = new Store();
        
        // Tạo các đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        
        // Kiểm tra thêm đĩa vào kho
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        
        // Kiểm tra xóa đĩa khỏi kho
        System.out.println("\n--- Bắt đầu thử nghiệm xóa đĩa ---");
        store.removeDVD(dvd2); // Xóa đĩa Star Wars
        
        // Thử xóa một đĩa không có trong kho hoặc đã bị xóa
        store.removeDVD(dvd2); 
    }
}