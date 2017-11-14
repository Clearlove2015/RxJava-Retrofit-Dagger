package com.aron.dagger2_singleton;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhucheng on 2017/11/14.
 */

@Singleton//在Component中同样添加@Singleton注解，否则会编译报错：
@Component(modules = AppModule.class)
public interface AppComponent {

    SharedPreferences sp();

}
