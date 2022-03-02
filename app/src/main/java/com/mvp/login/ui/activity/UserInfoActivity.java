package com.mvp.login.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import entity.User;

/**
 * 用户信息页面
 */
public class UserInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        User user= (User) intent.getSerializableExtra("user");
        TextView textView=new TextView(this);
        textView.append("账号："+user.getName()+"\n");
        textView.append("密码："+user.getPassword()+"\n");
        setContentView(textView);
    }
}
