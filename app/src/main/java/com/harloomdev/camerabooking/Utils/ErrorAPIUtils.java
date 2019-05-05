package com.harloomdev.camerabooking.Utils;

import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorAPIUtils {
    public  static ResponOther parseError(Response<?> response){
        Converter<ResponseBody  , ResponOther> converter =
                APIClient.createService().responseBodyConverter(ResponOther.class, new Annotation[0]);

        ResponOther error ;
        try {
            assert response.errorBody() != null;
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return  new ResponOther();
        }

        return error;
    }
}
