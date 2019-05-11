package com.harloomdev.camerabooking.Activity.Chart;

import android.content.Context;
import android.util.Log;

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
    public void putEdit(PutChart putChart,int _lama) {
        Call<Chart> call = taskServiceAPI.editChart(putChart.getKey(),putChart.getId_kamera(),putChart.getIdKtp(),
                            putChart.getJumlah(),putChart.getService(),_lama);
        Log.d("Jumlah Data " ,putChart.getJumlah());
        call.enqueue(new Callback<Chart>() {
            @Override
            public void onResponse(Call<Chart> call, Response<Chart> response) {
                if(response.isSuccessful()){
                    iCekView.onEditSucces(response.body());
                }else{
                    ResponOther mError = ErrorAPIUtils.parseError(response);
                    iCekView.onEditRequestError(mError);
                }
            }
            @Override
            public void onFailure(Call<Chart> call, Throwable t) {
                iCekView.onSystemError("Put : "+t.getMessage());
            }
        });

    }

    @Override
    public void getService() {
        Call<List<ServiceChart>> call = taskServiceAPI.getService();
        call.enqueue(new Callback<List<ServiceChart>>() {
            @Override
            public void onResponse(Call<List<ServiceChart>> call, Response<List<ServiceChart>> response) {
                if(response.isSuccessful()){
                    iCekView.onGetServiceSuccess(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<ServiceChart>> call, Throwable t) {
                    iCekView.onGetResourceError(t.getMessage());
            }
        });
    }
}
