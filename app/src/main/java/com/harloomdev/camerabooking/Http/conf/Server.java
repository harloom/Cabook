package com.harloomdev.camerabooking.Http.conf;

public final class Server {
    private static String IP  = "192.168.137.1";
    private  static String PORT  = "3000";
    public static final String BASE_URL = "http://"+IP+":"+PORT+"/api/v1/";
    public static final String BASE_URL_Registrasi= BASE_URL+"register"; //post
    public static final String BASE_URL_Login= BASE_URL+"authentication/"; //post
    public static final String BASE_URL_PRODUCTS= BASE_URL+"data/products"; //get
    public static final String BASE_URL_PRODUCTSID= BASE_URL+"data/products/"; //get
    public static final String BASE_URL_PROFILE= BASE_URL+"data/profile"; //get
    public static final String BASE_URL_CEKSERVICE= BASE_URL+"data/services/"; //get
    public static final String BASE_URL_Chart= BASE_URL+"charts/"; // post/ get,put,delete
    public static final String BASE_URL_DeleteChartALL= BASE_URL+"charts/all";

    public static final String BASE_URL_IMAGE = BASE_URL+"file/img/";


    public static final String fileKey = "com.harloom.cabook.loginLog";


}