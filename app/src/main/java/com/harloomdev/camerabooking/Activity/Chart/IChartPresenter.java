package com.harloomdev.camerabooking.Activity.Chart;

import android.text.TextWatcher;
import android.widget.EditText;

public interface IChartPresenter {
    void getChart(String id_ktp,String key);
    void putEdit(PutChart putChart , int _lama);
    void getService();
}
