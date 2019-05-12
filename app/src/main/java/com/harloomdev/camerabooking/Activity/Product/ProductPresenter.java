package com.harloomdev.camerabooking.Activity.Product;

import android.content.Context;
import android.util.Log;

import com.harloomdev.camerabooking.Activity.Chart.PutChart;
import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Recordset_;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPresenter  implements  IProductPresenter{
    private Context context;
    private IProductView  mIProductView;
    private static final String  TAG="Product Presenter";
    public ProductPresenter(Context context, IProductView mIProductView) {
        this.context = context;
        this.mIProductView = mIProductView;
        taskServiceAPI = APIClient.createService().create(TaskServiceAPI.class);
    }

    //api
    TaskServiceAPI taskServiceAPI;

    @Override
    public void getDataAPI() {
        Call<List<Products>> listCall = taskServiceAPI.getProducts();
        listCall.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, response.body().toString());
                    mIProductView.onAPISucces(response.body());
                }else{
                    ResponOther error = ErrorAPIUtils.parseError(response);
                    mIProductView.onAPIError(error);
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                    mIProductView.onSystemError(t.getMessage());
            }
        });
    }

    @Override
    public void getDataAPIChart(String id_ktp,String key) {
        Call<Chart> call =  taskServiceAPI.getChart(id_ktp,key);
        call.enqueue(new Callback<Chart>() {
            @Override
            public void onResponse(Call<Chart> call, Response<Chart> response) {
                if(response.isSuccessful()){
                    mIProductView.onGetChart(response.body());
                }else{
                    ResponOther mResponOther = ErrorAPIUtils.parseError(response);
                    mIProductView.onAPIError(mResponOther);
                }
            }

            @Override
            public void onFailure(Call<Chart> call, Throwable t) {
                mIProductView.onSystemError(t.getMessage());
            }
        });
    }

    @Override
    public void postData(PutChart putChart) {
        Call<List<Recordset_>> call =taskServiceAPI.postChart(putChart.getKey(),putChart.getId_kamera(),
                putChart.getIdKtp(),putChart.getJumlah(),putChart.getService());
        call.enqueue(new Callback<List<Recordset_>>() {
            @Override
            public void onResponse(Call<List<Recordset_>> call, Response<List<Recordset_>> response) {
                if(response.isSuccessful()){
                    mIProductView.onSuccesResponChart(response.body());
                }else{
                    ResponOther mResponOther = ErrorAPIUtils.parseError(response);
                    mIProductView.onAPIError(mResponOther);
                }
            }

            @Override
            public void onFailure(Call<List<Recordset_>> call, Throwable t) {
                mIProductView.onSystemError(t.getMessage());
            }
        });

    }
}
