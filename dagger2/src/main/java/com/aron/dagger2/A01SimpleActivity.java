package com.aron.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.aron.dagger2.bean.Student;
import com.aron.dagger2.dagger.A01SimpleModule;
import com.aron.dagger2.dagger.DaggerA01SimpleComponent;
import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * http://blog.csdn.net/mq2553299/article/details/73065745
 */
public class A01SimpleActivity extends AppCompatActivity {

    @Bind(R.id.btn_click)
    Button btnClick;

    @Inject
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a01_simple);
        ButterKnife.bind(this);

//        DaggerA01SimpleComponent.builder()
//                .a01SimpleModule(new A01SimpleModule(this))
//                .build()
//                .inject(this);

        /**
         * 如果DaggerA01SimpleComponent类不能正确索引，Ctrl + F9 编译一下
         */
        DaggerA01SimpleComponent.builder()
                .a01SimpleModule(new A01SimpleModule(this))
                .build()
                .inject(this);
    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        Toast.makeText(this, student.toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(A01SimpleActivity.this,A02SimpleActivity.class));
    }
}
