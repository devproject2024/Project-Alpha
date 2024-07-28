package com.squareup.timessquare.v4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.timessquare.v4.MonthView;

public class CalendarRowView extends ViewGroup implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45683a;

    /* renamed from: b  reason: collision with root package name */
    private MonthView.b f45684b;

    public CalendarRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        view.setOnClickListener(this);
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        int size = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            i4++;
            int i6 = ((i4 * size) / 7) - (((i4 + 0) * size) / 7);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            childAt.measure(makeMeasureSpec, this.f45683a ? View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE) : makeMeasureSpec);
            if (childAt.getMeasuredHeight() > i5) {
                i5 = childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(), i5 + getPaddingTop() + getPaddingBottom());
        new Object[1][0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = i5 - i3;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            i8++;
            getChildAt(i8).layout(((i8 + 0) * i7) / 7, 0, (i8 * i7) / 7, i6);
        }
        new Object[1][0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
    }

    public void setIsHeaderRow(boolean z) {
        this.f45683a = z;
    }

    public void onClick(View view) {
        MonthView.b bVar = this.f45684b;
        if (bVar != null) {
            bVar.a((d) view.getTag());
        }
    }

    public void setListener(MonthView.b bVar) {
        this.f45684b = bVar;
    }

    public void setDayViewAdapter(b bVar) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof CalendarCellView) {
                CalendarCellView calendarCellView = (CalendarCellView) getChildAt(i2);
                calendarCellView.removeAllViews();
                bVar.a(calendarCellView);
            }
        }
    }

    public void setCellBackground(int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).setBackgroundResource(i2);
        }
    }

    public void setCellTextColor(int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof CalendarCellView) {
                ((CalendarCellView) getChildAt(i3)).getDayOfMonthTextView().setTextColor(i2);
            } else {
                ((TextView) getChildAt(i3)).setTextColor(i2);
            }
        }
    }

    public void setCellTextColor(ColorStateList colorStateList) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof CalendarCellView) {
                ((CalendarCellView) getChildAt(i2)).getDayOfMonthTextView().setTextColor(colorStateList);
            } else {
                ((TextView) getChildAt(i2)).setTextColor(colorStateList);
            }
        }
    }

    public void setTypeface(Typeface typeface) {
        Typeface create = Typeface.create("sans-serif", 0);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof CalendarCellView) {
                ((CalendarCellView) getChildAt(i2)).getDayOfMonthTextView().setTypeface(create);
            } else {
                ((TextView) getChildAt(i2)).setTypeface(create);
            }
        }
    }
}
