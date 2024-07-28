package com.alipay.mobile.nebula.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class H5TabbarLayout extends LinearLayout {
    private int selectedIndex;
    /* access modifiers changed from: private */
    public H5TabListener tabListener;
    private List<View> tabs = new ArrayList();

    public interface H5TabListener {
        void onTabItemClicked(int i2, View view);
    }

    public H5TabbarLayout(Context context) {
        super(context);
        initConfig();
    }

    public H5TabbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initConfig();
    }

    public H5TabbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initConfig();
    }

    private void initConfig() {
        setOrientation(0);
    }

    public void addTab(final View view) {
        List<View> list = this.tabs;
        if (list != null) {
            final int size = list.size();
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (H5TabbarLayout.this.tabListener != null) {
                        H5TabbarLayout.this.tabListener.onTabItemClicked(size, view);
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            view.setClickable(true);
            view.setFocusable(true);
            this.tabs.add(view);
            addView(view);
        }
    }

    public void setTabListener(H5TabListener h5TabListener) {
        this.tabListener = h5TabListener;
    }

    private void unselectAll() {
        List<View> list = this.tabs;
        if (list != null) {
            for (View selected : list) {
                selected.setSelected(false);
            }
        }
    }

    public void selectTab(int i2) {
        List<View> list = this.tabs;
        if (list != null) {
            if (i2 >= list.size()) {
                i2 = 0;
            }
            unselectAll();
            this.tabs.get(i2).setSelected(true);
            this.selectedIndex = i2;
        }
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public int getTabSize() {
        List<View> list = this.tabs;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
