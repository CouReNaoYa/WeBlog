package com.example.weblog.ui.listener;

import android.widget.RadioButton;

import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class PageChangeListener  implements ViewPager.OnPageChangeListener{
    List<RadioButton> radioButtons;
    private int[] all={0,1};

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    public PageChangeListener (List<RadioButton> radioButtons){

        this.radioButtons=radioButtons;
    }
    @Override
    public void onPageSelected(int position) {
        for(int i:all){
            if(i==position){
                radioButtons.get(i).setChecked(true);
            }else{
                radioButtons.get(i).setChecked(false);
            }
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}