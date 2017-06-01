package com.wz.movieapp;

import android.app.Application;

import org.xutils.x;

/**
 * Created by wz on 17-5-30.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
