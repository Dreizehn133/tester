package mobile.sti.com.sti.model.Berita;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Berita {

    @SerializedName("data")
    private List<DataItem> data;

    @SerializedName("response")
    private int response;

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return
                "Berita{" +
                        "data = '" + data + '\'' +
                        ",response = '" + response + '\'' +
                        "}";
    }
}