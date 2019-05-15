package com.harloomdev.camerabooking.Activity.Chart;

import android.text.TextUtils;

public class PostKwitansi {
    private String id_ktp;
    private Integer lama;
    private String id_service;
    private String alamat_antar;

    public PostKwitansi(String id_ktp, Integer lama, String id_service, String alamat_antar) {
        this.id_ktp = id_ktp;
        this.lama = lama;
        this.id_service = id_service;
        this.alamat_antar = alamat_antar;
    }

    public Boolean valid() {
        if (TextUtils.isEmpty(id_ktp) || TextUtils.isEmpty(id_service) || lama == 0 || TextUtils.isEmpty(alamat_antar)) {
            return false;
        } else {
            return true;

        }
    }
}
