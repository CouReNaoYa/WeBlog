package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginResult extends BaseTextHttpResult<UserItem> implements Parcelable {
    public LoginResult(Parcel in) {
        super(in);
    }

    public LoginResult(){
        super();

    }


}
