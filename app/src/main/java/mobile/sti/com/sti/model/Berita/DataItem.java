package mobile.sti.com.sti.model.Berita;

import com.google.gson.annotations.SerializedName;

public class DataItem {

    @SerializedName("baca")
    private String baca;

    @SerializedName("gambar1")
    private String gambar1;

    @SerializedName("bahasa")
    private String bahasa;

    @SerializedName("gambar3")
    private String gambar3;

    @SerializedName("gambar2")
    private String gambar2;

    @SerializedName("kategori_konten")
    private String kategoriKonten;

    @SerializedName("lampiran")
    private String lampiran;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private String id;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("judul")
    private String judul;

    public String getBaca() {
        return baca;
    }

    public void setBaca(String baca) {
        this.baca = baca;
    }

    public String getGambar1() {
        return gambar1;
    }

    public void setGambar1(String gambar1) {
        this.gambar1 = gambar1;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getGambar3() {
        return gambar3;
    }

    public void setGambar3(String gambar3) {
        this.gambar3 = gambar3;
    }

    public String getGambar2() {
        return gambar2;
    }

    public void setGambar2(String gambar2) {
        this.gambar2 = gambar2;
    }

    public String getKategoriKonten() {
        return kategoriKonten;
    }

    public void setKategoriKonten(String kategoriKonten) {
        this.kategoriKonten = kategoriKonten;
    }

    public String getLampiran() {
        return lampiran;
    }

    public void setLampiran(String lampiran) {
        this.lampiran = lampiran;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Override
    public String toString() {
        return
                "DataItem{" +
                        "baca = '" + baca + '\'' +
                        ",gambar1 = '" + gambar1 + '\'' +
                        ",bahasa = '" + bahasa + '\'' +
                        ",gambar3 = '" + gambar3 + '\'' +
                        ",gambar2 = '" + gambar2 + '\'' +
                        ",kategori_konten = '" + kategoriKonten + '\'' +
                        ",lampiran = '" + lampiran + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",deskripsi = '" + deskripsi + '\'' +
                        ",judul = '" + judul + '\'' +
                        "}";
    }
}