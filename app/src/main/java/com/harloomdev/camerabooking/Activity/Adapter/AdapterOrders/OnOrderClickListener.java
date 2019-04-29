package com.harloomdev.camerabooking.Activity.Adapter.AdapterOrders;


import com.ramotion.foldingcell.FoldingCell;

public interface OnOrderClickListener {
     void onCancel(int position );
     void foldingTutup(int position , FoldingCell foldingCell);
}
