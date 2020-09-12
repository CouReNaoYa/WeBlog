package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ClassifyRequest implements Parcelable {


    /**
     * code : 200
     * msg : success
     * data : [{"id":1,"name":"默认分类","info":"默认分类","count":3,"createTime":"2020-07-23 16:16:17","updateTime":"2020-07-23 16:16:17"}]
     */

    private int code;
    private String msg;
    private List<Classify> data;

    public ClassifyRequest(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<ClassifyRequest> CREATOR = new Creator<ClassifyRequest>() {
        @Override
        public ClassifyRequest createFromParcel(Parcel in) {
            return new ClassifyRequest(in);
        }

        @Override
        public ClassifyRequest[] newArray(int size) {
            return new ClassifyRequest[size];
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

    public List<Classify> getData() {
        return data;
    }

    public void setData(List<Classify> data) {
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
    }

    public ClassifyRequest(){

    }

}
