package com.example.deathlove.formygirl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Death丶Love on 2016/5/12.
 */
public class TimeAxisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeaxis);
        getSupportActionBar().hide();
    }
}
