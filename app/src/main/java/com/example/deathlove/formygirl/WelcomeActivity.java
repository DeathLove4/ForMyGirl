package com.example.deathlove.formygirl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Death丶Love on 2016/5/5.
 */
public class WelcomeActivity extends AppCompatActivity {
    private TextView tv_My, tv_Girl;
    private Animation animation_My, animation_Girl;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_Girl.clearAnimation();
            tv_My.clearAnimation();
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        InitViews();
        DoOptions();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    handler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void DoOptions() {
        tv_My.startAnimation(animation_My);
        tv_Girl.startAnimation(animation_Girl);
    }

    private void InitViews() {
        tv_My = ((TextView) findViewById(R.id.welcome_tv_My));
        tv_Girl = ((TextView) findViewById(R.id.welcome_tv_Girl));
        animation_My = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.translate_my);
        animation_Girl = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.translate_girl);
    }
}
