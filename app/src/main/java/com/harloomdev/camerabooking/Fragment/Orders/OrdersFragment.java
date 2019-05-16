package com.harloomdev.camerabooking.Fragment.Orders;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders.OnOrderClickListener;
import com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders.OrderAdapter;
import com.harloomdev.camerabooking.Activity.History.HistoryActivity;
import com.harloomdev.camerabooking.Http.conf.API.Client.APIClient;
import com.harloomdev.camerabooking.Http.conf.API.Interfaces.TaskServiceAPI;
import com.harloomdev.camerabooking.Http.conf.API.Model.ResponErrors.ResponOther;
import com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.ViewKwitansi;
import com.harloomdev.camerabooking.R;
import com.harloomdev.camerabooking.Utils.Preferences;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import  com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.Detail;

        public class OrdersFragment extends Fragment implements OnOrderClickListener , IOrdersView {
    private static final String TAG = "OrdersFragment";
    private TextView mTextMessage;
    private ImageView btnHistory;
    private RecyclerView mRecyclerView;
    private OrderAdapter mOrderAdapter;
    private ArrayList<ViewKwitansi> mViewKwitansis = new ArrayList<>();
    private Preferences preferences ;

            //adapter presenter
    private Context context = null;
    private OrdersPresenter presenter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.f_orders,container,false
        );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();
        mTextMessage = (TextView) view.findViewById(R.id.message);
        mTextMessage.setText(R.string.title_orders);
        btnHistory = (ImageView) view.findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,HistoryActivity.class));
            }
        });
        mRecyclerView =  view.findViewById(R.id.recy_fOrder);
        presenter  = new OrdersPresenter(context,this);
         preferences = new Preferences(context);
        presenter.sendData(preferences.getKeyAPI(),preferences.getIDKTP());


    }



    private void initRecyleview(){
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
    public void onCancel(final int position) {
        new AlertDialog.Builder(context).setTitle("Konfirmasi?").setCancelable(false).setMessage("Apakah Benar Ingin Membatlakan Pesanan \n"+
        "No Kwitansi : " + mViewKwitansis.get(position).getNoKwitansi()).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.cancelOrder(preferences.getKeyAPI(),preferences.getIDKTP(),mViewKwitansis.get(position).getNoKwitansi());
            }
        }).create().show();


    }

    @Override
    public void foldingTutup(int position, FoldingCell foldingCell) {
        foldingCell.toggle(false);
    }


    @Override
    public void onGetResourceSuccess(ArrayList<ViewKwitansi> _kwitansi) {
        mViewKwitansis.clear();
        mViewKwitansis.addAll(_kwitansi);
        initRecyleview();
    }

    @Override
    public void onGetResourceError(String massage) {
        if(context==null){return;}
        Toast.makeText(context, "Error : "+ massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAPIError(ResponOther error) {
        if(context==null){return;}
        Toast.makeText(context, error.getStatusCode() +" : "+ error.getMassage(), Toast.LENGTH_SHORT).show();
        if(error.getStatusCode().equals(404)){
            mViewKwitansis.clear();
            if(mOrderAdapter != null){
                mOrderAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onCancelOrderSuccess(ResponOther respon) {
            presenter.sendData(preferences.getKeyAPI(),preferences.getIDKTP());

    }
}
