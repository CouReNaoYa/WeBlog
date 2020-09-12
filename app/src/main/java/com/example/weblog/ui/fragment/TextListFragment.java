package com.example.weblog.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weblog.R;
import com.example.weblog.bean.TextListResult;
import com.example.weblog.ui.activity.CreatTextActivity;
import com.example.weblog.ui.activity.LoginActivity;
import com.example.weblog.ui.activity.MainViewActivity;
import com.example.weblog.ui.adapter.TextListAdapter;
import com.example.weblog.ui.fragment.base.BaseFragment;
import com.example.weblog.ui.listener.OnGetTextListDataListener;
import com.example.weblog.ui.persent.TextListPersent;

public  class TextListFragment extends BaseFragment {
    private RecyclerView  recyclerTextList;
    private TextListPersent textListPersent;
    private TextListAdapter textListAdapter;
    private TextView tvFragmentTextlistOther;



    @Override
    protected void loadData() {
        textListPersent=new TextListPersent();
        textListPersent.getTextList( new OnGetTextListDataListener() {

            @Override
            public void getSuccess(final TextListResult textListResult) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("textlist:"+textListResult.getData().get(0).getAuthorName());
                        textListAdapter.setList(textListResult.getData());

                    }
                });
            }

            @Override
            public void getFailed(Throwable throwable) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        //  showErrorView();
                    }
                });


            }
        });
    }

    @Override
    protected void setListener() {
        tvFragmentTextlistOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(tvFragmentTextlistOther);


            }
        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        recyclerTextList =super.view.findViewById(R.id.recycler_testlist);
        textListAdapter=new TextListAdapter(getActivity());
        recyclerTextList.setLayoutManager (new LinearLayoutManager(getActivity (),LinearLayoutManager.VERTICAL,false));
        recyclerTextList.setAdapter(textListAdapter);
        tvFragmentTextlistOther=super.view.findViewById(R.id.tv_fragment_textlist_other);
    }

    @Override
    public void initView() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_textlist;
    }

    @SuppressLint("ResourceType")
    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(getActivity(), view);
        // menu布局
        popupMenu.getMenuInflater().inflate(R.layout.menu, popupMenu.getMenu());
        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               // Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();


                switch (item.getItemId()) {
                    case R.id.item_add_text:
                    {
                        Intent intent = new Intent(MainViewActivity.this, CreatTextActivity.class);
                        startActivity(intent);


                    }
                        //Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_select_text_by_id:
                    {


                    }
                        //Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_select_account_by_id:
                    {


                    }
                        //Toast.makeText(this, "账号", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_select_text_by_core:
                    {


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
