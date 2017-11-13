package com.aron.dagger2.dagger;

import com.aron.dagger2.A01SimpleActivity;

import dagger.Component;

/**
 * Created by zhucheng on 2017/11/12.
 */

@Component(modules = A01SimpleModule.class)
public interface A01SimpleComponent {

    void inject(A01SimpleActivity activity);
}
