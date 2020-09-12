package com.example.weblog.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.weblog.R;
import com.example.weblog.bean.LoginResult;
import com.example.weblog.bean.UserItem;
import com.example.weblog.ui.activity.base.BaseActivity;
import com.example.weblog.ui.adapter.MainPagerAdapter;
import com.example.weblog.ui.adapter.base.BaseAdapter;
import com.example.weblog.ui.fragment.AccountInformationFragment;
import com.example.weblog.ui.fragment.TextListFragment;
import com.example.weblog.ui.listener.PageChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainViewActivity extends BaseActivity {
    private static FragmentManager fragmentManager;

    private List<Fragment> viewList=new ArrayList<>();
    private List<RadioButton> radioButtons=new ArrayList<>();
    private RadioGroup radioGroup;


    @Override
    protected void loadData() {


    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        LoginResult loginResult=(LoginResult)data.getParcelable("loginResult");
//        loginuser=loginResult.getData();
//        String a=loginResult.getData().getEmail();
        if(loginResult==null) System.out.println("loginresult为空");
        else System.out.println("loginresult不为空");
        System.out.println("mainviewactivity的longinresult"+loginResult.getData().getEmail());


        Bundle bundle = new Bundle();
        bundle.putParcelable("loginResult", loginResult);
        AccountInformationFragment accountInformationFragment = new AccountInformationFragment();
        accountInformationFragment.setArguments(bundle);

        fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewPager,accountInformationFragment);
        fragmentTransaction.commit();

    }

    @Override
    protected void initView() {
        final ViewPager MainViewPager = (ViewPager) findViewById(R.id.viewPager);
        Fragment account_information_fragment=new AccountInformationFragment();
        Fragment text_list_fragment=new TextListFragment();
        viewList.add(text_list_fragment);
        viewList.add(account_information_fragment);

        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),viewList);
        MainViewPager.setAdapter(pagerAdapter);

        RadioButton btMainviewTextlist=findViewById(R.id.bt_mainview_textlist);
        RadioButton btMainviewAccount=findViewById(R.id.bt_mainview_account);
        radioButtons.add(btMainviewTextlist);
        radioButtons.add(btMainviewAccount);


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
