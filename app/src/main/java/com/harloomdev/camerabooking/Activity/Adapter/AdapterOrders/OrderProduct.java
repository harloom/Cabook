package com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.harloomdev.camerabooking.Http.conf.API.Model.ViewKwitansi.Detail;
import com.harloomdev.camerabooking.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderProduct extends RecyclerView.Adapter<OrderProduct.ViewHolder> {
    private List<Detail> details ;
    private Context context;

    public OrderProduct(List<Detail> details, Context context) {
        this.details = details;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcy_order_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Detail detail = details.get(position);
        Glide.with(context).load(detail.getUrlImage()).into(holder.o_imgProduct);
        holder.o_txtNamaBarang.setText(detail.getNamaKamera());
        holder.o_txtUnit.setText(detail.getJumlahPinjam() + " Unit");
        holder.o_txtHargaBarang.setText("Rp. "+detail.getHarga());
        holder.o_txtTotalBarang.setText("Rp. "+detail.getHarga() * detail.getJumlahPinjam());

    }

    @Override
    public int getItemCount() {
        return null!=details?details.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView o_imgProduct;
        TextView o_txtNamaBarang;
        TextView o_txtHargaBarang;
        TextView o_txtUnit;
        TextView o_txtTotalBarang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            o_imgProduct = itemView.findViewById(R.id.o_img_product);
            o_txtNamaBarang = itemView.findViewById(R.id.o_txtNamaBarang);
            o_txtHargaBarang = itemView.findViewById(R.id.o_txtHargaBarang);
            o_txtUnit = itemView.findViewById(R.id.o_txtUnit);
            o_txtTotalBarang = itemView.findViewById(R.id.o_txtTotalBarang);
        }
    }
}
