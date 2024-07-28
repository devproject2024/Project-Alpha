package com.squareup.timessquare.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.squareup.timessquare.R;

public class CalendarCellView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f45548a = {R.attr.tsquare_state_selectable};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f45549b = {R.attr.tsquare_state_current_month};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f45550c = {R.attr.tsquare_state_today};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f45551d = {R.attr.tsquare_state_highlighted};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f45552e = {R.attr.tsquare_state_range_first};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f45553f = {R.attr.tsquare_state_range_middle};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f45554g = {R.attr.tsquare_state_range_last};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f45555h = {R.attr.tsquare_state_range_extend};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f45556i = {R.attr.tsquare_state_unavailable};
    private static final int[] j = {R.attr.tsquare_state_deactivated};
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private f q = f.NONE;
    private TextView r;

    public CalendarCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSelectable(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    public void setCurrentMonth(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    public void setToday(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
        }
    }

    public void setRangeState(f fVar) {
        if (this.q != fVar) {
            this.q = fVar;
            refreshDrawableState();
        }
    }

    public void setHighlighted(boolean z) {
        if (this.n != z) {
            this.n = z;
            refreshDrawableState();
        }
    }

    public void setRangeUnavailable(boolean z) {
        if (this.o != z) {
            this.o = z;
            refreshDrawableState();
        }
    }

    public void setDeactivated(boolean z) {
        if (this.p != z) {
            this.p = z;
            refreshDrawableState();
        }
    }

    public f getRangeState() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 5);
        if (this.k && this.q != f.EXTEND) {
            mergeDrawableStates(onCreateDrawableState, f45548a);
        }
        if (this.l && this.q != f.EXTEND) {
            mergeDrawableStates(onCreateDrawableState, f45549b);
        }
        if (this.m) {
            mergeDrawableStates(onCreateDrawableState, f45550c);
        }
        if (this.n && this.q != f.EXTEND) {
            mergeDrawableStates(onCreateDrawableState, f45551d);
        }
        if (this.o && this.q != f.EXTEND) {
            mergeDrawableStates(onCreateDrawableState, f45556i);
        }
        if (this.p && this.q != f.EXTEND) {
            mergeDrawableStates(onCreateDrawableState, j);
        }
        if (this.q == f.FIRST) {
            mergeDrawableStates(onCreateDrawableState, f45552e);
        } else if (this.q == f.MIDDLE) {
            mergeDrawableStates(onCreateDrawableState, f45553f);
        } else if (this.q == f.LAST) {
            mergeDrawableStates(onCreateDrawableState, f45554g);
        } else if (this.q == f.EXTEND) {
            mergeDrawableStates(onCreateDrawableState, f45555h);
        }
        return onCreateDrawableState;
    }

    public void setDayOfMonthTextView(TextView textView) {
        this.r = textView;
    }

    public TextView getDayOfMonthTextView() {
        TextView textView = this.r;
        if (textView != null) {
            return textView;
        }
        throw new IllegalStateException("You have to setDayOfMonthTextView in your custom DayViewAdapter.");
    }
}
