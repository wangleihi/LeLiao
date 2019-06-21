package com.example.leliao;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QiangLiao extends Fragment {
    private String result = "";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.qiang_liao, null);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        new Thread() {
            public void run() {
                result = PostUtils.postRequest("fef", "fejof");
//                handler.handleMessage(result);

                //更新主线程UI
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {

                /**
                 //             * 这里需要分析服务器回传的json格式数据，
                 //             */
                List<String> list=new ArrayList<String>();

                try {
                    JSONObject jsonObject = new JSONObject(result).getJSONObject("params");
                    JSONArray jsonArray = jsonObject.getJSONArray("list");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject2 = (JSONObject)jsonArray.opt(i);
                        list.add(jsonObject2.getString("sTitle"));
                    }

//                            int size=list.size();
//
//                            ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                                    (QiangLiao.this, android.R.layout.simple_expandable_list_item_1,strs);
//                            ListView list_test = view.findViewById(R.id.listView);
//                            list_test.setAdapter(adapter);
//                            list_test.setOnItemClickListener(QiangLiao.this);

                } catch (Exception e) {
//                            Log.e("tag", e.toString());
                }

//                    }
            };
//            };

        }.start();
        super.onViewCreated(view, savedInstanceState);
    }

}
