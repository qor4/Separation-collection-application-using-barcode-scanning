package com.example.wastesortingapp;

import android.view.View;

public interface OnBarItemClickListener {
    public void onItemClick(BarAdapter.ViewHolder holder, View view, int position);
}