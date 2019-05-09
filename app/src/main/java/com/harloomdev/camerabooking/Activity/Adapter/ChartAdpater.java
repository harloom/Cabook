package com.harloomdev.camerabooking.Activity.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.harloomdev.camerabooking.Http.conf.API.Model.Charts.Chart;
import com.harloomdev.camerabooking.Http.conf.Server;
import com.harloomdev.camerabooking.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChartAdpater extends RecyclerView.Adapter<ChartAdpater.ViewHolder> {
    private Context context;
    private Chart arrayList = new Chart();
    private OnChartClickListener mAdapterCallback;

    public ChartAdpater(Context context, Chart arrayList, OnChartClickListener mAdapterCallback) {
        this.context = context;
        this.arrayList = arrayList;
        this.mAdapterCallback = mAdapterCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rcy_chart,viewGroup,false);
        return new ViewHolder(view,mAdapterCallback);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder v, int i) {
        Chart item = arrayList;
        Log.d("Log : ",item.getRecordset().get(i).getJumlahPinjam().toString());
        Glide.with(context).load(Server.BASE_URL_IMAGE+item.getRecordset().get(i).getUrlImage()).
                into(v.v_imgProduct);
        v.v_nameProduct.setText(item.getRecordset().get(i).getNama());
        v.v_hargaProduct.setText("Rp. "+item.getRecordset().get(i).getHarga());
        v.v_count.setText(item.getRecordset().get(i).getJumlahPinjam().toString());


    }

    @Override
    public int getItemCount() {
        return  arrayList.getRecordset()!=null ? arrayList.getRecordset().size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder   {
        ImageView v_imgProduct ;
        TextView v_nameProduct;
        TextView v_hargaProduct;
        TextView v_count;
        TextView v_btnP;
        TextView v_btnM;
        OnChartClickListener  onChartClickListener;
        public ViewHolder(@NonNull View itemView, OnChartClickListener mAdapterCallback) {
            super(itemView);
            this.onChartClickListener = mAdapterCallback;
            this.v_btnP = itemView.findViewById(R.id.btn_p);
            this.v_btnM = itemView.findViewById(R.id.btn_m);
            this.v_imgProduct = itemView.findViewById(R.id.img_product);
            this.v_nameProduct = itemView.findViewById(R.id.name_product);
            this.v_hargaProduct = itemView.findViewById(R.id.harga_product);
            this.v_count = itemView.findViewById(R.id.count_beli);
            this.v_btnP.setOnClickListener(fun_btn_plus);
            this.v_btnM.setOnClickListener(fun_btn_minus);

        }

        View.OnClickListener fun_btn_minus  =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChartClickListener.onButtonMinus(getAdapterPosition());
            }
        };

        View.OnClickListener fun_btn_plus  =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChartClickListener.onButtonPlush(getAdapterPosition());
            }
        };



    }
}
