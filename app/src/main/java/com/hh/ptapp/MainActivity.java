package com.hh.ptapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;

import com.hh.ptrouter.PTRouter;

public class MainActivity extends AppCompatActivity {

    Button mBtnHome;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mBtnHome = this.findViewById(R.id.btn_home);

        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PTRouter.create("putao://modlue_a/home?appid=8801&uid=123&username=chris").open(mContext);
            }
        });
    }
}
