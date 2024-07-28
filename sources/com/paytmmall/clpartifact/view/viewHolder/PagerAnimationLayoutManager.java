package com.paytmmall.clpartifact.view.viewHolder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PagerAnimationLayoutManager extends LinearLayoutManager {
    private final float mShrinkAmount = 0.15f;
    private final float mShrinkDistance = 1.0f;

    public PagerAnimationLayoutManager(Context context) {
        super(context, 0, false);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (getOrientation() != 1) {
            return 0;
        }
        int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
        float height = ((float) getHeight()) / 2.0f;
        float f2 = height * 1.0f;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            float min = (((Math.min(f2, Math.abs(height - (((float) (getDecoratedBottom(childAt) + getDecoratedTop(childAt))) / 2.0f))) - 0.0f) * -0.14999998f) / (f2 - 0.0f)) + 1.0f;
            childAt.setScaleX(min);
            childAt.setScaleY(min);
        }
        return scrollVerticallyBy;
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (getOrientation() != 0) {
            return 0;
        }
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        float width = ((float) getWidth()) / 2.0f;
        float f2 = width * 1.0f;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            float min = (((Math.min(f2, Math.abs(width - (((float) (getDecoratedRight(childAt) + getDecoratedLeft(childAt))) / 2.0f))) - 0.0f) * -0.14999998f) / (f2 - 0.0f)) + 1.0f;
            childAt.setScaleX(min);
            childAt.setScaleY(min);
        }
        return scrollHorizontallyBy;
    }

    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        super.onLayoutChildren(nVar, sVar);
        scrollVerticallyBy(0, nVar, sVar);
    }
}
