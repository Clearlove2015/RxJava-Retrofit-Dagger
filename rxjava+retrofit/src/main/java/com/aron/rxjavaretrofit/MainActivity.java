package com.aron.rxjavaretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        retrofit_request();
    }

    private void retrofit_request() {
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://localhost:4567/")
                .baseUrl("http://192.168.1.107:4567/")
                .addConverterFactory(GsonConverterFactory.create())//Gson转化器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持rxjava
                .build();

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
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(Result<List<Blog>> listResult) {
                        System.out.println("onNext" + listResult);
                        tv_reslult.setText(listResult.toString());
                    }
                });
    }
}
