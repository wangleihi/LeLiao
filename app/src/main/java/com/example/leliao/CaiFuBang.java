package com.example.leliao;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class CaiFuBang extends LinearLayout {
    public CaiFuBang(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    // 初始化组件
    private void init (Context context) {
        //加载布局文件到此自定义组件
        //注意：第二个参数需填this，表示加载text_layout.xml到此自定义组件中。如果填null，则不加载，即不会显示text_layout.xml中的内容
        View view = LayoutInflater.from(context).inflate(R.layout.qiang_liao, this);

    }
}
