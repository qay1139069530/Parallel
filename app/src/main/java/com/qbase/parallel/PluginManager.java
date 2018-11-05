package com.qbase.parallel;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * 加载Activity两个重要的文件
 * Class 文件    Resources 文件
 * */
public class PluginManager {

    private static volatile PluginManager Instance;

    private DexClassLoader dexClassLoader;

    private Resources mResources;

    private Context mContext;

    /**第二个应用首个全雷鸣*/
    private String entryActivityName;

    public synchronized static PluginManager getInstance(){
        if(Instance==null){
            synchronized (PluginManager.class){
                if(Instance==null){
                    Instance = new PluginManager();
                }
            }
        }
        return Instance;
    }

    public PluginManager() {
    }

    public void loadPath(String path){

        File dexOutFile = mContext.getDir("dex",Context.MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(path,dexOutFile.getAbsolutePath(),null,mContext.getClassLoader());


        PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageArchiveInfo(path,PackageManager.GET_ACTIVITIES);
            entryActivityName = packageInfo.activities[0].name;

        //实例化Resources
         //Resources(AssetManager assets, DisplayMetrics metrics, Configuration config)
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            //AssetManager.class.getDeclaredMethod("addAssetPath",String.class).invoke(addAssetPath,path);
            Method addAssetPath  = AssetManager.class.getMethod("addAssetPath",String.class);
            addAssetPath.invoke(assetManager,path);
            mResources = new Resources(assetManager,mContext.getResources().getDisplayMetrics(),mContext.getResources().getConfiguration());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setContext(Context mContext) {
        this.mContext = mContext.getApplicationContext();
    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return mResources;
    }

    public String getEntryActivityName() {
        return entryActivityName;
    }
}
