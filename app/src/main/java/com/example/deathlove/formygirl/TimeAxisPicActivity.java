package com.example.deathlove.formygirl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import CustomAdapter.PhotoViewPagerAdapter;
import CustomAdapter.TimeAxisPicViewPagerAdapter;
import ViewPagerTransforms.ScaleInOutTransformer;

/**
 * Created by Death丶Love on 2016/5/17.
 */
public class TimeAxisPicActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private int[] picArray;
    private LinearLayout TimeAxisPic_pointLayout;
    private TimeAxisPicViewPagerAdapter adapter;
    private ViewPager viewPager;
    private ImageView returnIv;
    private List<ImageView> list;
    private int prePosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeaxispic);
        getSupportActionBar().hide();

        picArray = getIntent().getExtras().getIntArray("PicArray");

        InitViews();
    }

    private void InitViews() {
        returnIv = ((ImageView) findViewById(R.id.TimeAxisPic_return));
        returnIv.bringToFront();
        viewPager = ((ViewPager) findViewById(R.id.TimeAxisPic_viewPager));
        TimeAxisPic_pointLayout = ((LinearLayout) findViewById(R.id.TimeAxisPic_pointLayout));
        list = new ArrayList<>();

        returnIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //if (picArray.length > 1) {
        for (int i = 0; i < picArray.length; i++) {

            // 创建数据源
            ImageView iv = new ImageView(this);
            RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            iv.setLayoutParams(rParams);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(picArray[i]);
            list.add(iv);

            // 往线性布局中添加小圆点
            View view = new View(this);
            // 布局参数:指定宽,高
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(40, 40);
            view.setLayoutParams(params);
            params.leftMargin = 2;
            view.setBackgroundResource(R.mipmap.dot_normal);
            TimeAxisPic_pointLayout.addView(view);
        }

        TimeAxisPic_pointLayout.getChildAt(0).setBackgroundResource(R.mipmap.dot_enable);
//        } else {
//            for (int i = 0; i < picArray.length; i++) {
//
//                // 创建数据源
//                ImageView iv = new ImageView(this);
//                iv.setImageResource(picArray[i]);
//                list.add(iv);

        // 往线性布局中添加小圆点
        //View view = new View(this);
        // 布局参数:指定宽,高
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(40, 40);
        //view.setLayoutParams(params);
        //params.leftMargin = 2;
        // view.setBackgroundResource(R.mipmap.dot_normal);
        // TimeAxisPic_pointLayout.addView(view);
        //}
        // }


        adapter = new TimeAxisPicViewPagerAdapter(list);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new ScaleInOutTransformer());
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (picArray.length > 1) {
            TimeAxisPic_pointLayout.getChildAt(position % list.size()).setBackgroundResource(R.mipmap.dot_enable);
            TimeAxisPic_pointLayout.getChildAt(prePosition % list.size()).setBackgroundResource(R.mipmap.dot_normal);
            prePosition = position;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
