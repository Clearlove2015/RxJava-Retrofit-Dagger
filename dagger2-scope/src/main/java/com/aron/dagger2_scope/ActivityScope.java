package com.aron.dagger2_scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by zhucheng on 2017/11/14.
 */


@Scope//声明这是一个自定义@Scope注解
@Retention(RUNTIME)
public @interface ActivityScope {

}
