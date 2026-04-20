package hust.soict.elite.aims.store; // Khai báo package chính xác theo thư mục

import hust.soict.elite.aims.disc.DigitalVideoDisc; // Import để sử dụng đối tượng DVD

public class Store {
    // Thuộc tính lưu trữ danh sách DVD có trong cửa hàng
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100]; 
    private int qtyInStore = 0;

    // Phương thức thêm DVD vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The disc has been added to the store: " + dvd.getTitle());
        } else {
            System.out.println("The store is full!");
        }
    }

    // Phương thức xóa DVD khỏi kho
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                // Dịch chuyển các phần tử phía sau lên để lấp chỗ trống
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The disc has been removed from the store: " + dvd.getTitle());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the store!");
        }
    }
}