package com.example.broadcasttest;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.nio.Buffer;

import butterknife.ButterKnife;

/**
 * class description:
 * author ywk
 * since 2019-06-18
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Context mContext;
    private MyReceiver mMyReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        ActivityCollector.addActivity(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.FORCE_OFFLINE");
        mMyReceiver = new MyReceiver();
        registerReceiver(mMyReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mMyReceiver != null) {
            unregisterReceiver(mMyReceiver);
            mMyReceiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
            dialog.setTitle("提示");
            dialog.setMessage("账号强制下线");
            dialog.setCancelable(false);
            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAllActivity();
                    context.startActivity(new Intent(BaseActivity.this, LoginActivity.class));
                }
            });
            dialog.show();
        }
    }

    protected abstract int getLayoutId();
    protected abstract void initData();
    protected abstract void initView();
}