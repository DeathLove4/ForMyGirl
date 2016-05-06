package com.example.deathlove.formygirl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import CustomAdapter.PhotoViewPagerAdapter;
import ViewPagerTransforms.ABaseTransformer;
import ViewPagerTransforms.AccordionTransformer;
import ViewPagerTransforms.BackgroundToForegroundTransformer;
import ViewPagerTransforms.CubeInTransformer;
import ViewPagerTransforms.CubeOutTransformer;
import ViewPagerTransforms.DefaultTransformer;
import ViewPagerTransforms.DepthPageTransformer;
import ViewPagerTransforms.FlipHorizontalTransformer;
import ViewPagerTransforms.ForegroundToBackgroundTransformer;
import ViewPagerTransforms.RotateDownTransformer;
import ViewPagerTransforms.RotateUpTransformer;
import ViewPagerTransforms.ScaleInOutTransformer;
import ViewPagerTransforms.StackTransformer;
import ViewPagerTransforms.TabletTransformer;

/**
 * Created by Death丶Love on 2016/5/6.
 */
public class PhotoActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private int[] girlPhotos = new int[]{R.mipmap.girl01, R.mipmap.girl02, R.mipmap.girl03, R.mipmap.girl04, R.mipmap.girl05, R.mipmap.girl06,
            R.mipmap.girl07, R.mipmap.girl08, R.mipmap.girl09, R.mipmap.girl10, R.mipmap.girl11, R.mipmap.girl12};
    private ViewPager viewPager;
    private LinearLayout Photo_pointLayout;
    private PhotoViewPagerAdapter adapter;
    private List<ImageView> list;
    private int prePosition = 0;
    private boolean Looper = true;
    private ImageView Photo_return;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setPageTransformer(true, new BackgroundToForegroundTransformer());
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        getSupportActionBar().hide();
        InitViews();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (Looper) {
//                    try {
//                        Thread.sleep(2000);
//                        handler.sendEmptyMessage(0);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

    private void InitViews() {
        viewPager = ((ViewPager) findViewById(R.id.Photo_viewPager));
        Photo_pointLayout = ((LinearLayout) findViewById(R.id.Photo_pointLayout));
        Photo_return = ((ImageView) findViewById(R.id.Photo_return));
        Photo_return.bringToFront();
        Photo_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        list = new ArrayList<>();
        for (int i = 0; i < girlPhotos.length; i++) {

            // 创建数据源
            ImageView iv = new ImageView(this);
            iv.setImageResource(girlPhotos[i]);
            list.add(iv);

            // 往线性布局中添加小圆点
            View view = new View(this);
            // 布局参数:指定宽,高
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(40, 40);
            view.setLayoutParams(params);
            params.leftMargin = 2;
            view.setBackgroundResource(R.mipmap.dot_normal);
            Photo_pointLayout.addView(view);
        }

        Photo_pointLayout.getChildAt(0).setBackgroundResource(R.mipmap.dot_enable);
        adapter = new PhotoViewPagerAdapter(list);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new ScaleInOutTransformer());
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Photo_pointLayout.getChildAt(position % list.size()).setBackgroundResource(R.mipmap.dot_enable);
        Photo_pointLayout.getChildAt(prePosition % list.size()).setBackgroundResource(R.mipmap.dot_normal);
        prePosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
