package com.aron.dagger2_scope.module;

import com.aron.dagger2_scope.ActivityScope;
import com.aron.dagger2_scope.Activity_A;
import com.aron.dagger2_scope.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhucheng on 2017/11/14.
 */

@Module
public class A_Module {

    Activity_A activity_a;

    public A_Module(Activity_A activity_a) {
        this.activity_a = activity_a;
    }

    @Provides
    @ActivityScope//添加注解实现局部单例
    Student provideStudent(){
        return new Student();
    }
}
