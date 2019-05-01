package com.harloomdev.camerabooking.Http.conf.API.Model;

public class SignUp {
    private String idktp;
    private String nama;
    private String alamat;
    private String noHandphone;
    private String pekerjaan;
    private String jenis_kelamin;
    private String tempat_lahir;
    private String tanggal_lahir;
    private String password;

    public SignUp(String idktp, String nama, String alamat, String noHandphone, String pekerjaan, String jenis_kelamin, String tempat_lahir, String tanggal_lahir, String password) {
        this.idktp = idktp;
        this.nama = nama;
        this.alamat = alamat;
        this.noHandphone = noHandphone;
        this.pekerjaan = pekerjaan;
        this.jenis_kelamin = jenis_kelamin;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.password = password;
    }

    public SignUp() {
    }

    public String getIdktp() {
        return idktp;
    }

    public void setIdktp(String idktp) {
        this.idktp = idktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignUp{" +
                "idktp='" + idktp + '\'' +
                ", nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noHandphone='" + noHandphone + '\'' +
                ", pekerjaan='" + pekerjaan + '\'' +
                ", jenis_kelamin='" + jenis_kelamin + '\'' +
                ", tempat_lahir='" + tempat_lahir + '\'' +
                ", tanggal_lahir='" + tanggal_lahir + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public  Boolean isValidIdKtp (String id_ktp){
        return id_ktp.length() == 16;
    }

    public  Boolean isValidIdnama (String nama){
        return nama.length()> 3;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}
