package com.example.weblog.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weblog.R;
import com.example.weblog.bean.LoginResult;
import com.example.weblog.bean.TextListResult;
import com.example.weblog.ui.activity.base.BaseActivity;
import com.example.weblog.ui.listener.OnGetLoginDataListener;
import com.example.weblog.ui.listener.OnGetTextBySelectIdListener;
import com.example.weblog.ui.persent.LoginPersent;
import com.example.weblog.ui.persent.SelectTextByIdPersent;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SelectTextByIdActivity extends BaseActivity {

    private TextView tvSelectTextByIdButton;
    private EditText etSelectTextId;
    private Map<String,String> params;
    private SelectTextByIdPersent selectTextByIdPersent;
    private TextView tvTextSelectByIdAuthorName;
    private TextView tvTextSelectByIdCreatTime;
    private TextView tvTextSelectByIdClassify;
    private TextView tvTextSelectByIdContent;
    @Override
    protected void loadData() {

    }

    @Override
    protected void setListener() {
        tvSelectTextByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextId=etSelectTextId.getText().toString();
                selectTextByIdPersent=new SelectTextByIdPersent();

                params=new HashMap<String,String>();
                params.put("id",TextId);

                selectTextByIdPersent.getTextBySelectId(new OnGetTextBySelectIdListener() {
                    @Override
                    public void getSuccess(final TextListResult textListResult) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String name=textListResult.getData().get(0).getName();
                                String creat_time=textListResult.getData().get(0).getCreateTime();
                                String classify=textListResult.getData().get(0).getClassifyName();
                                String content=textListResult.getData().get(0).getContent();

                                tvTextSelectByIdAuthorName.setText(name);
                                tvTextSelectByIdCreatTime.setText(creat_time);
                                tvTextSelectByIdClassify.setText(classify);
                                tvTextSelectByIdContent.setText(content);









                            }
                        });
                    }
                    @Override
                    public void getFailed(Throwable throwable) {
                        System.out.println("出错了");


                    }
                },params);
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        tvSelectTextByIdButton=findViewById(R.id.tv_select_text_by_id_button);
        etSelectTextId=findViewById(R.id.et_select_text_id);
        tvTextSelectByIdAuthorName=findViewById(R.id.tv_text_select_by_id_author_name);
        tvTextSelectByIdCreatTime=findViewById(R.id.tv_text_select_by_id_creat_time);
        tvTextSelectByIdClassify=findViewById(R.id.tv_text_select_by_id_classify);
        tvTextSelectByIdContent=findViewById(R.id.tv_text_select_by_id_content);



    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_select_text_by_id;
    }
}
