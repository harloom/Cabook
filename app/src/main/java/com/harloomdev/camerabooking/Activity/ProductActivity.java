package com.harloomdev.camerabooking.Activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Adapter.OnProductClickListener;
import com.harloomdev.camerabooking.Activity.Adapter.ProductAdpater;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProductActivity extends AppCompatActivity implements OnProductClickListener{
    private Context context   = this;
    private RecyclerView mRecyclerView ;
    private ArrayList<Products> mArray  = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recy_products);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        initRecyleView();

    }

    private void getData(){
        Products product1 = new Products("C0001","Cannon",123000,10,R.drawable.image1,"Unit");
        Products product2 = new Products("C0002","Cannon C2",223000,10,R.drawable.image1,"Unit");
        Products product3 = new Products("C0003","Cannon C3",323000,10,R.drawable.image1,"Unit");
        mArray.add(product1);
        mArray.add(product2);
        mArray.add(product3);


    }

    private void initRecyleView(){
        getData();
        GridLayoutManager gridLayoutManager  = new GridLayoutManager(context, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        ProductAdpater mAdapter = new ProductAdpater(context,mArray,this);
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
}
