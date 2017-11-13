package com.aron.rxjavaretrofitdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * http://www.jianshu.com/p/308f3c54abdd
 * http://www.jianshu.com/p/a8b88c7fe831
 * http://gank.io/post/560e15be2dca930e00da1083#toc_14
 * https://www.cnblogs.com/sunzn/p/5951812.html
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_click)
    Button btnClick;
    @Bind(R.id.tv_result)
    TextView tv_reslult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        request();
    }

    private void request() {
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://localhost:4567/")
                .baseUrl("http://192.168.1.107:4567/")
                .addConverterFactory(GsonConverterFactory.create())//Gson转化器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持rxjava
                .build();
//        BlogService service = retrofit.create(BlogService.class);
//        Call<ResponseBody> call = service.getBlog(2);
//
//        // 用法和OkHttp的call如出一辙,
//        // 不同的是如果是Android系统回调方法执行在主线程
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    System.out.println(response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

//        BlogService service = retrofit.create(BlogService.class);
//        Blog blog = new Blog();
//        blog.content = "新建的Blog";
//        blog.title = "测试";
//        blog.author = "怪盗kidou";
//        Call<Result<Blog>> call = service.createBlog(blog);
//
//        call.enqueue(new Callback<Result<Blog>>() {
//            @Override
//            public void onResponse(Call<Result<Blog>> call, Response<Result<Blog>> response) {
//                Log.e("TAG",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<Result<Blog>> call, Throwable t) {
//                Log.e("TAG",t.getMessage());
//            }
//        });

        /**
         * Retrofit与RxJava配合使用
         */
        BlogService service = retrofit.create(BlogService.class);
        service.getBlogs(1)
                .subscribeOn(Schedulers.io())//io线程
                .observeOn(AndroidSchedulers.mainThread())//主线程
                .subscribe(new Subscriber<Result<List<Blog>>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println("onError");
                    }

                    @Override
                    public void onNext(Result<List<Blog>> blogsResult) {
                        System.out.println(blogsResult);
                        tv_reslult.setText(blogsResult.toString());
                    }
                });


    }
}
