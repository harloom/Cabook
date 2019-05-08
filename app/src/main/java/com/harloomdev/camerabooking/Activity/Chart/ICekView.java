package com.harloomdev.camerabooking.Activity.Chart;

import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

import java.util.List;

public interface ICekView {
    void onGetResourceSuccess(Chart charts);
    void onGetResourceError(String massage);
    void onAPIError(ResponOther error);

    void onEditSucces(Chart chart);
    void onEditRequestError(ResponOther responOther);
    void onSystemError(String massage);

}
