package com.example.weblog.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    private RelativeLayout rlAccountInformation;



    @Override
    protected void loadData() {
        Bundle bundle=getArguments();
        if (bundle!=null) {

            LoginResult getloginResult = (LoginResult) bundle.get("loginResult");

            String a=getloginResult.getData().getName();
            System.out.println("111111111222222222223333333333333"+a);
                tvAccountName.setText("用户名称"+getloginResult.getData().getName());
                tvAccountUserId.setText("用户id：" + getloginResult.getData().getUid());
                tvAccountTextCount.setText("用户文章数目" + getloginResult.getData().getCount());
            }

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {


        ivAccountPicture = view.findViewById(R.id.iv_account_picture);
        tvAccountName=view.findViewById(R.id.tv_account_name);
        tvAccountUserId=super.view.findViewById(R.id.tv_account_uid);
        tvAccountTextCount=super.view.findViewById(R.id.tv_account_textcount);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_accounet_information;
    }
}
