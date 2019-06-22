package com.example.broadcasttest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Override
    protected int getLayoutId() {
        return (R.layout.activity_login);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


    @OnClick(R.id.btn_sign_up)
    public void onClick() {
        if(etAccount.getText().toString().equals("123")&&etPassword.getText().toString().equals("123")){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }else{
            Toast.makeText(this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
        }


    }
}

