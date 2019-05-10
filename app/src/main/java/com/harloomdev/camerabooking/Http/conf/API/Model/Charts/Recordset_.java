
package com.harloomdev.camerabooking.Http.conf.API.Model.Charts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recordset_ {

    @SerializedName("id_ktp")
    @Expose
    private String idKtp;
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
    @SerializedName("satuan")
    @Expose
    private String satuan;
    @SerializedName("url_image")
    @Expose
    private Object urlImage;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("jumlah_bayar")
    @Expose
    private Integer jumlahBayar;
    @SerializedName("id_service")
    @Expose
    private String id_service;
    @SerializedName("pajak")
    @Expose
    private Integer pajak;

    public Recordset_(String idKtp, String idKamera, String namaKamera, Integer harga, Integer jumlahPinjam, String satuan, Object urlImage, String nama, Integer jumlahBayar, String id_service, Integer pajak) {
        this.idKtp = idKtp;
        this.idKamera = idKamera;
        this.namaKamera = namaKamera;
        this.harga = harga;
        this.jumlahPinjam = jumlahPinjam;
        this.satuan = satuan;
        this.urlImage = urlImage;
        this.nama = nama;
        this.jumlahBayar = jumlahBayar;
        this.id_service = id_service;
        this.pajak = pajak;
    }

    public String getId_service() {
        return id_service;
    }

    public void setId_service(String id_service) {
        this.id_service = id_service;
    }

    public Recordset_() {
    }

    public String getIdKtp() {
        return idKtp;
    }

    public void setIdKtp(String idKtp) {
        this.idKtp = idKtp;
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

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Object getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Object urlImage) {
        this.urlImage = urlImage;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(Integer jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public Integer getPajak() {
        return pajak;
    }

    public void setPajak(Integer pajak) {
        this.pajak = pajak;
    }
}
