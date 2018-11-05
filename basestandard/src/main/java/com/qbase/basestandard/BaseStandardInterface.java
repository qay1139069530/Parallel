package com.qbase.basestandard;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**标准接口*/
public interface BaseStandardInterface {

    public void onStart();

    public void onCreat(Bundle saveInstance);

    public void onResume();

    public void onPause();

    public void onDestory();

    public void onSaveInstanceState(Bundle outState);

    public boolean onTouchEvent(MotionEvent event);

    public void onBackPressed();


    /**需要qbase standard注入上下文*/

    public void attach(Activity activity);


}
