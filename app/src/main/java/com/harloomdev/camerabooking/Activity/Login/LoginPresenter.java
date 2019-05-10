package com.harloomdev.camerabooking.Activity.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.KeyAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Http.conf.Server;
import com.harloomdev.camerabooking.LoginActivity;
import com.harloomdev.camerabooking.R;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;
import com.harloomdev.camerabooking.Utils.Preferences;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements IloginPresenter {
    private IloginView iloginView ;
    private Context context;


    public LoginPresenter(IloginView iloginView, Context context) {
        this.iloginView = iloginView;
        this.context = context;
    }

    @Override
    public void sendAPI(final Mlogin mlogin){
        final Preferences preferences = new Preferences(context);

        TaskServiceAPI taskServiceAPILogin = APIClient.createService().create(TaskServiceAPI.class);
        Call<KeyAPI> call = taskServiceAPILogin.postLogin(mlogin.getId_ktp(), mlogin.getPassword());
        call.enqueue(new Callback<KeyAPI>() {
            @Override
            public void onResponse(@NonNull Call<KeyAPI> call, @NonNull Response<KeyAPI> response) {
                if (response.code() == 200) {
                    iloginView.onLoginSuccess(response.body());
//                    prEditor.putString("id_ktp",mlogin.getId_ktp());
//                    prEditor.putString("key_api",response.body().getKeyAPI().toString());
//                    prEditor.apply();

                        preferences.saveIdKTP(mlogin.getId_ktp());
                        preferences.savekeyAPI(response.body().getKeyAPI().toString());
                        preferences.saveStatus(true);


                } else {
                    ResponOther error = ErrorAPIUtils.parseError(response);
                    iloginView.onAPIError(error);

                }


            }

            @Override
            public void onFailure(Call<KeyAPI> call, Throwable t) {
                    iloginView.onRLoginError(t.getMessage());
            }
        });

    }
}
