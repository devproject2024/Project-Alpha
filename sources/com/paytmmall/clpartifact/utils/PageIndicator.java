package com.paytmmall.clpartifact.utils;

import androidx.viewpager.widget.ViewPager;

public interface PageIndicator extends ViewPager.e {
    void notifyDataSetChanged();

    void setCurrentItem(int i2);

    void setOnPageChangeListener(ViewPager.e eVar);

    void setViewPager(ViewPager viewPager);

    void setViewPager(ViewPager viewPager, int i2);
}
