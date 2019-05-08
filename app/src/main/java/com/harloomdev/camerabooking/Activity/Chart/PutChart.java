package com.harloomdev.camerabooking.Activity.Chart;

import android.os.Parcel;
import android.os.Parcelable;

public class PutChart implements Parcelable {
    private String key  ;
    private String idKtp;
    private String id_kamera;
    private String jumlah;

    public PutChart(String key, String idKtp, String id_kamera, String jumlah) {
        this.key = key;
        this.idKtp = idKtp;
        this.id_kamera = id_kamera;
        this.jumlah = jumlah;
    }

    public PutChart() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIdKtp() {
        return idKtp;
    }

    public void setIdKtp(String idKtp) {
        this.idKtp = idKtp;
    }

    public String getId_kamera() {
        return id_kamera;
    }

    public void setId_kamera(String id_kamera) {
        this.id_kamera = id_kamera;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "PutChart{" +
                "key='" + key + '\'' +
                ", idKtp='" + idKtp + '\'' +
                ", id_kamera='" + id_kamera + '\'' +
                ", jumlah='" + jumlah + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.key);
        dest.writeString(this.idKtp);
        dest.writeString(this.id_kamera);
        dest.writeString(this.jumlah);
    }

    protected PutChart(Parcel in) {
        this.key = in.readString();
        this.idKtp = in.readString();
        this.id_kamera = in.readString();
        this.jumlah = in.readString();
    }

    public static final Parcelable.Creator<PutChart> CREATOR = new Parcelable.Creator<PutChart>() {
        @Override
        public PutChart createFromParcel(Parcel source) {
            return new PutChart(source);
        }

        @Override
        public PutChart[] newArray(int size) {
            return new PutChart[size];
        }
    };
}
