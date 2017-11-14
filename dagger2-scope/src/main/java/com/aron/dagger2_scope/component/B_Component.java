package com.aron.dagger2_scope.component;

import com.aron.dagger2_scope.Activity_B;
import com.aron.dagger2_scope.module.B_Module;

import dagger.Component;

/**
 * Created by zhucheng on 2017/11/14.
 */

@Component(modules = B_Module.class)
public interface B_Component {

    void inject(Activity_B activity_b);

}
