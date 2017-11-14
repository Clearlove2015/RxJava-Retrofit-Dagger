package com.aron.dagger2_singleton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * http://blog.csdn.net/mq2553299/article/details/73414710
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_sp)
    TextView tvSp;

    SharedPreferences sp;

    public void init(){
        sp = MyApplication.getAppComponent().sp();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("key","Dagger注解全局单例SharedPreferences");
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

        tvSp.setText(sp.getString("key",""));
    }
}
