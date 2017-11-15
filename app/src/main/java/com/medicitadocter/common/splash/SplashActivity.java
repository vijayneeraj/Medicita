package com.medicitadocter.common.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.common.login.LoginSelectUserTypeActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected int getLayoutResourceView() {
        /**
         * Call relative View id
         */
        return R.layout.c_activity_splash;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StartActivityWithFinish(LoginSelectUserTypeActivity.class);
            }
        }, 2000);
    }


}
