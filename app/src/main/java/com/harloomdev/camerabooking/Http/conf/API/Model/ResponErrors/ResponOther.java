package com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponOther {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("massage")
    @Expose
    private String massage;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
