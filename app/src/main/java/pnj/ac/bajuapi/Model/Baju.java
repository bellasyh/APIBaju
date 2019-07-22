package pnj.ac.bajuapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Baju {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("merek")
    @Expose
    private String merek;

    @SerializedName("jenis_baju")
    @Expose
    private String jenis_baju;

    @SerializedName("harga")
    @Expose
    private Integer harga;

    @SerializedName("jumlah_beli")
    @Expose
    private Integer jumlah_beli;

    public Baju(Integer id, String nama, String merek, String jenis_baju, Integer harga, Integer jumlah_beli) {
        this.id = id;
        this.nama = nama;
        this.merek = merek;
        this.jenis_baju = jenis_baju;
        this.harga = harga;
        this.jumlah_beli = jumlah_beli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getJenis_baju() {
        return jenis_baju;
    }

    public void setJenis_baju(String jenis_baju) {
        this.jenis_baju = jenis_baju;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga ) {
        this.harga = harga;
    }

    public String getJumlah_beli() {
        return nama;
    }

    public void setJumlah_beli(Integer jumlah_beli ) {
        this.jumlah_beli = jumlah_beli;
    }


}
