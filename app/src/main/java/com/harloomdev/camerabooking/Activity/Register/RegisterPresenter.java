package com.harloomdev.camerabooking.Activity.Register;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Utils.ErrorAPIUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements IRegisterPresenter {
    IRegisterView iRegisterView;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
    }


    @Override
    public void attempRegistrasi(SignUp signUp) {

        if(signUp.validConfimPassword(signUp.getPassword(),signUp.getConfimPassword())){
            sentAPI(signUp);
        }else{
            iRegisterView.onRegisterError("Other Password don't Match");
        }


    }

    private void sentAPI(SignUp signUp){

        TaskServiceAPI taskServiceAPI = APIClient.createService().create(TaskServiceAPI.class);
        Call<ResponOther> call = taskServiceAPI.postSignUp(signUp.getIdktp(), signUp.getNama(), signUp.getAlamat(),
                signUp.getNoHandphone(), signUp.getPekerjaan(), signUp.getJenis_kelamin(), signUp.getTanggal_lahir(),
                signUp.getKota(), signUp.getPassword());
        call.enqueue(new Callback<ResponOther>() {
            @Override
            public void onResponse(Call<ResponOther> call, Response<ResponOther> response) {
                if(response.isSuccessful()){
                    iRegisterView.onRegisterSuccess(response.body());
                }else{
                    ResponOther error = ErrorAPIUtils.parseError(response);
                    iRegisterView.onAPIError(error);
                }

            }

            @Override
            public void onFailure(Call<ResponOther> call, Throwable t) {
                    iRegisterView.onRegisterError(t.getMessage());
            }
        });
    }

}




