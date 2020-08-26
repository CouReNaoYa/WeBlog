package com.example.weblog.bean;

import android.os.Parcel;
import android.os.Parcelable;

public  class TextItem implements Parcelable {
    /**
     * id : 2
     * author : 2
     * authorName : 管理员
     * classify : 1
     * classifyName : 默认分类
     * status : 0
     * createTime : 2020-08-23 15:45:40
     * updateTime : 2020-08-23 15:45:40
     * name : 第一篇文章
     * content : 接口测试测试
     * summary : 接口测试测试
     */

    private int id;
    private int author;
    private String authorName;
    private int classify;
    private String classifyName;
    private int status;
    private String createTime;
    private String updateTime;
    private String name;
    private String content;
    private String summary;

    protected TextItem(Parcel in) {
        id = in.readInt();
        author = in.readInt();
        authorName = in.readString();
        classify = in.readInt();
        classifyName = in.readString();
        status = in.readInt();
        createTime = in.readString();
        updateTime = in.readString();
        name = in.readString();
        content = in.readString();
        summary = in.readString();
    }

    public static final Creator<TextItem> CREATOR = new Creator<TextItem>() {
        @Override
        public TextItem createFromParcel(Parcel in) {
            return new TextItem(in);
        }

        @Override
        public TextItem[] newArray(int size) {
            return new TextItem[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(author);
        dest.writeString(authorName);
        dest.writeInt(classify);
        dest.writeString(classifyName);
        dest.writeInt(status);
        dest.writeString(createTime);
        dest.writeString(updateTime);
        dest.writeString(name);
        dest.writeString(content);
        dest.writeString(summary);
    }
}
