package com.harloomdev.camerabooking.Activity.Product;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Adapter.OnProductClickListener;
import com.harloomdev.camerabooking.Activity.Adapter.ProductAdpater;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductActivity extends AppCompatActivity implements IProductView, OnProductClickListener{
    private Context context   = this;
    private RecyclerView mRecyclerView ;
    private ArrayList<Products> mArray  = new ArrayList<>();
    ProductAdpater mAdapter ;
    //Products Presentear
    ProductPresenter productPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        productPresenter = new ProductPresenter(this,this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recy_products);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        productPresenter.getDataAPI();

    }



    private void initRecyleView(){

        GridLayoutManager gridLayoutManager  = new GridLayoutManager(context, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new ProductAdpater(context,mArray,this);
        mRecyclerView.setAdapter(mAdapter);




    }



    @Override
    public void onButtonOrderClick(int position) {
        Toast.makeText(context, mArray.get(position).getNamaKamera(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onGetResourceSuccess(List<Products> products) {
        mArray.addAll(products);
        initRecyleView();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onGetResourceError(String massage) {
        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAPIError(ResponOther error) {
        Toast.makeText(context, error.getStatusCode() + " : " + error.getMassage(), Toast.LENGTH_SHORT).show();
    }
}
