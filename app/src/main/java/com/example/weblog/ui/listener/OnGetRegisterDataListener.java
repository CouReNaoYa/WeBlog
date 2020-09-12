package com.example.weblog.ui.listener;

import com.example.weblog.bean.LoginResult;
import com.example.weblog.ui.listener.base.OnGetDataListener;

public interface OnGetRegisterDataListener {
    void getSuccess();
    void getFailed(Throwable throwable,LoginResult loginResult);
}
