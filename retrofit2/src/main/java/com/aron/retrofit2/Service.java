package com.aron.retrofit2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zhucheng on 2017/11/14.
 */

public interface Service {

    @GET("/")
    Call<ResponseBody> getBaidu();

}
