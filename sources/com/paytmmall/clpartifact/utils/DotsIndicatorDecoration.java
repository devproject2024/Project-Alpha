package com.paytmmall.clpartifact.utils;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.adapter.BannerItemRVAdapter;

public class DotsIndicatorDecoration extends RecyclerView.h {
    private static final int INTDICATOR_THRESHOLD = 20;
    private final Paint activePaint;
    private int gapInPx;
    private final Paint inactivePaint;
    private final int indicatorHeight;
    private final int indicatorItemPadding;
    private final int radius;

    public DotsIndicatorDecoration(int i2, int i3, int i4, int i5, int i6) {
        this.inactivePaint = new Paint();
        this.activePaint = new Paint();
        float f2 = Resources.getSystem().getDisplayMetrics().density * 1.0f;
        this.radius = i2;
        this.inactivePaint.setStrokeCap(Paint.Cap.ROUND);
        this.inactivePaint.setStrokeWidth(f2);
        this.inactivePaint.setStyle(Paint.Style.STROKE);
        this.inactivePaint.setAntiAlias(true);
        this.inactivePaint.setColor(i5);
        this.activePaint.setStrokeCap(Paint.Cap.ROUND);
        this.activePaint.setStrokeWidth(f2);
        this.activePaint.setStyle(Paint.Style.FILL);
        this.activePaint.setAntiAlias(true);
        this.activePaint.setColor(i6);
        this.indicatorItemPadding = i3;
        this.indicatorHeight = i4 * 5;
    }

    public DotsIndicatorDecoration(int i2, int i3, int i4, int i5, int i6, int i7) {
        this(i2, i3, i4, i5, i6);
        this.gapInPx = i7;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        super.onDrawOver(canvas, recyclerView, sVar);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int actualCount = adapter instanceof BannerItemRVAdapter ? ((BannerItemRVAdapter) adapter).getActualCount() : adapter.getItemCount();
            float width = (((float) recyclerView.getWidth()) - (((float) ((this.radius * 2) * actualCount)) + ((float) (Math.max(0, actualCount - 1) * this.indicatorItemPadding)))) / 2.0f;
            int measuredHeight = recyclerView.getMeasuredHeight();
            int i3 = this.gapInPx;
            if (i3 <= 0) {
                i3 = this.indicatorHeight - 20;
            }
            float f2 = (float) (measuredHeight - i3);
            drawInactiveDots(canvas, width, f2, actualCount);
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                i2 = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                i2 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            } else {
                return;
            }
            if (i2 != -1 && recyclerView.getLayoutManager().findViewByPosition(i2) != null) {
                if (i2 >= actualCount) {
                    i2 %= actualCount;
                }
                drawActiveDot(canvas, width, f2, i2);
            }
        }
    }

    private void drawInactiveDots(Canvas canvas, float f2, float f3, int i2) {
        int i3 = this.radius;
        float f4 = (float) ((i3 * 2) + this.indicatorItemPadding);
        float f5 = f2 + ((float) i3);
        for (int i4 = 0; i4 < i2; i4++) {
            canvas.drawCircle(f5, f3, (float) this.radius, this.inactivePaint);
            f5 += f4;
        }
    }

    private void drawActiveDot(Canvas canvas, float f2, float f3, int i2) {
        int i3 = this.radius;
        canvas.drawCircle(f2 + ((float) i3) + (((float) ((i3 * 2) + this.indicatorItemPadding)) * ((float) i2)), f3, (float) i3, this.activePaint);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
        rect.bottom = this.indicatorHeight;
    }
}
