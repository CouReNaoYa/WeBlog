package com.example.weblog.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weblog.R;
import com.example.weblog.bean.LoginResult;
import com.example.weblog.ui.activity.LoginActivity;
import com.example.weblog.ui.activity.LoginRegisteraActivity;
import com.example.weblog.ui.activity.UserDetailActivity;
import com.example.weblog.ui.fragment.base.BaseFragment;

public class AccountInformationFragment extends BaseFragment {
    private ImageView ivAccountPicture;
    private TextView tvAccountName;
    private TextView tvAccountUserId;
    private TextView tvAccountTextCount;
    private RelativeLayout rlAccountInformation;

    private RelativeLayout rvChangeAccountInformation;
    private RelativeLayout rvLookMytext;
    private RelativeLayout rvAccountSetting;
    private RelativeLayout rvAccountSafe;
    private RelativeLayout rvAccountFocuse;
    private RelativeLayout rvAccountCollect;
    private RelativeLayout rvAccountQuit;
    private Bundle bundle;





    @Override
    protected void loadData() {
        bundle=getArguments();
        if (bundle!=null) {

            LoginResult getloginResult = (LoginResult) bundle.get("loginResult");

            String a=getloginResult.getData().getName();
            System.out.println("111111111222222222223333333333333"+a);
                tvAccountName.setText("asdasdasdsad");
                tvAccountUserId.setText("用户id：" + getloginResult.getData().getUid());
                tvAccountTextCount.setText("用户文章数目" + getloginResult.getData().getCount());
            }

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        rvChangeAccountInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        rvLookMytext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rvAccountSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rvAccountSafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rvAccountFocuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rvAccountCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        rvAccountQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    protected void initView() {

        ivAccountPicture = view.findViewById(R.id.iv_account_picture);
        tvAccountName=(TextView) view.findViewById(R.id.tv_account_name);
        tvAccountUserId=super.view.findViewById(R.id.tv_account_uid);
        tvAccountTextCount=super.view.findViewById(R.id.tv_account_textcount);

        rvChangeAccountInformation=view.findViewById(R.id.rv_change_account_information);
        rvLookMytext=view.findViewById(R.id.rv_look_mytext);
        rvAccountSetting=view.findViewById(R.id.rv_account_setting);
        rvAccountSafe=view.findViewById(R.id.rv_account_safe);
        rvAccountFocuse=view.findViewById(R.id.rv_account_focuse);
        rvAccountCollect=view.findViewById(R.id.rv_account_collect);
        rvAccountQuit=view.findViewById(R.id.rv_account_quit);




    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_accounet_information;
    }
}
