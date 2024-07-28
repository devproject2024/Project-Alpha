package com.paytmmall.clpartifact.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class InfiniteGridCustomRecyclerview extends RecyclerView {
    public InfiniteGridCustomRecyclerview(Context context) {
        super(context);
    }

    public InfiniteGridCustomRecyclerview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InfiniteGridCustomRecyclerview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
