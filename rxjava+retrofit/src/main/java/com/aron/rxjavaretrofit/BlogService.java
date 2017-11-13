package com.aron.rxjavaretrofit;

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

    @GET("/blog")
    Observable<Result<List<Blog>>> getBlogs(@Query("page") int page);

}
