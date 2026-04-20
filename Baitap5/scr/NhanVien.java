public class NhanVien {
    // Thuộc tính protected để lớp con TruongPhong có thể truy cập trực tiếp
    protected String tenNhanVien;
    protected double heSoLuong;
    
    // Hằng số (public static final)
    public static final double LUONG_CO_BAN = 750000;
    public static final double LUONG_MAX = 20000000;

    // Constructor
    public NhanVien(String tenNhanVien, double heSoLuong) {
        this.tenNhanVien = tenNhanVien;
        this.heSoLuong = heSoLuong;
    }

    // Phương thức tăng lương
    public boolean tangLuong(double heSoTang) {
        double heSoMoi = this.heSoLuong + heSoTang;
        if (heSoMoi * LUONG_CO_BAN <= LUONG_MAX) {
            this.heSoLuong = heSoMoi;
            return true;
        }
        return false;
    }

    // Phương thức tính lương
    public double tinhLuong() {
        return heSoLuong * LUONG_CO_BAN;
    }

    // Phương thức in thông tin
    public void inTTin() {
        System.out.println("Tên NV: " + tenNhanVien);
        System.out.println("Hệ số lương: " + heSoLuong);
        System.out.println("Lương: " + tinhLuong());
    }
}

