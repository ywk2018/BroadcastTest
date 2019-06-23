package com.example.broadcasttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return (R.layout.activity_main);
    }

    @Override
    protected void initData() {
        //

    }

    @Override
    protected void initView() {

    }

    public void onClick(View view) {
        sendBroadcast(new Intent("com.example.broadcasttest.FORCE_OFFLINE"));
    }
}
