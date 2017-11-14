package com.aron.dagger2.singleton;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhucheng on 2017/11/14.
 */

@Singleton//注意此处加上@Singleton，否则编译报错
@Component(modules = AppModule.class)
public interface AppComponent {

    SharedPreferences sp();

}
