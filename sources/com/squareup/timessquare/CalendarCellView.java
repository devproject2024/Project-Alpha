package com.squareup.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.squareup.timessquare.d;

public class CalendarCellView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f45494a = {R.attr.tsquare_state_selectable};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f45495b = {R.attr.tsquare_state_current_month};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f45496c = {R.attr.tsquare_state_today};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f45497d = {R.attr.tsquare_state_highlighted};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f45498e = {R.attr.tsquare_state_range_first};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f45499f = {R.attr.tsquare_state_range_middle};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f45500g = {R.attr.tsquare_state_range_last};

    /* renamed from: h  reason: collision with root package name */
    private boolean f45501h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45502i = false;
    private boolean j = false;
    private boolean k = false;
    private d.a l = d.a.NONE;
    private TextView m;
    private View n;

    public CalendarCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSelectable(boolean z) {
        if (this.f45501h != z) {
            this.f45501h = z;
            refreshDrawableState();
        }
    }

    public void setCurrentMonth(boolean z) {
        if (this.f45502i != z) {
            this.f45502i = z;
            refreshDrawableState();
        }
    }

    public void setToday(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    public void setRangeState(d.a aVar) {
        if (this.l != aVar) {
            this.l = aVar;
            refreshDrawableState();
        }
    }

    public void setHighlighted(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 15);
        if (this.f45501h) {
            mergeDrawableStates(onCreateDrawableState, f45494a);
        }
        if (this.f45502i) {
            mergeDrawableStates(onCreateDrawableState, f45495b);
        }
        if (this.j) {
            mergeDrawableStates(onCreateDrawableState, f45496c);
        }
        if (this.k) {
            mergeDrawableStates(onCreateDrawableState, f45497d);
        }
        if (this.l == d.a.FIRST) {
            mergeDrawableStates(onCreateDrawableState, f45498e);
        } else if (this.l == d.a.MIDDLE) {
            mergeDrawableStates(onCreateDrawableState, f45499f);
        } else if (this.l == d.a.LAST) {
            mergeDrawableStates(onCreateDrawableState, f45500g);
        }
        return onCreateDrawableState;
    }

    public void setDayOfMonthTextView(TextView textView) {
        this.m = textView;
    }

    public TextView getDayOfMonthTextView() {
        TextView textView = this.m;
        if (textView != null) {
            return textView;
        }
        throw new IllegalStateException("You have to setDayOfMonthTextView in your custom DayViewAdapter.");
    }

    public void setFlightMarker(View view) {
        this.n = view;
    }

    public View getFlightMarker() {
        View view = this.n;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("You have to setFlightMarker in your custom DayViewAdapter.");
    }
}
