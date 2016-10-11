package com.lenovo.viewpager;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private int[] imageCount = {R.drawable.ic_launcher, R.drawable.beijing, R.drawable.bg, R.drawable.bg_sunshine};
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            mHandler.sendEmptyMessageDelayed(0, 4000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.auto_viewpager);
        mViewPager.setAdapter(new AutoViewpagerAdapter(imageCount, this));
        mHandler.sendEmptyMessageDelayed(0, 4000);
    }
}
