package com.example.weblog.ui.persent;

import com.example.weblog.bean.Classify;
import com.example.weblog.bean.ClassifyRequest;
import com.example.weblog.bean.TextListResult;
import com.example.weblog.ui.listener.OnGetAllClassifyListener;
import com.example.weblog.ui.listener.OnGetTextListDataListener;
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
import java.util.ArrayList;
import java.util.List;

public class GetAllClassifyPersent {
    public static final String GetTextList="http://47.101.132.233:8099/api/classify/all";
    private ClassifyRequest classifyRequest;

    public void getAllClassify(final OnGetAllClassifyListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL(GetTextList);
                    connection = (HttpURLConnection) url.openConnection();
                    //设置请求方法
                    connection.setRequestMethod("GET");
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
                        classifyRequest=new ClassifyRequest();
                        Gson gson = new Gson();
                        classifyRequest = gson.fromJson(result, classifyRequest.getClass());

                        List<Classify> classifylist=new ArrayList<>();

                        JsonParser parser = new JsonParser();
                        JsonObject jsonObject = parser.parse(result).getAsJsonObject();
                        //将data节点下的内容转为JsonArray
                        JsonArray jsonArray = jsonObject.getAsJsonArray("data");
                        for (int i = 0; i < jsonArray.size(); i++) {
                            //获取第i个数组元素
                            JsonElement el = jsonArray.get(i);
                            //映射为类实例
                            classifylist.add(gson.fromJson(el, Classify.class));
                            //  Bean1.SubjectsBean subject = gson.fromJson(el, Bean1.SubjectsBean.class);
                        }
                        classifyRequest.setData(classifylist);
                        listener.getSuccess(classifyRequest);




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
