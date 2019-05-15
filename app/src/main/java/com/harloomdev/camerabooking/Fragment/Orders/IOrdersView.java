package com.harloomdev.camerabooking.Fragment.Orders;

import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.ViewKwitansi;

import java.util.ArrayList;

public interface IOrdersView {
    void onGetResourceSuccess(ArrayList<ViewKwitansi> _kwitansi);
    void onGetResourceError(String massage);
    void onAPIError(ResponOther error);

    void onCancelOrderSuccess(ResponOther respon);

}
