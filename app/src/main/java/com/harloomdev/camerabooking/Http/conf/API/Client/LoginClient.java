package com.harloomdev.camerabooking.Http.conf.API.Client;

import com.harloomdev.camerabooking.Http.conf.Server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {
    public static Retrofit retrofit  = null;
    public  static  Retrofit getLoginClient(){
        if(retrofit == null ){
            retrofit  =   new Retrofit.Builder()
                    .baseUrl(Server.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
