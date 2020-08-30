package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LoginResult implements Parcelable  {

    /**
     * code : 200
     * msg : success
     * data : [{"uid":1,"name":"test","type":2,"count":2,"email":"test@test.com","createTime":"2020-07-22 12:12:41","updateTime":"2020-08-28 21:12:17"},{"uid":3,"name":"emfi","type":0,"count":0,"email":"emfi@emfi.com","createTime":"2020-08-23 17:48:38","updateTime":"2020-08-23 17:48:38"},{"uid":2,"name":"管理员","type":1,"count":1,"email":"530414168@qq.com","createTime":"2020-08-23 15:40:26","updateTime":"2020-08-23 15:41:54"}]
     */

    private int code;
    private String msg;
    private UserItem data;

    protected LoginResult(Parcel in) {
        code = in.readInt();
        msg = in.readString();
        data = in.readParcelable(UserItem.class.getClassLoader());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
        dest.writeParcelable(data, flags);
    }

    public LoginResult(){

    }
}
