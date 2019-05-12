package com.harloomdev.camerabooking.Activity.Product;

import com.harloomdev.camerabooking.Activity.Chart.PutChart;

public interface IProductPresenter  {
    void getDataAPI();
    void getDataAPIChart(String id_ktp,String key);
    void postData(PutChart putChart);
}
