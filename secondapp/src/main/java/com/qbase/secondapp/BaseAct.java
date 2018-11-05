package com.qbase.secondapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qbase.basestandard.BaseStandardInterface;

public class BaseAct extends Activity implements BaseStandardInterface{


    private Activity activity;

    /**
     *  super.setContentView(layoutResID);
     * 是由调用了系统给我们注入的上下文
     */
    @Override
    public void setContentView(int layoutResID) {
        if(activity==null){
            super.setContentView(layoutResID);
        }else{
            activity.setContentView(layoutResID);
        }
    }

    @Override
    public <T extends View> T findViewById(int id) {
        if(activity==null){
            return super.findViewById(id);
        }else{
            return activity.findViewById(id);
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        if(activity==null){
            return super.getClassLoader();
        }else{
            return activity.getClassLoader();
        }
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if(activity==null){
            return super.getLayoutInflater();
        }else{
            return activity.getLayoutInflater();
        }
    }

    @Override
    public Window getWindow() {
        if(activity==null){
            return super.getWindow();
        }else{
            return activity.getWindow();
        }
    }

    @Override
    public WindowManager getWindowManager() {
        if(activity==null){
            return super.getWindowManager();
        }else{
            return activity.getWindowManager();
        }
    }

    @Override
    public void attach(Activity activity) {

        this.activity = activity;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreat(Bundle saveInstance) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }



}
