package com.aron.rxjavaretrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_get)
    Button btnGet;
    @Bind(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get)
    public void onViewClicked() {
        get_request();
    }

    private void get_request() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())//转化器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .build();

        Service service = retrofit.create(Service.class);

        /**
         * Rxtrofit与RxJava配合使用
         * 被观察者（Observable）-->订阅（subscribe）-->观察者（Observer & Subscriber）
         */
        service.getBaidu()
                .subscribeOn(Schedulers.io())//io线程
                .observeOn(AndroidSchedulers.mainThread())//主线程
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        Log.d("TAG","onCompleted...");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG",e.getMessage());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            tvContent.setText(responseBody.string().toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

//        service.getBaidu()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<ResponseBody>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("TAG","onCompleted...");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("TAG",e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                        try {
//                            tvContent.setText(responseBody.string().toString());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
    }
}
