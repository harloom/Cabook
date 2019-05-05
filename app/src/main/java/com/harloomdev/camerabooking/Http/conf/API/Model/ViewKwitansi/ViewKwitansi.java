package com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewKwitansi implements Parcelable {
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("tanggal_expire")
    @Expose
    private String tanggalExpire;
    @SerializedName("id_ktp")
    @Expose
    private String idKtp;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("nama_pelayanan")
    @Expose
    private String namaPelayanan;
    @SerializedName("no_kwitansi")
    @Expose
    private String noKwitansi;
    @SerializedName("lama_pinjam")
    @Expose
    private Integer lamaPinjam;
    @SerializedName("statusB")
    @Expose
    private String statusB;
    @SerializedName("alamat_antar")
    @Expose
    private String alamatAntar;
    @SerializedName("detail")
    @Expose
    private List<Detail> detail = null;

    public ViewKwitansi(String tanggal, String tanggalExpire, String idKtp, String nama, String namaPelayanan, String noKwitansi, Integer lamaPinjam, String statusB, String alamatAntar, List<Detail> detail) {
        this.tanggal = tanggal;
        this.tanggalExpire = tanggalExpire;
        this.idKtp = idKtp;
        this.nama = nama;
        this.namaPelayanan = namaPelayanan;
        this.noKwitansi = noKwitansi;
        this.lamaPinjam = lamaPinjam;
        this.statusB = statusB;
        this.alamatAntar = alamatAntar;
        this.detail = detail;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggalExpire() {
        return tanggalExpire;
    }

    public void setTanggalExpire(String tanggalExpire) {
        this.tanggalExpire = tanggalExpire;
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

    public String getNamaPelayanan() {
        return namaPelayanan;
    }

    public void setNamaPelayanan(String namaPelayanan) {
        this.namaPelayanan = namaPelayanan;
    }

    public String getNoKwitansi() {
        return noKwitansi;
    }

    public void setNoKwitansi(String noKwitansi) {
        this.noKwitansi = noKwitansi;
    }

    public Integer getLamaPinjam() {
        return lamaPinjam;
    }

    public void setLamaPinjam(Integer lamaPinjam) {
        this.lamaPinjam = lamaPinjam;
    }

    public String getStatusB() {
        return statusB;
    }

    public void setStatusB(String statusB) {
        this.statusB = statusB;
    }

    public String getAlamatAntar() {
        return alamatAntar;
    }

    public void setAlamatAntar(String alamatAntar) {
        this.alamatAntar = alamatAntar;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ViewKwitansi{" +
                "tanggal='" + tanggal + '\'' +
                ", tanggalExpire='" + tanggalExpire + '\'' +
                ", idKtp='" + idKtp + '\'' +
                ", nama='" + nama + '\'' +
                ", namaPelayanan='" + namaPelayanan + '\'' +
                ", noKwitansi='" + noKwitansi + '\'' +
                ", lamaPinjam=" + lamaPinjam +
                ", statusB='" + statusB + '\'' +
                ", alamatAntar='" + alamatAntar + '\'' +
                ", detail=" + detail +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tanggal);
        dest.writeString(tanggalExpire);
        dest.writeString(idKtp);
        dest.writeString(nama);
        dest.writeString(namaPelayanan);
        dest.writeString(noKwitansi);
        if (lamaPinjam == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(lamaPinjam);
        }
        dest.writeString(statusB);
        dest.writeString(alamatAntar);
    }

    protected ViewKwitansi(Parcel in) {
        tanggal = in.readString();
        tanggalExpire = in.readString();
        idKtp = in.readString();
        nama = in.readString();
        namaPelayanan = in.readString();
        noKwitansi = in.readString();
        if (in.readByte() == 0) {
            lamaPinjam = null;
        } else {
            lamaPinjam = in.readInt();
        }
        statusB = in.readString();
        alamatAntar = in.readString();
    }

    public static final Creator<ViewKwitansi> CREATOR = new Creator<ViewKwitansi>() {
        @Override
        public ViewKwitansi createFromParcel(Parcel in) {
            return new ViewKwitansi(in);
        }

        @Override
        public ViewKwitansi[] newArray(int size) {
            return new ViewKwitansi[size];
        }
    };
}
