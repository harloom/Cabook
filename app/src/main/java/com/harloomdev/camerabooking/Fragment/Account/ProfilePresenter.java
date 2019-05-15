package com.harloomdev.camerabooking.Fragment.Account;

import android.content.Context;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.Profile.Profile;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;
import com.harloomdev.camerabooking.Utils.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter implements IProfilePresenter {
    private Context context;
    private IProfileView mIProfileView ;

    public ProfilePresenter(Context context, IProfileView mIProfileView) {
        this.context = context;
        this.mIProfileView = mIProfileView;
    }

    @Override
    public void getAPIData(String id_ktp) {
        TaskServiceAPI mTaskServiceAPI = APIClient.createService().create(TaskServiceAPI.class);
        Call<Profile> mCall = mTaskServiceAPI.getProfile(id_ktp);
        mCall.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.isSuccessful()){
                    mIProfileView.onGetResourceSuccess(response.body());
                }else{
                    ResponOther mResponOther = ErrorAPIUtils.parseError(response);
                    mIProfileView.onAPIError(mResponOther);
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                mIProfileView.onGetResourceError(t.getMessage());
            }
        });
    }

    @Override
    public void Logout() {
        Preferences mPreferences = new Preferences(context);
        mPreferences.logout();
        mIProfileView.callbackLogout(true);
    }
}
