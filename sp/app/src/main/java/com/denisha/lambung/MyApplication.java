package com.denisha.lambung;

import android.app.Application;
import android.content.Context;

/**
 * Created by ibnumuzzakkir on 7/17/2016.
 */
public class MyApplication extends Application {
    private static DatabaseHandler databaseHandler;
    private static MyApplication sInstance;

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    public synchronized static DatabaseHandler getWritableDatabase() {
        if (databaseHandler == null) {
            databaseHandler = new DatabaseHandler(MyApplication.getAppContext());
        }
        return databaseHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        databaseHandler = new DatabaseHandler(this);
    }
}

