package com.example.weblog.ui.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.weblog.R;
import com.example.weblog.ui.activity.base.BaseActivity;
import com.example.weblog.ui.adapter.MainPagerAdapter;
import com.example.weblog.ui.adapter.base.BaseAdapter;
import com.example.weblog.ui.fragment.AccountInformationFragment;
import com.example.weblog.ui.fragment.TextListFragment;
import com.example.weblog.ui.listener.PageChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainViewActivity extends BaseActivity {
    private List<Fragment> viewList=new ArrayList<>();
    private List<RadioButton> radioButtons;
    private RadioGroup radioGroup;


    @Override
    protected void loadData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        final ViewPager MainViewPager = (ViewPager) findViewById(R.id.viewPager);
        Fragment account_information_fragment=new AccountInformationFragment();
        Fragment text_list_fragment=new TextListFragment();
        viewList.add(account_information_fragment);
        viewList.add(text_list_fragment);
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),viewList);
        MainViewPager.setAdapter(pagerAdapter);

        RadioButton btMainviewTextlist=findViewById(R.id.bt_mainview_textlist);
        RadioButton btMainviewAccount=findViewById(R.id.bt_mainview_account);
        radioButtons.add(btMainviewAccount);
        radioButtons.add(btMainviewTextlist);

        MainViewPager.setOnPageChangeListener(new PageChangeListener(radioButtons));
        radioGroup= (RadioGroup) findViewById(R.id.titleGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int i=0;
                for(RadioButton button:radioButtons){
                    if(button.getId()==checkedId){
                        MainViewPager.setCurrentItem(i);
                        break;
                    }
                    i++;
                }
            }
        });





    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}
