package com.example.weblog.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.weblog.R;
import com.example.weblog.bean.Classify;
import com.example.weblog.bean.ClassifyRequest;
import com.example.weblog.bean.LoginResult;
import com.example.weblog.ui.activity.base.BaseActivity;
import com.example.weblog.ui.listener.OnGetAllClassifyListener;
import com.example.weblog.ui.listener.OnGetLoginDataListener;
import com.example.weblog.ui.listener.OnPostCreatTextListener;
import com.example.weblog.ui.persent.GetAllClassifyPersent;
import com.example.weblog.ui.persent.PublishTextPersnet;
import com.example.weblog.ui.persent.RegisterPersent;

import java.util.HashMap;
import java.util.Map;

public class CreatTextActivity extends BaseActivity {
    private EditText etCreatTextTitle;
    private EditText etCreatTextContent;
    private TextView tvCreatTextPublish;
    private TextView tvCreatTextCancel;
    private TextView tvCreatTextChooseClassify;
    private Map<String,String> params;
    private Map<String,String> creattextpost;
    private GetAllClassifyPersent getAllClassify;
    private PublishTextPersnet publishTextPersnet;






    protected void loadData() {
        params=new HashMap<String,String>();
        getAllClassify=new GetAllClassifyPersent();
        getAllClassify.getAllClassify(new OnGetAllClassifyListener() {


            @Override
            public void getSuccess(ClassifyRequest classifyRequest) {
                for (Classify classify:classifyRequest.getData()){
                    String id= String.valueOf(classify.getId());
                    String name=classify.getName();
                    params.put(name,id);
                }
            }
            @Override
            public void getFailed(Throwable throwable) {

            }
        });
    }

    protected void setListener() {
        tvCreatTextCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatTextActivity.this,MainViewActivity.class);
                startActivity(intent);

            }
        });

        tvCreatTextPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvCreatTextChooseClassify!=null)
                {



                    String classify= (String) tvCreatTextChooseClassify.getText();
                    String key=null;

                    for(Map.Entry<String,String> str : params.entrySet()) {

                        if(str.equals(str.getKey())) {

                            key = str.getValue();

                        }

                    }

                   // LoginActivity loginActivity=new LoginActivity();
                    String token=LoginActivity.spf.getString("token"," ");
                    creattextpost.put("classify",key);
                    creattextpost.put("content",etCreatTextContent.toString());
                    creattextpost.put("name",etCreatTextTitle.toString());
                    creattextpost.put("token",token);

                    publishTextPersnet=new PublishTextPersnet();
                    publishTextPersnet.postCreatText(new OnPostCreatTextListener() {
                        @Override
                        public void getSuccess() {
                            Intent intent = new Intent(CreatTextActivity.this,MainViewActivity.class);
                            startActivity(intent);

                        }

                        @Override
                        public void getFailed(Throwable throwable) {

                        }
                    },creattextpost);


                }
            }
        });

        tvCreatTextChooseClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(tvCreatTextChooseClassify);


            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        etCreatTextTitle=findViewById(R.id.et_creat_text_title);
        etCreatTextContent=findViewById(R.id.et_creat_text_content);



    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_creat_text;
    }

    @SuppressLint("ResourceType")
    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(this, view);
        // menu布局
        popupMenu.getMenuInflater().inflate(R.layout.menu_choose_classify, popupMenu.getMenu());

        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();


                switch (item.getItemId()) {
                    case R.id.item_choose_classify_1: {

                        tvCreatTextChooseClassify.setText("默认分类");

                    }
                    //Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                    break;
                    default:
                        break;
                }

                return false;
            }
        });
        // PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                //Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });

        popupMenu.show();
    }

}
