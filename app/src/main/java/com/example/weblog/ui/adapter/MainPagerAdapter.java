package com.example.weblog.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MainPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> viewList;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> viewList) {
        super(fm);
        this.viewList=viewList;
    }

    @Override
    public Fragment getItem(int i) {
        return viewList.get(i);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }
}