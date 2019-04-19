package com.harloomdev.camerabooking.Http.conf.API.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {
    @SerializedName("id_kamera")
    @Expose
    private String idKamera;
    @SerializedName("nama_kamera")
    @Expose
    private String namaKamera;
    @SerializedName("harga")
    @Expose
    private Integer harga;
    @SerializedName("stok")
    @Expose
    private Integer stok;
    @SerializedName("satuan")
    @Expose
    private String satuan;

    public String getIdKamera() {
        return idKamera;
    }

    public void setIdKamera(String idKamera) {
        this.idKamera = idKamera;
    }

    public String getNamaKamera() {
        return namaKamera;
    }

    public void setNamaKamera(String namaKamera) {
        this.namaKamera = namaKamera;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    @Override
    public String toString() {
        return "Products{" +
                "idKamera='" + idKamera + '\'' +
                ", namaKamera='" + namaKamera + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                ", satuan='" + satuan + '\'' +
                '}';
    }
}
