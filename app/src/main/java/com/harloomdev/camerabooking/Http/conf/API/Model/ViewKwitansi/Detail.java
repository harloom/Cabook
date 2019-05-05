package com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail  implements Parcelable {

    @SerializedName("no_kwitansi")
    @Expose
    private String noKwitansi;
    @SerializedName("id_kamera")
    @Expose
    private String idKamera;
    @SerializedName("nama_kamera")
    @Expose
    private String namaKamera;
    @SerializedName("harga")
    @Expose
    private Integer harga;
    @SerializedName("jumlah_pinjam")
    @Expose
    private Integer jumlahPinjam;
    @SerializedName("ppn")
    @Expose
    private Double ppn;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("pajak")
    @Expose
    private Integer pajak;
    @SerializedName("total_bayar")
    @Expose
    private Integer totalBayar;
    @SerializedName("url_image")
    @Expose
    private Integer urlImage;
    @SerializedName("satuan")
    @Expose
    private String satuan;

    public Detail(String noKwitansi, String idKamera, String namaKamera, Integer harga, Integer jumlahPinjam, Double ppn, Integer total, Integer pajak, Integer totalBayar, Integer urlImage, String satuan) {
        this.noKwitansi = noKwitansi;
        this.idKamera = idKamera;
        this.namaKamera = namaKamera;
        this.harga = harga;
        this.jumlahPinjam = jumlahPinjam;
        this.ppn = ppn;
        this.total = total;
        this.pajak = pajak;
        this.totalBayar = totalBayar;
        this.urlImage = urlImage;
        this.satuan = satuan;
    }

    public String getNoKwitansi() {
        return noKwitansi;
    }

    public void setNoKwitansi(String noKwitansi) {
        this.noKwitansi = noKwitansi;
    }

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

    public Integer getJumlahPinjam() {
        return jumlahPinjam;
    }

    public void setJumlahPinjam(Integer jumlahPinjam) {
        this.jumlahPinjam = jumlahPinjam;
    }

    public Double getPpn() {
        return ppn;
    }

    public void setPpn(Double ppn) {
        this.ppn = ppn;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPajak() {
        return pajak;
    }

    public void setPajak(Integer pajak) {
        this.pajak = pajak;
    }

    public Integer getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Integer totalBayar) {
        this.totalBayar = totalBayar;
    }

    public Integer getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Integer urlImage) {
        this.urlImage = urlImage;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noKwitansi);
        dest.writeString(idKamera);
        dest.writeString(namaKamera);
        if (harga == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(harga);
        }
        if (jumlahPinjam == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(jumlahPinjam);
        }
        if (ppn == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(ppn);
        }
        if (total == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(total);
        }
        if (pajak == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pajak);
        }
        if (totalBayar == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalBayar);
        }
        dest.writeString(satuan);
    }

    protected Detail(Parcel in) {
        noKwitansi = in.readString();
        idKamera = in.readString();
        namaKamera = in.readString();
        if (in.readByte() == 0) {
            harga = null;
        } else {
            harga = in.readInt();
        }
        if (in.readByte() == 0) {
            jumlahPinjam = null;
        } else {
            jumlahPinjam = in.readInt();
        }
        if (in.readByte() == 0) {
            ppn = null;
        } else {
            ppn = in.readDouble();
        }
        if (in.readByte() == 0) {
            total = null;
        } else {
            total = in.readInt();
        }
        if (in.readByte() == 0) {
            pajak = null;
        } else {
            pajak = in.readInt();
        }
        if (in.readByte() == 0) {
            totalBayar = null;
        } else {
            totalBayar = in.readInt();
        }
        satuan = in.readString();
    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
        }
    };
}
