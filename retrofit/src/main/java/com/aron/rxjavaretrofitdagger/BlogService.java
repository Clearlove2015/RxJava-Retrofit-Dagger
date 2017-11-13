package com.aron.rxjavaretrofitdagger;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhucheng on 2017/11/12.
 */

public interface BlogService {
    @GET("blog/{id}")
    Call<ResponseBody> getBlog(@Path("id") int id);

    /**
     * method 表示请求的方法，区分大小写
     * path表示路径
     * hasBody表示是否有请求体
     */
    @HTTP(method = "GET", path = "blog/{id}", hasBody = false)
    Call<ResponseBody> getBlog2(@Path("id") int id);

    Call<ResponseBody> foo(@Query("ids[]") List<Integer> ids);
    //结果：ids[]=0&ids[]=1&ids[]=2

    @POST("blog")
    Call<Result<Blog>> createBlog(@Body Blog blog);

    @GET("/blog")
    Observable<Result<List<Blog>>> getBlogs(@Query("page") int page);

}
