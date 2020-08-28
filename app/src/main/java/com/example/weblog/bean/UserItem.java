package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class UserItem implements Parcelable {

        /**
         * uid : 1
         * name : test
         * type : 2
         * count : 1
         * email : test@test.com
         * createTime : 2020-07-22 12:12:41
         * updateTime : 2020-08-24 20:39:26
         */

        private int uid;
        private String name;
        private int type;
        private int count;
        private String email;
        private String createTime;
        private String updateTime;

    protected UserItem(Parcel in) {
        uid = in.readInt();
        name = in.readString();
        type = in.readInt();
        count = in.readInt();
        email = in.readString();
        createTime = in.readString();
        updateTime = in.readString();
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(name);
        dest.writeInt(type);
        dest.writeInt(count);
        dest.writeString(email);
        dest.writeString(createTime);
        dest.writeString(updateTime);
    }
}
