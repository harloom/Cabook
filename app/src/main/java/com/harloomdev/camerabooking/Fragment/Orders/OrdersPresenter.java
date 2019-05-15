package com.harloomdev.camerabooking.Fragment.Orders;

import android.content.Context;
import android.widget.Toast;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.ViewKwitansi;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersPresenter  implements IOrdersPresenter{
    private Context context =null;
    private IOrdersView iOrdersView;
    private TaskServiceAPI api;

    public OrdersPresenter(Context context, IOrdersView iOrdersView) {
        this.context = context;
        this.iOrdersView = iOrdersView;
        this.api = APIClient.createService().create(TaskServiceAPI.class);
    }

    @Override
    public void sendData(String _keyAPI,String _param) {
        Map<String , String > map  = new HashMap<>();
        map.put("Content-Type","pplication/json");
        map.put("key_api" , _keyAPI);
        Call<ArrayList<ViewKwitansi>> call = api.getViewKwitansi(map,_param);
        call.enqueue(new Callback<ArrayList<ViewKwitansi>>() {
            @Override
            public void onResponse(Call<ArrayList<ViewKwitansi>> call, Response<ArrayList<ViewKwitansi>> response) {
                if(response.code() == 200){
                    iOrdersView.onGetResourceSuccess(response.body());
                }else{
                    ResponOther responOther = ErrorAPIUtils.parseError(response);
                    iOrdersView.onAPIError(responOther);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<ViewKwitansi>> call, Throwable t) {
                iOrdersView.onGetResourceError(t.getMessage());
            }
        });
    }

    @Override
    public void cancelOrder(String key, String id_ktp,String no_kwitansi) {
        Call<ResponOther> call = api.cancelOrder(key,id_ktp,no_kwitansi);
        call.enqueue(new Callback<ResponOther>() {
            @Override
            public void onResponse(Call<ResponOther> call, Response<ResponOther> response) {
                if(response.isSuccessful()){
                    iOrdersView.onCancelOrderSuccess(response.body());
                }else{
                    iOrdersView.onAPIError(response.body());
                }

            }

            @Override
            public void onFailure(Call<ResponOther> call, Throwable t) {
                    iOrdersView.onGetResourceError(t.getMessage());
            }
        });

    }
}
