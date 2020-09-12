package com.example.weblog.bean;

public  class Classify {
    /**
     * id : 1
     * name : 默认分类
     * info : 默认分类
     * count : 3
     * createTime : 2020-07-23 16:16:17
     * updateTime : 2020-07-23 16:16:17
     */

    private int id;
    private String name;
    private String info;
    private int count;
    private String createTime;
    private String updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
}