package com.example.deathlove.formygirl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import Utils.AllUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView metDays;
    private Button main_btn_photos, main_btn_records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        InitViews();
        AddListener();
        DoOptions();
    }

    private void AddListener() {
        main_btn_photos.setOnClickListener(this);
        main_btn_records.setOnClickListener(this);
    }

    private void DoOptions() {
        metDays.setText(AllUtils.getTwoDay(new Date()));
    }

    private void InitViews() {
        metDays = ((TextView) findViewById(R.id.main_matDays));
        main_btn_photos = ((Button) findViewById(R.id.main_btn_photos));
        main_btn_records = ((Button) findViewById(R.id.main_btn_records));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_photos:
                Intent photoIntent = new Intent(MainActivity.this, PhotoActivity.class);
                startActivity(photoIntent);
                break;
            case R.id.main_btn_records:
                Intent timeAxisIntent = new Intent(MainActivity.this, TimeAxisActivity.class);
                startActivity(timeAxisIntent);
                break;
        }
    }
}
