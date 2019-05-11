package com.harloomdev.camerabooking.Activity.Chart;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceChart implements Parcelable {
    @SerializedName("id_service")
    @Expose
    private String idService;
    @SerializedName("nama_pelayanan")
    @Expose
    private String namaPelayanan;
    @SerializedName("ppn")
    @Expose
    private Double ppn;

    public ServiceChart(String idService, String namaPelayanan, Double ppn) {
        this.idService = idService;
        this.namaPelayanan = namaPelayanan;
        this.ppn = ppn;
    }

    public ServiceChart() {
    }



    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNamaPelayanan() {
        return namaPelayanan;
    }

    public void setNamaPelayanan(String namaPelayanan) {
        this.namaPelayanan = namaPelayanan;
    }

    public Double getPpn() {
        return ppn;
    }

    public void setPpn(Double ppn) {
        this.ppn = ppn;
    }

    @Override
    public String toString() {
        return "ServiceChart{" +
                "idService='" + idService + '\'' +
                ", namaPelayanan='" + namaPelayanan + '\'' +
                ", ppn=" + ppn +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idService);
        dest.writeString(this.namaPelayanan);
        dest.writeValue(this.ppn);
    }

    protected ServiceChart(Parcel in) {
        this.idService = in.readString();
        this.namaPelayanan = in.readString();
        this.ppn = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<ServiceChart> CREATOR = new Parcelable.Creator<ServiceChart>() {
        @Override
        public ServiceChart createFromParcel(Parcel source) {
            return new ServiceChart(source);
        }

        @Override
        public ServiceChart[] newArray(int size) {
            return new ServiceChart[size];
        }
    };
}
