package com.harloomdev.camerabooking.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.harloomdev.camerabooking.Activity.Adapter.ChartAdpater;
import com.harloomdev.camerabooking.Activity.Adapter.OnChartClickListener;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Recordset;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Recordset_;
import com.harloomdev.camerabooking.R;

import java.util.ArrayList;
import java.util.List;

public class CekAcivity extends AppCompatActivity  implements OnChartClickListener {
    private RecyclerView recyclerView ;
    private ChartAdpater chartAdpater ;
//    private ArrayList<Chart> charts = new ArrayList<>();
    private Chart chart  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_acivity);
        initUI();
        initRecyview();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void initUI(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recy_chart) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
    }

    private void getData(){
        Recordset_ recordset1 = new Recordset_("1232131312312","C0001","Cannon",100000,1,"unit",R.drawable.image1,"Ilham",100000);
        Recordset_ recordset2 = new Recordset_("1232131312312","C0002","Cannon 1",200000,1,"unit",R.drawable.image1,"Ilham",200000);
        ArrayList<Recordset_> recordsets = new ArrayList<>();
        recordsets.add(recordset1);
        recordsets.add(recordset2);
         chart = new Chart(null,recordsets,null,null,0,300000);

    }

    private void initRecyview(){
        getData();
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        chartAdpater = new ChartAdpater(this,chart,this);
        recyclerView.setAdapter(chartAdpater);


    }
    Integer jumlah_awal = 0 ;
    @Override
    public void onButtonPlush(int position) {
        jumlah_awal  = chart.getRecordset().get(position).getJumlahPinjam();
        jumlah_awal += 1;
        chart.getRecordset().get(position).setJumlahPinjam(jumlah_awal);
        chartAdpater.notifyDataSetChanged();

    }

    @Override
    public void onButtonMinus(int position) {
        jumlah_awal  = chart.getRecordset().get(position).getJumlahPinjam();
        jumlah_awal -= 1;
        chart.getRecordset().get(position).setJumlahPinjam(jumlah_awal);
        chartAdpater.notifyDataSetChanged();
    }
}
