package hust.soict.elite.test.passingparameter;

import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        // Khởi tạo 2 đối tượng DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // 1. Thử nghiệm hàm swap (Sẽ thất bại)
        System.out.println("--- Trước khi gọi swap ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);

        System.out.println("--- Sau khi gọi swap (Không đổi) ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // 2. Thử nghiệm hàm changeTitle (Sẽ thành công một phần)
        System.out.println("\n--- Trước khi gọi changeTitle ---");
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title sau khi change: " + jungleDVD.getTitle());
    }

    // Hàm swap này không hoạt động vì Java truyền bản sao của tham chiếu (Pass-by-value)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
        // o1 và o2 chỉ là các biến cục bộ, việc tráo đổi chúng không ảnh hưởng đến biến ở main
    }

    // Hàm này thành công vì ta dùng tham chiếu để truy cập vào vùng nhớ thật và gọi setter
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title); // Tác động trực tiếp vào đối tượng thật
        dvd = new DigitalVideoDisc(oldTitle); // Dòng này vô nghĩa vì chỉ thay đổi biến cục bộ 'dvd'
    }

    public static void actualSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tempTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tempTitle);
        
        // Nếu có thêm các trường khác như cost, category thì cũng phải swap tương tự
    }
}