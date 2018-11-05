package com.qbase.secondapp;

import android.os.Bundle;

/**
 * 插件即没有安装，没有上下文
 *
 * 上下文来源
 */
public class MainActivity extends BaseAct {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
