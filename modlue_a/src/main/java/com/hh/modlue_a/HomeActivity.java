package com.hh.modlue_a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hh.ptannotation.PTRoutRule;

// 组件跳转: "putao://modlue_a/home?appid=8801&uid=123&username=chris"

@PTRoutRule(uri = {"putao://modlue_a/home"},//支持多uri
        intParams = {"appid", "uid"}, //声明参数类型
        stringParams = {"username"})
public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private TextView mTvParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvParams = this.findViewById(R.id.tv_params);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("username");
        int appid = bundle.getInt("appid");
        int uid = bundle.getInt("uid");

        mTvParams.setText(" username: " + name + " appid: " + appid + " uid: " + uid);
    }
}
