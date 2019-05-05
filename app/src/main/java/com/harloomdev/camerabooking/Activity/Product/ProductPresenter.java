package com.harloomdev.camerabooking.Activity.Product;

import android.content.Context;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
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

    public ProductPresenter(Context context, IProductView mIProductView) {
        this.context = context;
        this.mIProductView = mIProductView;
    }



    @Override
    public void getDataAPI() {
        TaskServiceAPI taskServiceAPI = APIClient.createService().create(TaskServiceAPI.class);
        Call<List<Products>> listCall = taskServiceAPI.getProducts();
        listCall.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if(response.isSuccessful()){
                    mIProductView.onGetResourceSuccess(response.body());
                }else{
                    ResponOther error = ErrorAPIUtils.parseError(response);
                    mIProductView.onAPIError(error);
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                    mIProductView.onGetResourceError(t.getMessage());
            }
        });
    }
}
