package com.aron.dagger2.dagger;

import com.aron.dagger2.A01SimpleActivity;
import com.aron.dagger2.bean.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhucheng on 2017/11/12.
 */

@Module
public class A01SimpleModule {

    private A01SimpleActivity activity;

    public A01SimpleModule(A01SimpleActivity activity) {
        this.activity = activity;
    }

    @Provides
    Student provideStudent(){
        return new Student();
    }

}
