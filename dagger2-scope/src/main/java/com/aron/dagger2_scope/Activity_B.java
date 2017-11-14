package com.aron.dagger2_scope;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aron.dagger2_scope.component.DaggerB_Component;
import com.aron.dagger2_scope.module.B_Module;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Activity_B extends AppCompatActivity {

    @Bind(R.id.tv_b)
    TextView tvB;

    @Inject
    Student student3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);

        DaggerB_Component.builder()
                .b_Module(new B_Module(this))
                .build()
                .inject(this);

        //打印Student
        tvB.setText(student3.toString());
    }

}
