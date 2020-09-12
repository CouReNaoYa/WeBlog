package com.example.weblog.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weblog.R;
import com.example.weblog.bean.LoginResult;
import com.example.weblog.ui.activity.base.BaseActivity;
import com.example.weblog.ui.listener.OnGetLoginDataListener;
import com.example.weblog.ui.listener.OnGetRegisterDataListener;
import com.example.weblog.ui.persent.LoginPersent;
import com.example.weblog.ui.persent.RegisterPersent;

import java.util.HashMap;
import java.util.Map;

public class LoginRegisteraActivity extends BaseActivity {
    private EditText etRegisterEmial;
    private EditText etRegisterName;
    private EditText etRegisterPassword;
    private Button btRegister;
    private Map<String,String> params;
    private RegisterPersent registerPersent;
    @Override
    protected void loadData() {

    }

    @Override
    protected void setListener() {
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String register_email=etRegisterEmial.getText().toString();
                String register_name=etRegisterName.getText().toString();
                String register_password=etRegisterPassword.getText().toString();
                params=new HashMap<String,String>();
                registerPersent=new RegisterPersent();
                params.put("email",register_email);
                params.put("name",register_name);
                params.put("password",register_password);
                registerPersent=new RegisterPersent();
                registerPersent.postLogin(new OnGetRegisterDataListener() {
                    @Override
                    public void getSuccess() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                System.out.println("注册跳回");
                                Toast.makeText(LoginRegisteraActivity.this,"注册成功",Toast.LENGTH_LONG).show();//点击后显示的弹窗

                                Intent intent = new Intent(LoginRegisteraActivity.this,LoginActivity.class);
                             //   intent.putExtras(bundle);
                                startActivity(intent);

                            }
                        });
                    }
                    @Override
                    public void getFailed(Throwable throwable, LoginResult loginResult) {
                        System.out.println("出错了");
                        Toast.makeText(LoginRegisteraActivity.this,loginResult.getMsg(),Toast.LENGTH_LONG).show();//点击后显示的弹窗

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
        etRegisterEmial=findViewById(R.id.et_register_email);
        etRegisterName=findViewById(R.id.et_register_name);
        etRegisterPassword=findViewById(R.id.et_register_password);
        btRegister=findViewById(R.id.bt_register_button);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login_register;
    }
}
