package com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.ViewKwitansi;
import com.harloomdev.camerabooking.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderAdapter  extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private Context context ;
    private ArrayList<ViewKwitansi>  mViewKwitansis = new ArrayList<>();
    private OnOrderClickListener mOnOrderClickListener ;
    OrderProduct mOrderProductAdapater ;
    public OrderAdapter(Context context, ArrayList<ViewKwitansi> mViewKwitansis, OnOrderClickListener mOnOrderClickListener) {
        this.context = context;
        this.mViewKwitansis = mViewKwitansis;
        this.mOnOrderClickListener = mOnOrderClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcy_orders,parent,false  );
        return new ViewHolder(view,mOnOrderClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        ViewKwitansi mKwitansi = mViewKwitansis.get(i);
        mOrderProductAdapater = new OrderProduct(mViewKwitansis.get(i).getDetail(),context);
        holder.mRecyleOrderBarang.setAdapter(mOrderProductAdapater);
        mOrderProductAdapater.notifyDataSetChanged();


        holder.v_ctxtTotal.setText("Arigataou :D");


    }

    @Override
    public int getItemCount() {
        return null!=mViewKwitansis?mViewKwitansis.size():0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {


        //title
        TextView v_ttgl,v_ttglEx;
        TextView v_tnoKwitansi,v_tnamaOrder,v_talamatAntar,v_tjenisService;
        TextView v_ttxtTotal;

        //content
        TextView v_ctgl,v_ctglEx;
        TextView v_cnoKwitansi,v_cnamaOrder,v_calamatAntar,v_cjenisService;
        TextView v_ctxtTotal;
        TextView v_ctxtTotalBayar;
        Button v_btnCancelOrder ;

        //recyviewOrderBrang
        RecyclerView mRecyleOrderBarang;


        FoldingCell foldingCell ;
        OnOrderClickListener onOrderClickListener;
        LinearLayout mFctitle , mFcContent;


        public ViewHolder(@NonNull View itemV, OnOrderClickListener mOnOrderClickListener) {
            super(itemV);
            onOrderClickListener = mOnOrderClickListener;
            foldingCell = itemV.findViewById(R.id.folding_cell);
            mFcContent = itemV.findViewById(R.id.cell_content);
            mFctitle = itemV.findViewById(R.id.cell_title_view);


            //title
            v_ttgl = itemV.findViewById(R.id.txtTitleTanggal);
            v_ttglEx = itemV.findViewById(R.id.txtTitleTanggalEx);
            v_tnoKwitansi = itemV.findViewById(R.id.txt_kwitansi);
            v_tnamaOrder =  itemV.findViewById(R.id.txtNamaOrder);
            v_talamatAntar = itemV.findViewById(R.id.txtAlamatAntar);
            v_tjenisService = itemV.findViewById(R.id.txt_jenisService);
            v_ttxtTotal = itemV.findViewById(R.id.txtTotal);

            //content
            v_ctgl = itemV.findViewById(R.id.ctanggal);
            v_ctglEx = itemV.findViewById(R.id.ctanggalEx);
            v_cnoKwitansi = itemV.findViewById(R.id.ctxt_kwitansi);
            v_cnamaOrder = itemV.findViewById(R.id.ctxtNamaOrder);
            v_calamatAntar = itemV.findViewById(R.id.ctxtAlamatAntar);
            v_ctxtTotal = itemV.findViewById(R.id.ctxtTotal);
            v_ctxtTotalBayar = itemV.findViewById(R.id.ctxtTotalBayar);
            v_btnCancelOrder = itemV.findViewById(R.id.cbtn_cancelOrder);
            mRecyleOrderBarang = itemV.findViewById(R.id.recyleOrderBarang);

            //function
            v_btnCancelOrder.setOnClickListener(cancelOrder);
            mFcContent.setOnClickListener(folding);
            mFctitle.setOnClickListener(folding);


            //recy
            LinearLayoutManager manager = new LinearLayoutManager(context);
            mRecyleOrderBarang.setLayoutManager(manager);

        }

        View.OnClickListener cancelOrder = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOrderClickListener.onCancel(getAdapterPosition());
            }
        };

        View.OnClickListener folding = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOrderClickListener.foldingTutup(getAdapterPosition(),foldingCell);
            }
        };
    }
}
