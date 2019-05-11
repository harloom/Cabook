package com.harloomdev.camerabooking.Activity.Login;

import com.harloomdev.camerabooking.Http.conf.API.KeyAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

public interface IloginView {

    void onLoginSuccess(KeyAPI respon);
    void onRLoginError(String massage);
    void onAPIError(ResponOther error);

}