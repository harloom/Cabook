package com.harloomdev.camerabooking.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.harloomdev.camerabooking.Activity.Chart.ServiceChart;
import com.harloomdev.camerabooking.R;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends BaseAdapter {
    private Context context =null;
    private List<ServiceChart> mlList = new ArrayList<>();
    private LayoutInflater inflater =null;

    public ServiceAdapter(Context context, List<ServiceChart> mlList) {
        this.context = context;
        this.mlList = mlList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlList!=null?mlList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mlList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_service,null);
        TextView _txtMap = convertView.findViewById(R.id.textMapView);
        _txtMap.setText(mlList.get(position).getNamaPelayanan());

        return convertView;
    }
}
