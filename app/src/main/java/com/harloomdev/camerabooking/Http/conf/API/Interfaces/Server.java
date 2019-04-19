package com.harloomdev.camerabooking.Http.conf.API.Interfaces;

import com.harloomdev.camerabooking.Http.conf.API.KeyAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Server {
    @FormUrlEncoded
    @Headers("key: ktp")
    @POST("authentication/")
    Call<KeyAPI> postLogin(@Field("id_ktp") String _idktp,
                           @Field("plaintext") String _passs);

    //get products
    @Headers("Content-Type: application/json")
    @GET("data/products")
    Call<ArrayList<Products>> getProducts();


}
