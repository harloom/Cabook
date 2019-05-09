package com.harloomdev.camerabooking.Http.conf.API.Model;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products implements Parcelable {
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
    @SerializedName("url_image")
    @Expose
    private String urlImage;
    @SerializedName("satuan")
    @Expose
    private String satuan;

    public Products(String idKamera, String namaKamera, Integer harga, Integer stok, String urlImage, String satuan) {
        this.idKamera = idKamera;
        this.namaKamera = namaKamera;
        this.harga = harga;
        this.stok = stok;
        this.urlImage = urlImage;
        this.satuan = satuan;
    }

    protected Products(Parcel in) {
        idKamera = in.readString();
        namaKamera = in.readString();
        if (in.readByte() == 0) {
            harga = null;
        } else {
            harga = in.readInt();
        }
        if (in.readByte() == 0) {
            stok = null;
        } else {
            stok = in.readInt();
        }
        urlImage = in.readString();
        satuan = in.readString();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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
                ", urlImage='" + urlImage + '\'' +
                ", satuan='" + satuan + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idKamera);
        parcel.writeString(namaKamera);
        if (harga == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(harga);
        }
        if (stok == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(stok);
        }
        parcel.writeString(urlImage);
        parcel.writeString(satuan);
    }
}
