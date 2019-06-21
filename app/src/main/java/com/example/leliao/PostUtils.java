package com.example.leliao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Log;
import java.net.URLEncoder;

public class PostUtils {
    // post请求
    public static String postRequest (String url, String body) {
        String msg = "";

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            // 设置请求方式
            con.setRequestMethod("POST");
//            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-cn; sdk Build/GRI34) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/6.0.0.57_r870003.501 NetType/internet");
//            con.setReadTimeout(5000);
            con.setConnectTimeout(5000);
//            //设置运行输入,输出:
//            con.setDoOutput(true);
//            con.setDoInput(true);
//            //Post方式不能缓存,需手动设置为false
//            con.setUseCaches(false);
            //我们请求的数据:
//            String data = "iType=2";
            //这里可以写一些请求头的东东...
//            con.setRequestProperty(User-Agent, Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0));

            //获取输出流
//            OutputStream out = con.getOutputStream();
//            out.write(data.getBytes());
//            out.flush();

            con.setDoInput(true);
            //用setRequestProperty方法设置一个自定义的请求头字段
//            con.setRequestProperty("action", NETwork_ge);
            //禁用网络缓存
            con.setUseCaches(false);
            //转码 防止乱码
            con.setRequestProperty("charset", "UTF-8");
            //  窗体数据被编码为 名称/值对 标准编码格式
            con.setRequestProperty("Content-type",
                    "application/x-www-form-urlencoded");
            con.connect();

            PrintWriter writer=new PrintWriter(con.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            int code = con.getResponseCode();

            if (code == 200) {
                // 获取响应的输入流对象
                InputStream inp = con.getInputStream();
                return streamToString(inp);
            } else {
                return "网络访问失败";
            }

//            // 创建字节输出流对象
//            ByteArrayOutputStream message = new ByteArrayOutputStream();
//            // 定义读取的长度
//            int len = 0;
//            // 定义缓冲区
//            byte buffer[] = new byte[1024];
//            // 按照缓冲区的大小，循环读取
//            while ((len = inp.read(buffer)) != -1) {
//                // 根据读取的长度写入到os对象中
//                message.write(buffer, 0, len);
//            }
//            // 释放资源
//            inp.close();
//            message.close();
//            // 返回字符串
//            msg = new String(message.toByteArray());
//            return msg;

        } catch (Exception e) {
            e.printStackTrace();
            return "发生异常，请求失败";
        }
//        return msg;
    }

    /**
     * 将输入流转换成字符串
     *
     * @param is
     *            从网络获取的输入流
     * @return
     */
    public static String streamToString(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            is.close();
            byte[] byteArray = baos.toByteArray();
            return new String(byteArray);
        } catch (Exception e) {
            Log.e("tag", e.toString());
            return null;
        }
    }
}
