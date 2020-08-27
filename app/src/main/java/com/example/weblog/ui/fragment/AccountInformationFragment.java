package com.example.weblog.ui.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weblog.R;
import com.example.weblog.bean.LoginResult;
import com.example.weblog.ui.fragment.base.BaseFragment;

public class AccountInformationFragment extends BaseFragment {
    private ImageView ivAccountPicture;
    private TextView tvAccountName;
    private TextView tvAccountUserId;
    private TextView tvAccountTextCount;


    @Override
    protected void loadData() {
        LoginResult getloginResult= (LoginResult) getArguments().get("loginResult");
        if (getloginResult==null){
            System.out.println("getloginResult=0");
        }
        else{
            System.out.println("getloginResult不为0");
        tvAccountName.setText(getloginResult.getData().getName());
        tvAccountUserId.setText(getloginResult.getData().getUid());
        tvAccountTextCount.setText(getloginResult.getData().getCount());}
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

        ivAccountPicture = super.view.findViewById(R.id.iv_account_picture);
        tvAccountName=super.view.findViewById(R.id.tv_account_name);
        tvAccountUserId=super.view.findViewById(R.id.tv_account_uid);
        tvAccountTextCount=super.view.findViewById(R.id.tv_account_textcount);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_accounet_information;
    }
}
