package com.harloomdev.camerabooking.Activity.Chart;

import android.content.Context;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartPresenter implements  IChartPresenter {
    private Context context;
    private ICekView  iCekView;
    private TaskServiceAPI taskServiceAPI;

    public ChartPresenter(Context context, ICekView iCekView) {
        this.context = context;
        this.iCekView = iCekView;
        taskServiceAPI = APIClient.createService().create(TaskServiceAPI.class);
    }

    @Override
    public void getChart(String id_ktp, String key) {
        Call<Chart> call =  taskServiceAPI.getChart(id_ktp,key);
        call.enqueue(new Callback<Chart>() {
            @Override
            public void onResponse(Call<Chart> call, Response<Chart> response) {
                if(response.isSuccessful()){
                    iCekView.onGetResourceSuccess(response.body());
                }else{
                    ResponOther mResponOther = ErrorAPIUtils.parseError(response);
                    iCekView.onAPIError(mResponOther);
                }
            }

            @Override
            public void onFailure(Call<Chart> call, Throwable t) {
                    iCekView.onGetResourceError(t.getMessage());
            }
        });
    }

    @Override
    public void putEdit(PutChart putChart) {
        Call<Chart> call = taskServiceAPI.editChart(putChart.getKey(),putChart.getId_kamera(),putChart.getIdKtp(),
                            putChart.getJumlah());
        call.enqueue(new Callback<Chart>() {
            @Override
            public void onResponse(Call<Chart> call, Response<Chart> response) {
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<Chart> call, Throwable t) {

            }
        });

    }
}
