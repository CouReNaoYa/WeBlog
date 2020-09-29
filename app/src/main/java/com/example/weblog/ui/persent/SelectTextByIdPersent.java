package com.example.weblog.ui.persent;

import com.example.weblog.bean.Classify;
import com.example.weblog.bean.ClassifyRequest;
import com.example.weblog.bean.TextListResult;
import com.example.weblog.ui.listener.OnGetAllClassifyListener;
import com.example.weblog.ui.listener.OnGetTextBySelectIdListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectTextByIdPersent {

    public static String GetTextBySelectId;
    private TextListResult textListResult;

    public void getTextBySelectId(final OnGetTextBySelectIdListener listener,final Map<String,String> paramsMap){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {

                    StringBuilder tempParams = new StringBuilder();
                    int pos=0;
                    for (String key : paramsMap.keySet()) {
                        if (pos > 0) {
                            tempParams.append("&");
                        }
                        tempParams.append(String.format("%s=%s", key,  URLEncoder.encode(paramsMap.get(key),"utf-8")));
                        pos++;
                    }

                    String params =tempParams.toString();
                    GetTextBySelectId="http://47.101.132.233:8099/api/article"+"?"+params;


                    URL url = new URL(GetTextBySelectId);
                    connection = (HttpURLConnection) url.openConnection();
                    //设置请求方法
                    connection.setRequestMethod("POST");
                    //设置连接超时时间（毫秒）
                    connection.setConnectTimeout(50000);
                    //设置读取超时时间（毫秒）
                    connection.setReadTimeout(50000);

                    //返回输入流
                    InputStream in = connection.getInputStream();

                    //读取输入流
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder a = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        a.append(line);
                    }
                    String result = a.toString();
                    // 判断请求是否成功
                    if (connection.getResponseCode() == 200) {
                        // 获取返回的数据
                        textListResult=new TextListResult();
                        Gson gson = new Gson();
                        textListResult = gson.fromJson(result, textListResult.getClass());
                        listener.getSuccess(textListResult);

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
