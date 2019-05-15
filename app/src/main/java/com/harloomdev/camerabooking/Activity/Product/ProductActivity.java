package com.harloomdev.camerabooking.Activity.Product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.harloomdev.camerabooking.Activity.Adapter.OnProductClickListener;
import com.harloomdev.camerabooking.Activity.Adapter.ProductAdpater;
import com.harloomdev.camerabooking.Activity.Chart.CekAcivity;
import com.harloomdev.camerabooking.Activity.Chart.PutChart;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Recordset_;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.MainActivity;
import com.harloomdev.camerabooking.R;
import com.harloomdev.camerabooking.Utils.Preferences;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductActivity extends AppCompatActivity implements IProductView, OnProductClickListener ,View.OnClickListener {
    private Context context   = this;
    private RecyclerView mRecyclerView ;
    private ArrayList<Products> mArray  = new ArrayList<>();
    ProductAdpater mAdapter ;
    //Products Presentear
    ProductPresenter productPresenter;
    private  Preferences  mPreferences;
    private Integer itemSize = 0 ;

//    UI
    ExtendedFloatingActionButton mFloatingChart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        productPresenter = new ProductPresenter(this,this);
        mPreferences = new Preferences(context);
        productPresenter.getDataAPIChart(mPreferences.getIDKTP(),mPreferences.getKeyAPI());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recy_products);
        mFloatingChart = (ExtendedFloatingActionButton) findViewById(R.id.floating_chart);
        mFloatingChart.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        productPresenter.getDataAPI();


    }

    @Override
    protected void onResume() {
        super.onResume();
        productPresenter.getDataAPIChart(mPreferences.getIDKTP(),mPreferences.getKeyAPI());
    }

    private void initRecyleView(){
        GridLayoutManager gridLayoutManager  = new GridLayoutManager(context, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new ProductAdpater(context,mArray,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void send(final PutChart putChart) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                productPresenter.postData(putChart);
            }
        }, 500);

    }

    @Override
    public void onButtonOrderClick(int position) {
        Products mProducts = mArray.get(position);
        PutChart mdata = new PutChart(mPreferences.getKeyAPI(),mPreferences.getIDKTP(),mProducts.getIdKamera(),
                "1","S0001");
        send(mdata);
        Toast.makeText(context,mProducts.getNamaKamera(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this,MainActivity.class).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
        ));
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
        ));
        finish();
    }

    @Override
    public void onAPISucces(List<Products> products) {
        mArray.addAll(products);
        initRecyleView();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onSystemError(String massage) {
        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAPIError(ResponOther error) {
        Toast.makeText(context, error.getStatusCode() + " : " + error.getMassage(), Toast.LENGTH_SHORT).show();
            mFloatingChart.setVisibility(View.GONE);

    }

    @Override
    public void onGetChart(Chart charts) {
        itemSize = charts.getRecordset().size();
        setLabelChart(itemSize);
    }

    @Override
    public void onSuccesResponChart(List<Recordset_> list) {
        itemSize = list.size();
        setLabelChart(itemSize);
    }

    private void setLabelChart(int itemSize){
        if(itemSize>0) {
            mFloatingChart.setVisibility(View.VISIBLE);
            mFloatingChart.setText(itemSize + " Item");
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(context,CekAcivity.class));
    }
}
