package mobile.sti.com.sti.model;

public class SliderDashBoard {
    String gambar;
    String nama;
    String category;

    public SliderDashBoard(String gambar, String nama, String category) {
        this.gambar = gambar;
        this.nama = nama;
        this.category = category;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
