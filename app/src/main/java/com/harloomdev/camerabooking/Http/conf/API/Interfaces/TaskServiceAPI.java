package com.harloomdev.camerabooking.Http.conf.API.Interfaces;

import com.harloomdev.camerabooking.Activity.Chart.ServiceChart;
import com.harloomdev.camerabooking.Http.conf.API.KeyAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.Http.conf.API.Model.Profile.Profile;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.ViewKwitansi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TaskServiceAPI {

//    login
    @FormUrlEncoded
    @Headers("key: ktp")
    @POST("authentication/")
    Call<KeyAPI> postLogin(@Field("id_ktp") String _idktp,
                           @Field("plaintext") String _passs);

    //registrasi
    @FormUrlEncoded
    @POST("register")
    Call<ResponOther> postSignUp (@Field("id_ktp") String _idktp, @Field("nama") String _nama ,
                                  @Field("alamat") String _alamat, @Field("no_handphone") String _noHp,
                                  @Field("pekerjaan") String _pekerjaan , @Field("jenis_kelamin") String _jenisKelamin,
                                  @Field("tanggal_lahir") String _tanggalLahir , @Field("tempat_lahir") String _tempatlahir,
                                  @Field("password") String _password);

    //profile
    @Headers("Content-Type: application/json")
    @GET("data/profile")
    Call<Profile> getProfile(@Query("id_ktp") String _idktp);

    //get products
    @Headers("Content-Type: application/json")
    @GET("data/products")
    Call<List<Products>> getProducts();

    //get Sevice
    @Headers("Content-Type: application/json")
    @GET("data/services")
    Call<List<ServiceChart>> getService();

    //getChart
    @GET("charts/")
    Call<Chart> getChart(@Query("id_ktp") String _idktp,@Header("key_api") String key);
    @FormUrlEncoded
    @PUT("charts/")
    Call<Chart> editChart (@Header("key_api") String key ,@Field("id_kamera") String idkamera,
                                      @Field("id_ktp") String id_ktp,@Field("jumlah") String jumlah,
                           @Field("service") String idsevice , @Field("lama") int _lama);


    //viewKwitansi
    @GET("kwintasi/{id_ktp}")
    Call<ArrayList<ViewKwitansi>> getViewKwitansi(@HeaderMap Map<String,String> headers, @Path("id_ktp") String _idKTP);




}
