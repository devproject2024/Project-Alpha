package com.squareup.timessquare.v4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.squareup.timessquare.R;

public class CalendarCellView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f45654b = {R.attr.tsquare_state_selectable};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f45655c = {R.attr.tsquare_state_current_month};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f45656d = {R.attr.tsquare_state_today};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f45657e = {R.attr.tsquare_state_highlighted};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f45658f = {R.attr.tsquare_state_range_first};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f45659g = {R.attr.tsquare_state_range_middle};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f45660h = {R.attr.tsquare_state_range_last};

    /* renamed from: a  reason: collision with root package name */
    public boolean f45661a = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45662i = false;
    private boolean j = false;
    private boolean k = false;
    private f l = f.NONE;
    private TextView m;
    private TextView n;
    private View o;

    public CalendarCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSelectable(boolean z) {
        if (this.f45662i != z) {
            this.f45662i = z;
            refreshDrawableState();
        }
    }

    public void setCurrentMonth(boolean z) {
        if (this.f45661a != z) {
            this.f45661a = z;
            refreshDrawableState();
        }
    }

    public void setToday(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    public void setRangeState(f fVar) {
        if (this.l != fVar) {
            this.l = fVar;
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
        if (this.f45662i) {
            mergeDrawableStates(onCreateDrawableState, f45654b);
        }
        if (this.f45661a) {
            mergeDrawableStates(onCreateDrawableState, f45655c);
        }
        if (this.j) {
            mergeDrawableStates(onCreateDrawableState, f45656d);
        }
        if (this.k) {
            mergeDrawableStates(onCreateDrawableState, f45657e);
        }
        if (this.l == f.FIRST) {
            mergeDrawableStates(onCreateDrawableState, f45658f);
        } else if (this.l == f.MIDDLE) {
            mergeDrawableStates(onCreateDrawableState, f45659g);
        } else if (this.l == f.LAST) {
            mergeDrawableStates(onCreateDrawableState, f45660h);
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
        this.o = view;
    }

    public View getFlightMarker() {
        View view = this.o;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("You have to setFlightMarker in your custom DayViewAdapter.");
    }

    public void setPriceTextView(TextView textView) {
        this.n = textView;
    }

    public TextView getPriceTextview() {
        TextView textView = this.n;
        if (textView != null) {
            return textView;
        }
        throw new IllegalStateException("You have to setDayOfMonthTextView in your custom DayViewAdapter.");
    }
}
