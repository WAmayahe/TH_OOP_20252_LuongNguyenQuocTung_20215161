package hust.soict.elite.test.passingparameter; // Bắt buộc phải có dòng này và khớp với thư mục

// Import đúng đường dẫn đến lớp DigitalVideoDisc
import hust.soict.elite.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        
        // Kiểm tra swap (Hoán đổi)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("--- After swap ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
        // Kiểm tra changeTitle (Thay đổi tiêu đề)
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("--- After changeTitle ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    
    // Phương thức swap (Lưu ý: Cách hoán đổi này bằng tham chiếu trong Java sẽ KHÔNG làm đổi thông tin đĩa gốc ở hàm main)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    
    // Phương thức đổi tiêu đề
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        // Việc khởi tạo lại đối tượng dvd ở đây (như trong Lab) chỉ thay đổi biến cục bộ, không ảnh hưởng đến đối tượng gốc ngoài main
        dvd = new DigitalVideoDisc(oldTitle); 
    }
}