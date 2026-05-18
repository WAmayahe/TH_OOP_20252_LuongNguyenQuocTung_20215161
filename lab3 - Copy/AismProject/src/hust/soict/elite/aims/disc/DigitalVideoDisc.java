package hust.soict.elite.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    // Static member: dùng chung cho mọi đối tượng DVD
    private static int nbDigitalVideoDiscs = 0;
    // Instance member: định danh riêng cho từng đối tượng
    private int id;

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    // Các constructor khác bạn cũng nhớ thêm nbDigitalVideoDiscs++ và id = nbDigitalVideoDiscs nhé

    public String getTitle() { return title; }
    public int getId() { return id; }

    // Phương thức toString() để in thông tin DVD theo định dạng yêu cầu
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }

    // Kiểm tra xem title truyền vào có khớp với đĩa không
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
}