package com.harloomdev.camerabooking.Activity.Product;

import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Recordset_;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

import java.util.List;

public interface IProductView {
    void onAPISucces(List<Products> products);
    void onSystemError(String massage);
    void onAPIError(ResponOther error);


    void onGetChart(Chart charts);
    void onSuccesResponChart(List<Recordset_> list);
}
