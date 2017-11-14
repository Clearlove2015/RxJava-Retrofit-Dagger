package com.aron.dagger2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * http://blog.csdn.net/mq2553299/article/details/73065745
 * http://blog.csdn.net/mq2553299/article/details/73414710
 */
public class A02SimpleActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Bind(R.id.btn_sp)
    Button btnSp;
    @Bind(R.id.tv_sp)
    TextView tvSp;

    public void init() {
        sp = MyApplication.getAppComponent().sp();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("key", "Dagger2注解全局单例SharedPreferences");
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a02_simple);
        ButterKnife.bind(this);
        init();
    }

    @OnClick(R.id.btn_sp)
    public void onViewClicked() {
        tvSp.setText(sp.getString("key",""));
    }
}
