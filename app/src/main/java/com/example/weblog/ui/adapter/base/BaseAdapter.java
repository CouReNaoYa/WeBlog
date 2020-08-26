package com.example.weblog.ui.adapter.base;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

public interface BaseAdapter<T>{
    T onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull T holder, int position) ;

    int getItemCount();

}
