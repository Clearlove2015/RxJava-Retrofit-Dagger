package com.aron.rxpermissions;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;

/**
 * http://www.jianshu.com/p/314e9e27592f
 * http://blog.csdn.net/u013553529/article/details/68948971
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions();
    }

    /**
     * RxJava1版本
     */
    private void requestPermissions() {
        //同时请求多个权限
        RxPermissions.getInstance(MainActivity.this)
                .request(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.READ_CALL_LOG,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_SMS,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.SEND_SMS)//多个权限用","隔开
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            //当所有权限都允许之后，返回true
                            Log.i("permissions", "btn_more_sametime：" + aBoolean);
                        } else {
                            //只要有一个权限禁止，返回false，
                            //下一次申请只申请没通过申请的权限
                            Log.i("permissions", "btn_more_sametime：" + aBoolean);
                        }
                    }
                });

    }
}
