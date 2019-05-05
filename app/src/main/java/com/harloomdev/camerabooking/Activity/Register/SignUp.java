package com.harloomdev.camerabooking.Activity.Register;

import android.text.TextUtils;

public class SignUp implements  IRegister{
    private String idktp;
    private String nama;
    private String alamat;
    private String noHandphone;
    private String pekerjaan;
    private String jenis_kelamin;
    private String kota;
    private String tanggal_lahir;
    private String password;
    private String confimPassword;

    public SignUp(String idktp, String nama, String alamat, String noHandphone, String pekerjaan, String jenis_kelamin, String kota, String tanggal_lahir, String password, String confimPassword) {
        this.idktp = idktp;
        this.nama = nama;
        this.alamat = alamat;
        this.noHandphone = noHandphone;
        this.pekerjaan = pekerjaan;
        this.jenis_kelamin = jenis_kelamin;
        this.kota = kota;
        this.tanggal_lahir = tanggal_lahir;
        this.password = password;
        this.confimPassword = confimPassword;
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

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
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

    public String getConfimPassword() {
        return confimPassword;
    }

    public void setConfimPassword(String confimPassword) {
        this.confimPassword = confimPassword;
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
                ", kota='" + kota + '\'' +
                ", tanggal_lahir='" + tanggal_lahir + '\'' +
                ", password='" + password + '\'' +
                ", confimPassword='" + confimPassword + '\'' +
                '}';
    }

//    public  Boolean isValidIdKtp (String id_ktp){
//        return id_ktp.length() == 16;
//    }
//
//    public  Boolean isValidIdnama (String nama){
//        return nama.length()> 3;
//    }
//
    public boolean isPasswordValid(String password) {
       return password.length() > 4;
    }



    public boolean validConfimPassword(String password , String confpassword){
        if(TextUtils.isEmpty(password)){
            return false;
        }
        return password.equals(confpassword);

    }

    @Override
    public int validData() {
        return 0;
    }
}
