package mobile.sti.com.sti.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MainModel implements Parcelable {
    private String nama;
    private String rating;
    private String gambar;

    public MainModel(String nama, String rating, String gambar) {
        this.nama = nama;
        this.rating = rating;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.rating);
        dest.writeString(this.gambar);
    }

    protected MainModel(Parcel in) {
        this.nama = in.readString();
        this.rating = in.readString();
        this.gambar = in.readString();
    }

    public static final Parcelable.Creator<MainModel> CREATOR = new Parcelable.Creator<MainModel>() {
        @Override
        public MainModel createFromParcel(Parcel source) {
            return new MainModel(source);
        }

        @Override
        public MainModel[] newArray(int size) {
            return new MainModel[size];
        }
    };
}
