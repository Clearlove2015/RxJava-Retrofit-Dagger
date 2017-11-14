package com.aron.rxjavaretrofit2;


import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zhucheng on 2017/11/14.
 */

public interface Service {

    @GET("/")
    Observable<ResponseBody> getBaidu();

}
