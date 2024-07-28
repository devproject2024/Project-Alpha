package com.alipay.mobile.nebulacore.dev.bugme;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;

public class H5BugMeViewPageAdapter extends a {
    private H5BugmeConsole mDebugConsole;

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public H5BugMeViewPageAdapter(H5BugmeConsole h5BugmeConsole) {
        this.mDebugConsole = h5BugmeConsole;
    }

    public int getCount() {
        return this.mDebugConsole.getTabSize();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View subContentView = this.mDebugConsole.getSubContentView(i2);
        viewGroup.addView(subContentView);
        return subContentView;
    }

    public CharSequence getPageTitle(int i2) {
        return H5BugmeConsole.LOG_KEYS[i2];
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
