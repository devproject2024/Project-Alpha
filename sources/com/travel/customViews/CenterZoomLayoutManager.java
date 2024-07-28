package com.travel.customViews;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class CenterZoomLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    final float f23406a = 0.05f;

    /* renamed from: b  reason: collision with root package name */
    final float f23407b = 0.9f;

    public CenterZoomLayoutManager(Context context) {
        super(context, 0, false);
    }

    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        k.c(nVar, "recycler");
        k.c(sVar, "state");
        if (getOrientation() != 0) {
            return 0;
        }
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        float width = ((float) getWidth()) / 2.0f;
        float f2 = this.f23407b * width;
        float f3 = 1.0f - this.f23406a;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt == null) {
                k.a();
            }
            float min = (((f3 - 1.0f) * (Math.min(f2, Math.abs(width - (((float) (getDecoratedRight(childAt) + getDecoratedLeft(childAt))) / 2.0f))) - 0.0f)) / (f2 - 0.0f)) + 1.0f;
            childAt.setScaleX(min);
            childAt.setScaleY(min);
        }
        return scrollHorizontallyBy;
    }
}
