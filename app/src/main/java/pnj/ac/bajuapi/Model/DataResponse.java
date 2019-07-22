package pnj.ac.bajuapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("data")

    @Expose

    private List<Baju> data = null;



    public List<Baju> getData() {

        return data;

    }



    public void setData(List<Baju> data) {

        this.data = data;

    }
}
