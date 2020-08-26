package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BaseTextHttpResult<T>  implements Parcelable {

    /**
     * code : 200
     * msg : success
     * data : [{"id":2,"author":2,"authorName":"管理员","classify":1,"classifyName":"默认分类","status":0,"createTime":"2020-08-23 15:45:40","updateTime":"2020-08-23 15:45:40","name":"第一篇文章","content":"接口测试测试","summary":"接口测试测试"},{"id":1,"author":1,"authorName":"test","classify":1,"classifyName":"默认分类","status":0,"createTime":"2020-07-24 08:52:24","updateTime":"2020-07-24 08:52:24","name":"测试","content":"测试内容","summary":"测试内容"}]
     */

    private int code;
    private String msg;
    private List<T> datas;

    protected BaseTextHttpResult(Parcel in) {
        code = in.readInt();
        msg = in.readString();

    }

    public static final Creator<BaseTextHttpResult> CREATOR = new Creator<BaseTextHttpResult>() {
        @Override
        public BaseTextHttpResult createFromParcel(Parcel in) {
            return new BaseTextHttpResult(in);
        }

        @Override
        public BaseTextHttpResult[] newArray(int size) {
            return new BaseTextHttpResult[size];
        }
    };

    public BaseTextHttpResult() {

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

    public List<T> getData() {
        return datas;
    }

    public void setData(List<T> data) {
        this.datas = data;
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
}
