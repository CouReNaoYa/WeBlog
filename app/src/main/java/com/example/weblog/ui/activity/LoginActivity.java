package com.example.weblog.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.example.weblog.R;
import com.example.weblog.bean.LoginResult;
import com.example.weblog.ui.activity.base.BaseActivity;
import com.example.weblog.ui.fragment.AccountInformationFragment;
import com.example.weblog.ui.listener.OnGetLoginDataListener;
import com.example.weblog.ui.persent.LoginPersent;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    private EditText etLoginAccount;
    private EditText etLonginPassword;
    private Button btLoginButton;
    private TextView tvCreatAccount;
    private TextView tvForgetPassword;

    private LoginPersent loginPersent;

    private Map<String,String> params;





    @Override
    protected void loadData() {

    }

    @Override
    protected void setListener() {



        btLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_id=etLoginAccount.getText().toString();
                String login_password=etLonginPassword.getText().toString();
                params=new HashMap<String,String>();
                loginPersent=new LoginPersent();


                params.put("email",etLoginAccount.getText().toString());
                params.put("password",login_password);

                loginPersent.postLogin(new OnGetLoginDataListener() {
                    @Override
                    public void getSuccess(final LoginResult loginResult) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("loginResult", loginResult);

                                Intent intent = new Intent(LoginActivity.this,MainViewActivity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);

                            }
                        });
                    }
                    @Override
                    public void getFailed(Throwable throwable) {
                    }
                }, params);
            }
        });



    }

            @Override
            protected void initData(Bundle savedInstanceState) {

            }

            @Override
            protected void initView() {

                etLoginAccount = findViewById(R.id.et_login_account);
                etLonginPassword = findViewById(R.id.et_login_password);
                btLoginButton = findViewById(R.id.bt_login_button);
                tvCreatAccount = findViewById(R.id.tv_creat_account);
                tvForgetPassword = findViewById(R.id.tv_forget_password);
            }

            @Override
            protected int getLayoutRes() {
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                return R.layout.activity_login;
            }



}