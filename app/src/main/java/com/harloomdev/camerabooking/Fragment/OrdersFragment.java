package com.harloomdev.camerabooking.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders.OnOrderClickListener;
import com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders.OrderAdapter;
import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.ViewKwitansi;
import com.harloomdev.camerabooking.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import  com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.Detail;

public class OrdersFragment extends Fragment implements OnOrderClickListener {
    private static final String TAG = "OrdersFragment";
    private TextView mTextMessage;
    private RecyclerView mRecyclerView;
    private OrderAdapter mOrderAdapter;
    private ArrayList<ViewKwitansi> mViewKwitansis = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.f_orders,container,false
        );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextMessage = (TextView) view.findViewById(R.id.message);
        mTextMessage.setText(R.string.title_orders);
        initRecyleview(view);

    }

    private void getData(){
        ArrayList<Detail> mDetails = new ArrayList<>() ;
        Detail detail1 = new Detail("K0000012","C0001","Cannon",20000,
                1,0.1,20000,2000,22000,R.drawable.image1,"unit");
        mDetails.add(detail1);
        ViewKwitansi  mKwitansi = new ViewKwitansi("2018-01-01","2018-02-01","19201219",
                "Ilham","Antar","K0000012",2,"Pinjam","kedaton"
                ,mDetails
        );
        ViewKwitansi  mKwitansi1 = new ViewKwitansi("2018-01-01","2018-02-01","19201219",
                "Ilham","Antar","K0000013",2,"Pinjam","kedaton"
                ,mDetails
        );
        mViewKwitansis.add(mKwitansi);
        mViewKwitansis.add(mKwitansi1);
    }

    private void getDataFromAPI(String _keyAPI,String _param){
        Map<String , String > map  = new HashMap<>();
        map.put("Content-Type","pplication/json");
        map.put("key_api" , _keyAPI);
        TaskServiceAPI taskServiceAPI = APIClient.createService().create(TaskServiceAPI.class);
        Call<ArrayList<ViewKwitansi>> call = taskServiceAPI.getViewKwitansi(map,_param);
        call.enqueue(new Callback<ArrayList<ViewKwitansi>>() {
            @Override
            public void onResponse(Call<ArrayList<ViewKwitansi>> call, Response<ArrayList<ViewKwitansi>> response) {
                if(response.code() == 200){

                }

            }

            @Override
            public void onFailure(Call<ArrayList<ViewKwitansi>> call, Throwable t) {
                Toast.makeText(getContext(), "Error : " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyleview(View view){
        getData();
        mRecyclerView =  view.findViewById(R.id.recy_fOrder);
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        mOrderAdapter  = new OrderAdapter(this.getContext(),mViewKwitansis,this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mOrderAdapter);
        mOrderAdapter.notifyDataSetChanged();

    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCancel(int position) {
        Toast.makeText(getContext(), mViewKwitansis.get(position).getNoKwitansi(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void foldingTutup(int position, FoldingCell foldingCell) {
        foldingCell.toggle(false);
    }
}
