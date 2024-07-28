package net.one97.paytm.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.paytm.utility.b;
import com.paytm.utility.q;
import net.one97.paytm.common.widgets.R;

public class CJRDottedProgressBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f69551a = 6;

    /* renamed from: b  reason: collision with root package name */
    private int f69552b = 8;

    /* renamed from: c  reason: collision with root package name */
    private int f69553c = 3;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f69554d = 300;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Handler f69555e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f69556f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f69557g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Runnable f69558h = new Runnable() {
        public final void run() {
            if (CJRDottedProgressBar.this.f69557g) {
                try {
                    int unused = CJRDottedProgressBar.this.f69556f = (CJRDottedProgressBar.this.f69556f + 1) % CJRDottedProgressBar.this.getChildCount();
                    for (int i2 = 0; i2 < CJRDottedProgressBar.this.getChildCount(); i2++) {
                        CJRDottedProgressBar.this.getChildAt(i2).setSelected(false);
                    }
                    CJRDottedProgressBar.this.getChildAt(CJRDottedProgressBar.this.f69556f).setSelected(true);
                    CJRDottedProgressBar.this.f69555e.postDelayed(CJRDottedProgressBar.this.f69558h, CJRDottedProgressBar.this.f69554d);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
        }
    };

    public CJRDottedProgressBar(Context context) {
        super(context);
        c();
    }

    public CJRDottedProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CJRDottedProgressBar);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.CJRDottedProgressBar_dot_size, -1);
            if (integer != -1) {
                this.f69552b = integer;
            }
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.CJRDottedProgressBar_dot_margin, -1);
            if (integer2 != -1) {
                this.f69551a = integer2;
            }
        }
        c();
    }

    public CJRDottedProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    public CJRDottedProgressBar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        c();
    }

    private void c() {
        this.f69555e = new Handler();
        setOrientation(0);
        int applyDimension = (int) TypedValue.applyDimension(1, (float) this.f69552b, getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, (float) this.f69551a, getResources().getDisplayMetrics());
        for (int i2 = 0; i2 < this.f69553c; i2++) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(applyDimension, applyDimension);
            layoutParams.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.dotted_progress_bar_item_bg);
            addView(view);
        }
    }

    public final void a() {
        try {
            this.f69557g = true;
            b.j();
            this.f69556f = -1;
            this.f69555e.removeCallbacks(this.f69558h);
            this.f69555e.post(this.f69558h);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final void b() {
        try {
            this.f69557g = false;
            b.j();
            this.f69555e.removeCallbacks(this.f69558h);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}
