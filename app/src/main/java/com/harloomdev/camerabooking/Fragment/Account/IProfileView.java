package com.harloomdev.camerabooking.Fragment.Account;

import com.harloomdev.camerabooking.Http.conf.API.Model.Profile.Profile;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

public interface IProfileView {
    void onGetResourceSuccess(Profile data);
    void onGetResourceError(String massage);
    void onAPIError(ResponOther error);
}
