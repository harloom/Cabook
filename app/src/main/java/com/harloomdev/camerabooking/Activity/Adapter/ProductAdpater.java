package com.harloomdev.camerabooking.Activity.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.harloomdev.camerabooking.Http.conf.API.Model.Products;
import com.harloomdev.camerabooking.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class ProductAdpater extends RecyclerView.Adapter<ProductAdpater.ViewHolder> {
    private Context context;
    private ArrayList<Products> arrayList = new ArrayList<>();
    private OnProductClickListener mAdapterCallback;

    public ProductAdpater(Context context, ArrayList<Products> arrayList, OnProductClickListener mAdapterCallback) {
        this.context = context;
        this.arrayList = arrayList;
        this.mAdapterCallback = mAdapterCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rcy_product_view,viewGroup,false);

        return new ViewHolder(view,mAdapterCallback);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder v, int i) {
        Products item = arrayList.get(i);

        Glide.with(context).load(item.getUrlImage()).
                into(v.v_imgProduct);
        v.v_nameProduct.setText(item.getNamaKamera());
        v.v_hargaProduct.setText("Rp. "+item.getHarga());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        ImageView v_imgProduct ;
        TextView v_nameProduct;
        TextView v_hargaProduct;
        Button v_btnOrder;
        OnProductClickListener onProductClickListener;
        public ViewHolder(@NonNull View itemView, OnProductClickListener mAdapterCallback) {
            super(itemView);
            this.onProductClickListener = mAdapterCallback;
            this.v_btnOrder = itemView.findViewById(R.id.btn_order);
            this.v_imgProduct = itemView.findViewById(R.id.img_product);
            this.v_nameProduct = itemView.findViewById(R.id.name_product);
            this.v_hargaProduct = itemView.findViewById(R.id.harga_product);

            this.v_btnOrder.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            onProductClickListener.onButtonOrderClick(getAdapterPosition());
        }
    }
}
