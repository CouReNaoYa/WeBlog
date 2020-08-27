package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LoginResult implements Parcelable {
    private int code;
    private String msg;
    private UserItem data;


    protected LoginResult(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public LoginResult() {

    }
    public static final Creator<LoginResult> CREATOR = new Creator<LoginResult>() {
        @Override
        public LoginResult createFromParcel(Parcel in) {
            return new LoginResult(in);
        }

        @Override
        public LoginResult[] newArray(int size) {
            return new LoginResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserItem getData() {
        return data;
    }

    public void setData(UserItem data) {
        this.data = data;
    }
}
