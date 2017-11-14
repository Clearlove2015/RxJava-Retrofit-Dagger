package com.aron.dagger2_scope.module;

import com.aron.dagger2_scope.Activity_B;
import com.aron.dagger2_scope.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhucheng on 2017/11/14.
 */

@Module
public class B_Module {

    Activity_B activity_b;

    public B_Module(Activity_B activity_b) {
        this.activity_b = activity_b;
    }

    @Provides
    Student provideStudent(){
        return new Student();
    }
}
