package com.example.weblog.util;

import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ShowPopupMenu {
    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
       // PopupMenu popupMenu = new PopupMenu(, view);
        PopupMenu popupMenu = null;
        // menu布局
        popupMenu.getMenuInflater().inflate(getLayoutRes(), popupMenu.getMenu());
        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               // Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
               // Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });

        popupMenu.show();
    }

    protected int getLayoutRes() {
        return 0;
    }

}
