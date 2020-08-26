package com.example.weblog.ui.persent;

import com.example.weblog.bean.LoginResult;
import com.example.weblog.bean.UserItem;
import com.example.weblog.ui.listener.OnGetLoginDataListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginPersent {
    private LoginResult loginResult;
    public void postLogin(final OnGetLoginDataListener listener, final Map<String,String> paramsMap) {
        //开启线程，发送请求


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String baseUrl = "http://47.101.132.233:8099/api/user/login";
                    //合成参数
                    StringBuilder tempParams = new StringBuilder();
                    int pos = 0;
                    for (String key : paramsMap.keySet()) {
                        if (pos > 0) {
                            tempParams.append("&");
                        }
                        tempParams.append(String.format("%s=%s", key,  URLEncoder.encode(paramsMap.get(key),"utf-8")));
                        pos++;
                    }
                    String params =tempParams.toString();
                    // 请求的参数转换为byte数组
                    byte[] postData = params.getBytes();
                    // 新建一个URL对象
                    URL url = new URL(baseUrl);
                    // 打开一个HttpURLConnection连接
                    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                    // 设置连接超时时间

                    urlConn.setConnectTimeout(5 * 1000);
                    //设置从主机读取数据超时
                    urlConn.setReadTimeout(5 * 1000);
                    // Post请求必须设置允许输出 默认false
                    urlConn.setDoOutput(true);
                    //设置请求允许输入 默认是true
                    urlConn.setDoInput(true);
                    // Post请求不能使用缓存
                    urlConn.setUseCaches(false);
                    // 设置为Post请求
                    urlConn.setRequestMethod("POST");
                    //设置本次连接是否自动处理重定向
                    urlConn.setInstanceFollowRedirects(true);
                    // 配置请求Content-Type
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    // 开始连接
                    urlConn.connect();
                    // 发送请求参数
                    DataOutputStream dos = new DataOutputStream(urlConn.getOutputStream());
                    dos.write(postData);
                    dos.flush();
                    dos.close();
                    // 判断请求是否成功
                    if (urlConn.getResponseCode() == 200) {
                        // 获取返回的数据
                        List<UserItem> userItems=new ArrayList<>();
                        String result = urlConn.getInputStream().toString();
                        loginResult=new LoginResult();
                        Gson gson = new Gson();
                        loginResult = gson.fromJson(result, loginResult.getClass());
                        JsonParser parser = new JsonParser();
                        JsonObject jsonObject = parser.parse(result).getAsJsonObject();

                        JsonArray jsonArray = jsonObject.getAsJsonArray("data");
                        for (int i = 0; i < jsonArray.size(); i++) {
                            //获取第i个数组元素
                            JsonElement el = jsonArray.get(i);
                            //映射为类实例
                            userItems.add(gson.fromJson(el, UserItem.class));
                            //  Bean1.SubjectsBean subject = gson.fromJson(el, Bean1.SubjectsBean.class);
                        }

                        loginResult.setData(userItems);

                        listener.getSuccess(loginResult);
                       // Log.e(TAG, "Post方式请求成功，result--->" + result);
                    } else {
                       // Log.e(TAG, "Post方式请求失败");
                    }
                    // 关闭连接
                    //urlConn.disconnect();
                } catch (Exception e) {
                   // Log.e(TAG, e.toString());
                    listener.getFailed(e);
                }
            }
        }).start();
    }

}
