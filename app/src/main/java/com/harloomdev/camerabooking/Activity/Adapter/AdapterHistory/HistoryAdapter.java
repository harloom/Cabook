package com.harloomdev.camerabooking.Activity.Adapter.AdapterHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders.OnOrderClickListener;
import com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders.OrderProduct;
import com.harloomdev.camerabooking.Activity.History.Detail;
import com.harloomdev.camerabooking.Activity.History.History;

import com.harloomdev.camerabooking.R;
import com.ramotion.foldingcell.FoldingCell;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context ;
    private List<History>  histories  = new ArrayList<>();
    private OnHistoryrClickListener mOnHistoryrClickListener ;
    HistoryProduct mHistoryProduct ;
    public HistoryAdapter(Context context, List<History> list, OnHistoryrClickListener mOnHistoryrClickListener) {
        this.context = context;
        this.histories = list;
        this.mOnHistoryrClickListener = mOnHistoryrClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcy_hisotry,parent,false  );
        return new ViewHolder(view,mOnHistoryrClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        History mHistory = histories.get(i);
        mHistoryProduct = new HistoryProduct(mHistory.getDetail(),context);
        holder.mRecyleOrderBarang.setAdapter(mHistoryProduct);
        mHistoryProduct.notifyDataSetChanged();

        holder.v_ttgl.setText(parseDate(mHistory.getTanggal()));
        holder.v_ttglEx.setText(parseDate(mHistory.getTanggalExpire()));
        holder.v_tnoKwitansi.setText(mHistory.getNoKwitansi());
        holder.v_tnamaOrder.setText(mHistory.getNama());
        holder.v_talamatAntar.setText(mHistory.getAlamatAntar());
        holder.v_tjenisService.setText(mHistory.getNamaPelayanan());
        holder.v_ttxtTotal.setText("Rp. "+hitungTotal(mHistory.getDetail()));
        holder.v_ctxtTotal.setText("Arigataou :D");

        holder.v_ctgl.setText(parseDate(mHistory.getTanggal()));
        holder.v_ctglEx.setText(parseDate(mHistory.getTanggalExpire()));
        holder.v_cnoKwitansi.setText(mHistory.getNoKwitansi());
        holder.v_cnamaOrder.setText(mHistory.getNama());
        holder.v_calamatAntar.setText(mHistory.getAlamatAntar());
        holder.v_cjenisService.setText(mHistory.getNamaPelayanan());
        holder.v_ctxtTotal.setText("Rp. "+hitungTotal(mHistory.getDetail()));



    }
    private Integer hitungTotal(List<Detail> details){
        int jumlahtotal = 0;
        for (Detail mdetail: details
             ) {
            jumlahtotal+=mdetail.getTotalBayar();
        }
        return jumlahtotal;
    }

    @Override
    public int getItemCount() {
        return null!=histories?histories.size():0;
    }

    private String parseDate(String tanggal)
    {
   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date date = null;
        try {
             date = sdf.parse(tanggal);
          
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
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



        //recyviewOrderBrang
        RecyclerView mRecyleOrderBarang;


        FoldingCell foldingCell ;
        OnHistoryrClickListener mOnHistoryrClickListener;
        LinearLayout mFctitle , mFcContent;


        public ViewHolder(@NonNull View itemV, OnHistoryrClickListener clickListener) {
            super(itemV);
            mOnHistoryrClickListener = clickListener;
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

            v_cjenisService = itemV.findViewById(R.id.ctxt_jenisService);
            mRecyleOrderBarang = itemV.findViewById(R.id.recyleOrderBarang);

            //function

            mFcContent.setOnClickListener(folding);
            mFctitle.setOnClickListener(folding);


            //recy
            LinearLayoutManager manager = new LinearLayoutManager(context);
            mRecyleOrderBarang.setLayoutManager(manager);

        }


        View.OnClickListener folding = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnHistoryrClickListener.foldingTutup(getAdapterPosition(),foldingCell);
            }
        };
    }
}
