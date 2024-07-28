package com.paytmmall.clpartifact.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridItemDecoration extends RecyclerView.h {
    private Drawable mDrawable;

    public GridItemDecoration(Context context, int i2) {
        this.mDrawable = b.a(context, i2);
    }

    public GridItemDecoration(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if (((GridLayoutManager) layoutManager).getSpanCount() == 1) {
                drawListDecorator(canvas, recyclerView);
            }
        } else if (layoutManager instanceof LinearLayoutManager) {
            drawListDecorator(canvas, recyclerView);
        }
    }

    private void onDrawChildRight(int i2, Canvas canvas, RecyclerView recyclerView) {
        View childAt = recyclerView.getChildAt(i2);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
        if (layoutParams != null) {
            int right = childAt.getRight() + layoutParams.rightMargin;
            int top = childAt.getTop() - layoutParams.topMargin;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            this.mDrawable.setBounds(right, top, this.mDrawable.getIntrinsicHeight() + right, bottom);
            this.mDrawable.draw(canvas);
        }
    }

    private void onDrawChildBottom(int i2, Canvas canvas, RecyclerView recyclerView, int i3, int i4) {
        View childAt = recyclerView.getChildAt(i2);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
        if (layoutParams != null) {
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            this.mDrawable.setBounds(i3, bottom, i4, this.mDrawable.getIntrinsicHeight() + bottom);
        }
        this.mDrawable.draw(canvas);
    }

    private void drawListDecorator(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            onDrawChildBottom(i2, canvas, recyclerView, paddingLeft, width);
        }
    }
}
