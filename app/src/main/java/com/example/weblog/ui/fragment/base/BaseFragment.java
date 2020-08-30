package com.example.weblog.ui.fragment.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    public View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(getLayoutRes(),null);
        initView();

        initData(savedInstanceState);
        loadData();
        setListener();


        return view;
    }

    protected abstract void loadData();

    protected abstract void setListener();

    protected abstract void initData(Bundle savedInstanceState);

    //设置view
    protected abstract void initView();
    //设置布局
    protected abstract int getLayoutRes();
}
