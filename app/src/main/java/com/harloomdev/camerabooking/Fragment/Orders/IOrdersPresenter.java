package com.harloomdev.camerabooking.Fragment.Orders;

public interface IOrdersPresenter {
    void sendData(String _keyAPI,String _param);

    void cancelOrder(String key,String id_ktp,String no_kwitansi);
}
