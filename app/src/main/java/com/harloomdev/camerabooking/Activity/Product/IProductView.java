package com.harloomdev.camerabooking.Activity.Product;

import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

import java.util.List;

public interface IProductView {
    void onGetResourceSuccess(List<Products> products);
    void onGetResourceError(String massage);
    void onAPIError(ResponOther error);

}
