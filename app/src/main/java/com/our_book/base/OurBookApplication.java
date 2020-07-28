package com.our_book.base;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

//////@@@注释：便于在全局使用 getContext()函数得到当前context/
public class OurBookApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        LitePal.initialize(this);
    }
    public static Context getContext() {
        return context;
    }
}
