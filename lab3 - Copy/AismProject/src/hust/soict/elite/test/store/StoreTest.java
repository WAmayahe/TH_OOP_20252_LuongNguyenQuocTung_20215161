package hust.soict.elite.test.store;

import hust.soict.elite.aims.disc.DigitalVideoDisc;
import hust.soict.elite.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Khởi tạo cửa hàng
        Store store = new Store();

        // Khởi tạo một số đĩa
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Test thêm đĩa vào Store
        System.out.println("--- Testing Add to Store ---");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Test xóa đĩa khỏi Store
        System.out.println("\n--- Testing Remove from Store ---");
        store.removeDVD(dvd2); // Xóa thành công
        store.removeDVD(dvd2); // Xóa lại đĩa đã xóa -> Báo không tìm thấy
    }
}