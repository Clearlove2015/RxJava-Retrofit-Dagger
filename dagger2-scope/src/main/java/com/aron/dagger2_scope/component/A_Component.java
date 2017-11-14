package com.aron.dagger2_scope.component;

import com.aron.dagger2_scope.ActivityScope;
import com.aron.dagger2_scope.module.A_Module;
import com.aron.dagger2_scope.Activity_A;

import dagger.Component;

/**
 * Created by zhucheng on 2017/11/14.
 */

@ActivityScope//在Component中同样添加@ActivityScope注解，否则会编译报错：
@Component(modules = A_Module.class)
public interface A_Component {

    void inject(Activity_A activity_a);

}
