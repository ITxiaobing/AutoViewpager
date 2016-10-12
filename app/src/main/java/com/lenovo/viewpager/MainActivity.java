package com.lenovo.viewpager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private LinearLayout mLlDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLlDot = (LinearLayout) findViewById(R.id.ll_dot);
        initDot();
        mViewPager = (ViewPager) findViewById(R.id.auto_viewpager);
        mViewPager.setAdapter(new AutoViewpagerAdapter(imageCount, this));
        mHandler.sendEmptyMessageDelayed(0, 4000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imageCount.length; i++) {
                    if (i == position % imageCount.length) {
                        mLlDot.getChildAt(i).setBackgroundResource(R.drawable.selector_button_press);
                    } else {
                        mLlDot.getChildAt(i).setBackgroundResource(R.drawable.selector_button);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initDot() {
        for (int i = 0; i < imageCount.length; i++) {
            TextView view = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(5, 0, 0, 0);
            view.setLayoutParams(layoutParams);
            view.setPadding(5, 5, 5, 5);
            if (i == 0) {
                view.setBackgroundResource(R.drawable.selector_button_press);
            } else {
                view.setBackgroundResource(R.drawable.selector_button);
            }
            mLlDot.addView(view);
        }
    }
}
