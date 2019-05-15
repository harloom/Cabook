package com.harloomdev.camerabooking.Activity.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {
    @SerializedName("no_kwitansi")
    @Expose
    public String noKwitansi;
    @SerializedName("id_kamera")
    @Expose
    public String idKamera;
    @SerializedName("jumlah_pinjam")
    @Expose
    public Integer jumlahPinjam;
    @SerializedName("tanggal_dikembalikan")
    @Expose
    public String tanggalDikembalikan;
    @SerializedName("ppn")
    @Expose
    public Float ppn;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("pajak")
    @Expose
    public Integer pajak;
    @SerializedName("total_bayar")
    @Expose
    public Integer totalBayar;
    @SerializedName("harga")
    @Expose
    public Integer harga;
    @SerializedName("url_image")
    @Expose
    public String urlImage;
    @SerializedName("satuan")
    @Expose
    public String satuan;

    /**
     * No args constructor for use in serialization
     *
     */
    public Detail() {
    }

    /**
     *
     * @param total
     * @param urlImage
     * @param totalBayar
     * @param ppn
     * @param tanggalDikembalikan
     * @param noKwitansi
     * @param satuan
     * @param jumlahPinjam
     * @param harga
     * @param pajak
     * @param idKamera
     */
    public Detail(String noKwitansi, String idKamera, Integer jumlahPinjam, String tanggalDikembalikan, Float ppn, Integer total, Integer pajak, Integer totalBayar, Integer harga, String urlImage, String satuan) {
        super();
        this.noKwitansi = noKwitansi;
        this.idKamera = idKamera;
        this.jumlahPinjam = jumlahPinjam;
        this.tanggalDikembalikan = tanggalDikembalikan;
        this.ppn = ppn;
        this.total = total;
        this.pajak = pajak;
        this.totalBayar = totalBayar;
        this.harga = harga;
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

    public Integer getJumlahPinjam() {
        return jumlahPinjam;
    }

    public void setJumlahPinjam(Integer jumlahPinjam) {
        this.jumlahPinjam = jumlahPinjam;
    }

    public String getTanggalDikembalikan() {
        return tanggalDikembalikan;
    }

    public void setTanggalDikembalikan(String tanggalDikembalikan) {
        this.tanggalDikembalikan = tanggalDikembalikan;
    }

    public Float getPpn() {
        return ppn;
    }

    public void setPpn(Float ppn) {
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

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
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
}