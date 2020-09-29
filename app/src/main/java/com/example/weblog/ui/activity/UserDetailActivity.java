package com.example.weblog.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weblog.R;
import com.example.weblog.bean.TextListResult;
import com.example.weblog.bean.UserItem;
import com.example.weblog.ui.activity.base.BaseActivity;
import com.example.weblog.ui.adapter.TextListAdapter;
import com.example.weblog.ui.listener.OnGetTextBySelectIdListener;
import com.example.weblog.ui.listener.OnGetTextBySelectUserIdListener;
import com.example.weblog.ui.persent.SelectTextByUseridPersent;

import java.util.HashMap;
import java.util.Map;

public class UserDetailActivity extends BaseActivity {
    private ImageView ivSelectUserByIdPicture;
    private TextView tvSelectUserByIdName;
    private TextView tvSelectUserByIdUid;
    private TextView tvSelectUserByIdTextcount;
    private RecyclerView recyclerSelecyUserTestlist;
    private TextListAdapter textListAdapter;
    private SelectTextByUseridPersent selectTextByUseridPersent;
    private Map<String,String> params;


    @Override
    protected void loadData() {
        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        UserItem userItem=data.getParcelable("loginResult");
        tvSelectUserByIdName.setText(userItem.getName());
        tvSelectUserByIdUid.setText(userItem.getUid());
        tvSelectUserByIdTextcount.setText(userItem.getCount());

        String uid=String.valueOf(userItem.getUid());
        selectTextByUseridPersent=new SelectTextByUseridPersent();
        params=new HashMap<String,String>();
        params.put("id",uid);
        selectTextByUseridPersent.getTextBySelectUserid(new OnGetTextBySelectUserIdListener() {
            @Override
            public void getSuccess(final TextListResult textListResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textListAdapter.setList(textListResult.getData());

                    }
                });
            }
            @Override
            public void getFailed(Throwable throwable) {
                System.out.println("出错了");


            }
        },params);







    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        ivSelectUserByIdPicture=findViewById(R.id.iv_select_user_by_id_picture);
        tvSelectUserByIdName=findViewById(R.id.tv_select_user_by_id_name);
        tvSelectUserByIdUid=findViewById(R.id.tv_select_user_by_id_uid);
        tvSelectUserByIdTextcount=findViewById(R.id.tv_select_user_by_id_textcount);
        recyclerSelecyUserTestlist=findViewById(R.id.recycler_selecy_user_testlist);

        textListAdapter=new TextListAdapter(UserDetailActivity.this);
        recyclerSelecyUserTestlist.setLayoutManager (new LinearLayoutManager(UserDetailActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerSelecyUserTestlist.setAdapter(textListAdapter);





    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_user_detail;
    }
}
