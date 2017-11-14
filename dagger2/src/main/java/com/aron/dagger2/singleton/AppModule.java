package com.aron.dagger2.singleton;

import android.content.Context;
import android.content.SharedPreferences;

import com.aron.dagger2.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhucheng on 2017/11/14.
 */

@Module
public class AppModule {

    MyApplication myApplication;

    public AppModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(){
        return myApplication.getSharedPreferences("aron_sp", Context.MODE_PRIVATE);
    }
}
