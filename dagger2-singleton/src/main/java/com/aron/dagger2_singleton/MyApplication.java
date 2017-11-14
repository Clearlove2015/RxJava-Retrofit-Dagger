package com.aron.dagger2_singleton;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by zhucheng on 2017/11/14.
 */

public class MyApplication extends Application {

    static AppComponent appComponent;

    @Inject
    SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    static AppComponent getAppComponent(){
        return appComponent;
    }

}
