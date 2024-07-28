package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import kotlin.g.b.k;
import kotlin.u;

public final class VerticalDividerItemDecorator extends RecyclerView.h {
    private final Drawable mDivider;

    public VerticalDividerItemDecorator(Drawable drawable) {
        k.c(drawable, "mDivider");
        this.mDivider = drawable;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(canvas, "c");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        super.onDrawOver(canvas, recyclerView, sVar);
        int childCount = recyclerView.getChildCount() - 2;
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = recyclerView.getChildAt(i2);
                k.a((Object) childAt, "parent.getChildAt(i)");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    int top = childAt.getTop() + a.a(6);
                    int bottom = childAt.getBottom() - a.a(6);
                    int right = childAt.getRight() + ((RecyclerView.LayoutParams) layoutParams).rightMargin;
                    this.mDivider.setBounds(right, top, this.mDivider.getIntrinsicWidth() + right, bottom);
                    this.mDivider.draw(canvas);
                    if (i2 != childCount) {
                        i2++;
                    } else {
                        return;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
        }
    }
}
