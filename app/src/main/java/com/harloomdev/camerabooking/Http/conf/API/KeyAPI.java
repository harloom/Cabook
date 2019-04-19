package com.harloomdev.camerabooking.Http.conf.API;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyAPI  implements Parcelable {
    @SerializedName("keyAPI")
    @Expose
    private  String keyAPI;

    protected KeyAPI(Parcel in) {
        keyAPI = in.readString();
    }

    public static final Creator<KeyAPI> CREATOR = new Creator<KeyAPI>() {
        @Override
        public KeyAPI createFromParcel(Parcel in) {
            return new KeyAPI(in);
        }

        @Override
        public KeyAPI[] newArray(int size) {
            return new KeyAPI[size];
        }
    };

    public String getKeyAPI() {
        return keyAPI;
    }

    public void setKeyAPI(String keyAPI) {
        this.keyAPI = keyAPI;
    }

    @Override
    public String toString() {
        return "KeyAPI{" +
                "keyAPI='" + keyAPI + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(keyAPI);
    }
}
