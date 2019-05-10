package com.harloomdev.camerabooking.Activity.Login;

import android.os.Parcel;
import android.os.Parcelable;

public class Mlogin implements Parcelable {
    private String id_ktp;
    private String password;

    public Mlogin(String id_ktp, String password) {
        this.id_ktp = id_ktp;
        this.password = password;
    }

    public Mlogin() {
    }

    protected Mlogin(Parcel in) {
        id_ktp = in.readString();
        password = in.readString();
    }

    public static final Creator<Mlogin> CREATOR = new Creator<Mlogin>() {
        @Override
        public Mlogin createFromParcel(Parcel in) {
            return new Mlogin(in);
        }

        @Override
        public Mlogin[] newArray(int size) {
            return new Mlogin[size];
        }
    };

    public String getId_ktp() {
        return id_ktp;
    }

    public void setId_ktp(String id_ktp) {
        this.id_ktp = id_ktp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_ktp);
        dest.writeString(password);
    }

    //validatiion
    public  boolean isIdValid(String id_ktp) {
        //TODO: Replace this with your own logic
        return id_ktp.length() == 16;
    }

    public boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}
