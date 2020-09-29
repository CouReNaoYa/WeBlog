package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public  class UserItem implements Parcelable, Serializable {
    /**
     * uid : 1
     * name : test
     * type : 2
     * count : 2
     * email : test@test.com
     * createTime : 2020-07-22 12:12:41
     * updateTime : 2020-08-28 21:12:17
     */

    private int uid;
    private String name;
    private int type;
    private int count;
    private String email;
    private String createTime;
    private String token;
    private String updateTime;


    protected UserItem(Parcel in) {
        uid = in.readInt();
        name = in.readString();
        type = in.readInt();
        count = in.readInt();
        email = in.readString();
        createTime = in.readString();
        token = in.readString();
        updateTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(name);
        dest.writeInt(type);
        dest.writeInt(count);
        dest.writeString(email);
        dest.writeString(createTime);
        dest.writeString(token);
        dest.writeString(updateTime);
    }

    public static final Creator<UserItem> CREATOR = new Creator<UserItem>() {
        @Override
        public UserItem createFromParcel(Parcel in) {
            return new UserItem(in);
        }

        @Override
        public UserItem[] newArray(int size) {
            return new UserItem[size];
        }
    };

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }


}