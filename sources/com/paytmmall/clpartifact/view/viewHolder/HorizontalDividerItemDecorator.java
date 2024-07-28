package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;

public final class HorizontalDividerItemDecorator extends RecyclerView.h {
    private final Drawable mDivider;
    private final int spanCount;

    public HorizontalDividerItemDecorator(Drawable drawable, int i2) {
        k.c(drawable, "mDivider");
        this.mDivider = drawable;
        this.spanCount = i2;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(canvas, "c");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        super.onDrawOver(canvas, recyclerView, sVar);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int i2 = this.spanCount;
        while (i2 < childCount) {
            View childAt = recyclerView.getChildAt(i2);
            k.a((Object) childAt, "parent.getChildAt(i)");
            if (childAt.getLayoutParams() != null) {
                int top = childAt.getTop();
                this.mDivider.setBounds(paddingLeft, top, width, this.mDivider.getIntrinsicHeight() + top);
                this.mDivider.draw(canvas);
                i2++;
            } else {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }
}
