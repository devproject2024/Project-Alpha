package com.travel.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.paytm.utility.q;
import com.travel.R;

public class CJRDottedProgressBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f28499a = 6;

    /* renamed from: b  reason: collision with root package name */
    private int f28500b = 8;

    /* renamed from: c  reason: collision with root package name */
    private int f28501c = 3;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f28502d = 300;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Handler f28503e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f28504f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f28505g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Runnable f28506h = new Runnable() {
        public final void run() {
            if (CJRDottedProgressBar.this.f28505g) {
                try {
                    int unused = CJRDottedProgressBar.this.f28504f = (CJRDottedProgressBar.this.f28504f + 1) % CJRDottedProgressBar.this.getChildCount();
                    for (int i2 = 0; i2 < CJRDottedProgressBar.this.getChildCount(); i2++) {
                        CJRDottedProgressBar.this.getChildAt(i2).setSelected(false);
                    }
                    CJRDottedProgressBar.this.getChildAt(CJRDottedProgressBar.this.f28504f).setSelected(true);
                    CJRDottedProgressBar.this.f28503e.postDelayed(CJRDottedProgressBar.this.f28506h, CJRDottedProgressBar.this.f28502d);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        }
    };

    public CJRDottedProgressBar(Context context) {
        super(context);
        a();
    }

    public CJRDottedProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CJRDottedProgressBar);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.CJRDottedProgressBar_dot_size, -1);
            if (integer != -1) {
                this.f28500b = integer;
            }
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.CJRDottedProgressBar_dot_margin, -1);
            if (integer2 != -1) {
                this.f28499a = integer2;
            }
        }
        a();
    }

    public CJRDottedProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f28503e = new Handler();
        setOrientation(0);
        int applyDimension = (int) TypedValue.applyDimension(1, (float) this.f28500b, getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, (float) this.f28499a, getResources().getDisplayMetrics());
        for (int i2 = 0; i2 < this.f28501c; i2++) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(applyDimension, applyDimension);
            layoutParams.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.pre_td_travel_dotted_progress_bar_item_bg);
            addView(view);
        }
    }
}
