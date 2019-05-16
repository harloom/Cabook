package com.harloomdev.camerabooking.Activity.History;

import android.content.Context;


import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryPresenter implements IHistoryPresenter {
    private Context context;
    private IHistoryView mView;
    private TaskServiceAPI api;

    public HistoryPresenter(Context context, IHistoryView mView) {
        this.context = context;
        this.mView = mView;
        api = APIClient.createService().create(TaskServiceAPI.class);
    }

    @Override
    public void getDataAPI(String key,String _idKTP) {
        Call<List<History>> call = api.getHistory(key,_idKTP);
        call.enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                if(response.isSuccessful()){
                    mView.OnAPISuccess(response.body());
                }else{
                    ResponOther mResponOther = ErrorAPIUtils.parseError(response);
                    mView.OnAPIFailed(mResponOther);
                }
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {
                    mView.OnSystemErrors(t.getMessage());
            }
        });
    }
}
