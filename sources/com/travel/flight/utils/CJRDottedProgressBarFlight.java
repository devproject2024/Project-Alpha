package com.travel.flight.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.b;
import com.paytm.utility.q;
import com.travel.flight.R;

public class CJRDottedProgressBarFlight extends LinearLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final Handler f25569d = new Handler();

    /* renamed from: a  reason: collision with root package name */
    private int f25570a = 6;

    /* renamed from: b  reason: collision with root package name */
    private int f25571b = 8;

    /* renamed from: c  reason: collision with root package name */
    private int f25572c = 3;

    /* renamed from: e  reason: collision with root package name */
    private int f25573e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25574f = false;

    /* renamed from: g  reason: collision with root package name */
    private Context f25575g;

    public CJRDottedProgressBarFlight(Context context) {
        super(context);
        this.f25575g = context;
        a();
    }

    public CJRDottedProgressBarFlight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25575g = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CJRDottedProgressBarFlight);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.CJRDottedProgressBarFlight_dot_size, -1);
            if (integer != -1) {
                this.f25571b = integer;
            }
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.CJRDottedProgressBarFlight_dot_margin, -1);
            if (integer2 != -1) {
                this.f25570a = integer2;
            }
        }
        a();
    }

    public CJRDottedProgressBarFlight(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25575g = context;
        a();
    }

    private void a() {
        setOrientation(0);
        int applyDimension = (int) TypedValue.applyDimension(1, (float) this.f25571b, getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, (float) this.f25570a, getResources().getDisplayMetrics());
        for (int i2 = 0; i2 < this.f25572c; i2++) {
            View view = new View(this.f25575g.getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(applyDimension, applyDimension);
            layoutParams.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
            view.setLayoutParams(layoutParams);
            view.setBackground(b.a(this.f25575g, R.drawable.pre_f_flight_dotted_progress_bar_item_bg));
            addView(view);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            this.f25574f = false;
            com.paytm.utility.b.j();
            f25569d.removeCallbacksAndMessages((Object) null);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        super.onDetachedFromWindow();
    }
}
