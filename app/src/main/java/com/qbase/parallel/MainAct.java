package com.qbase.parallel;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        PluginManager.getInstance().setContext(this);
    }

    public void onLoad(View view){
        File file = new File(Environment.getExternalStorageDirectory(),"SecondApp.apk");
        PluginManager.getInstance().loadPath(file.getAbsolutePath());
    }

    public void onJump(View view){
        Intent intent = new Intent(this,ProxyAct.class);
        intent.putExtra("className",PluginManager.getInstance().getEntryActivityName());
        startActivity(intent);
    }
}
