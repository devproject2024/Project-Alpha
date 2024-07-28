package com.squareup.timessquare.v3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.timessquare.R;

public class CalendarGridView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f45609a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private int f45610b;

    /* renamed from: c  reason: collision with root package name */
    private int f45611c;

    public CalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45609a.setStrokeWidth(5.0f);
        this.f45609a.setColor(getResources().getColor(R.color.creamy_white));
    }

    public void setDividerColor(int i2) {
        this.f45609a.setStrokeWidth(5.0f);
        this.f45609a.setColor(i2);
    }

    public void setDayViewAdapter(b bVar) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((CalendarRowView) getChildAt(i2)).setDayViewAdapter(bVar);
        }
    }

    public void setDayBackground(int i2) {
        for (int i3 = 1; i3 < getChildCount(); i3++) {
            ((CalendarRowView) getChildAt(i3)).setCellBackground(i2);
        }
    }

    public void setDayTextColor(int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ((CalendarRowView) getChildAt(i3)).setCellTextColor(getResources().getColorStateList(i2));
        }
    }

    public void setDisplayHeader(boolean z) {
        int i2 = 0;
        View childAt = getChildAt(0);
        if (!z) {
            i2 = 8;
        }
        childAt.setVisibility(i2);
    }

    public void setHeaderTextColor(int i2) {
        ((CalendarRowView) getChildAt(0)).setCellTextColor(i2);
    }

    public void setTypeface(Typeface typeface) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((CalendarRowView) getChildAt(i2)).setTypeface(Typeface.create("sans-serif", 0));
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 0) {
            ((CalendarRowView) view).setIsHeaderRow(true);
        }
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        ViewGroup viewGroup = (ViewGroup) getChildAt(1);
        int top = viewGroup.getTop();
        int bottom = getBottom();
        int left = viewGroup.getChildAt(0).getLeft() + getLeft();
        float f2 = ((float) left) + 0.5f;
        float f3 = (float) top;
        float f4 = (float) bottom;
        canvas.drawLine(f2, f3, f2, f4, this.f45609a);
        for (int i2 = 0; i2 < 7; i2++) {
            float right = ((float) (viewGroup.getChildAt(i2).getRight() + left)) - 0.5f;
            canvas.drawLine(right, f3, right, f4, this.f45609a);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        float bottom = (float) (view.getBottom() - 1);
        canvas.drawLine((float) view.getLeft(), bottom, (float) (view.getRight() - 2), bottom, this.f45609a);
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        Object[] objArr = {View.MeasureSpec.toString(i2), View.MeasureSpec.toString(i3)};
        int size = View.MeasureSpec.getSize(i2);
        if (this.f45610b == size) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f45610b = size;
        int i4 = size / 7;
        int i5 = i4 * 7;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0) {
                if (i7 == 0) {
                    measureChild(childAt, makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE));
                } else {
                    measureChild(childAt, makeMeasureSpec, makeMeasureSpec2);
                }
                i6 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(i5 + 2, i6);
        new Object[1][0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        long currentTimeMillis = System.currentTimeMillis();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            int measuredHeight = childAt.getMeasuredHeight() + i7;
            childAt.layout(i2, i7, i4, measuredHeight);
            i6++;
            i7 = measuredHeight;
        }
        new Object[1][0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
    }

    public void setNumRows(int i2) {
        if (this.f45611c != i2) {
            this.f45610b = 0;
        }
        this.f45611c = i2;
    }
}
