package com.aron.dagger2;

import android.app.Application;
import android.content.SharedPreferences;

import com.aron.dagger2.singleton.AppComponent;
import com.aron.dagger2.singleton.AppModule;
import com.aron.dagger2.singleton.DaggerAppComponent;

import javax.inject.Inject;

/**
 * Created by zhucheng on 2017/11/14.
 */

public class MyApplication extends Application {

    @Inject
    SharedPreferences sp;

    static AppComponent appComponent;

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
