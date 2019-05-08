package com.harloomdev.camerabooking.Http.conf.API.Model.Profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile implements Parcelable {

    @SerializedName("id_ktp")
    @Expose
    private String idKtp;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("pekerjaan")
    @Expose
    private String pekerjaan;
    @SerializedName("no_handphone")
    @Expose
    private String noHandphone;

    public Profile(String idKtp, String nama, String tempatLahir, String tanggalLahir, String alamat, String jenisKelamin, String pekerjaan, String noHandphone) {
        this.idKtp = idKtp;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
        this.noHandphone = noHandphone;
    }

    public Profile() {
    }

    public String getIdKtp() {
        return idKtp;
    }

    public void setIdKtp(String idKtp) {
        this.idKtp = idKtp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "idKtp='" + idKtp + '\'' +
                ", nama='" + nama + '\'' +
                ", tempatLahir='" + tempatLahir + '\'' +
                ", tanggalLahir='" + tanggalLahir + '\'' +
                ", alamat='" + alamat + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", pekerjaan='" + pekerjaan + '\'' +
                ", noHandphone='" + noHandphone + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idKtp);
        dest.writeString(this.nama);
        dest.writeString(this.tempatLahir);
        dest.writeString(this.tanggalLahir);
        dest.writeString(this.alamat);
        dest.writeString(this.jenisKelamin);
        dest.writeString(this.pekerjaan);
        dest.writeString(this.noHandphone);
    }

    protected Profile(Parcel in) {
        this.idKtp = in.readString();
        this.nama = in.readString();
        this.tempatLahir = in.readString();
        this.tanggalLahir = in.readString();
        this.alamat = in.readString();
        this.jenisKelamin = in.readString();
        this.pekerjaan = in.readString();
        this.noHandphone = in.readString();
    }

    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
