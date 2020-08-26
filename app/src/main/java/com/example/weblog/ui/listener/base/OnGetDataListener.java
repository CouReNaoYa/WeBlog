package com.example.weblog.ui.listener.base;
public interface OnGetDataListener<T> {
    void getSuccess(T t);
    void getFailed(Throwable throwable);
}
