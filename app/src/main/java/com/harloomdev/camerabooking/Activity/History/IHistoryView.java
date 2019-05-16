package com.harloomdev.camerabooking.Activity.History;

import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;

import java.util.List;

public interface IHistoryView {
    void OnAPISuccess(List<History> mList);
    void OnAPIFailed(ResponOther respon);
    void OnSystemErrors(String massage);
}
