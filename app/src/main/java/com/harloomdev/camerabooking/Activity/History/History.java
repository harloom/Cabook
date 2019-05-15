package com.harloomdev.camerabooking.Activity.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class History {

    @SerializedName("tanggal")
    @Expose
    public String tanggal;
    @SerializedName("tanggal_expire")
    @Expose
    public String tanggalExpire;
    @SerializedName("id_ktp")
    @Expose
    public String idKtp;
    @SerializedName("nama")
    @Expose
    public String nama;
    @SerializedName("nama_pelayanan")
    @Expose
    public String namaPelayanan;
    @SerializedName("no_kwitansi")
    @Expose
    public String noKwitansi;
    @SerializedName("lama_pinjam")
    @Expose
    public Integer lamaPinjam;
    @SerializedName("statusB")
    @Expose
    public String statusB;
    @SerializedName("alamat_antar")
    @Expose
    public String alamatAntar;
    @SerializedName("detail")
    @Expose
    public List<Detail> detail = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public History() {
    }

    /**
     *
     * @param detail
     * @param statusB
     * @param lamaPinjam
     * @param noKwitansi
     * @param idKtp
     * @param nama
     * @param namaPelayanan
     * @param tanggalExpire
     * @param tanggal
     * @param alamatAntar
     */
    public History(String tanggal, String tanggalExpire, String idKtp, String nama, String namaPelayanan, String noKwitansi, Integer lamaPinjam, String statusB, String alamatAntar, List<Detail> detail) {
        super();
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


}
