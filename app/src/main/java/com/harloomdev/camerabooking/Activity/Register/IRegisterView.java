package com.harloomdev.camerabooking.Activity.Register;

import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

public interface IRegisterView {

    void onRegisterSuccess(ResponOther respon);
    void onRegisterError(String massage);
    void onAPIError(ResponOther error);

}
