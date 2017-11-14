package com.aron.dagger2_scope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.aron.dagger2_scope.component.DaggerA_Component;
import com.aron.dagger2_scope.module.A_Module;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * http://blog.csdn.net/mq2553299/article/details/73414710
 * @Scope 局部单例
 */
public class Activity_A extends AppCompatActivity {

    @Bind(R.id.btn_a)
    Button btnA;
    @Bind(R.id.tv_a1)
    TextView tvA1;
    @Bind(R.id.tv_a2)
    TextView tvA2;

    @Inject
    Student student1;
    @Inject
    Student student2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);

        DaggerA_Component.builder()
                .a_Module(new A_Module(this))
                .build()
                .inject(this);

        //打印两个Student类
        tvA1.setText(student1.toString());
        tvA2.setText(student2.toString());
    }

    @OnClick(R.id.btn_a)
    public void onViewClicked() {
        startActivity(new Intent(Activity_A.this,Activity_B.class));
    }
}
