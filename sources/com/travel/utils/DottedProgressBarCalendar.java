package com.travel.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.b.f;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.R;
import java.lang.ref.WeakReference;

public class DottedProgressBarCalendar extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f28508a = "DottedProgressBarCalendar";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f28509b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private int f28510c = 6;

    /* renamed from: d  reason: collision with root package name */
    private int f28511d = 8;

    /* renamed from: e  reason: collision with root package name */
    private int f28512e = 3;

    /* renamed from: f  reason: collision with root package name */
    private int f28513f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28514g = false;

    /* renamed from: h  reason: collision with root package name */
    private Context f28515h;

    public DottedProgressBarCalendar(Context context) {
        super(context);
        this.f28515h = context;
        e();
    }

    public DottedProgressBarCalendar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28515h = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CJRTravelDottedProgressBar);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R.styleable.CJRTravelDottedProgressBar_travel_dot_size, -1);
            if (integer != -1) {
                this.f28511d = integer;
            }
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.CJRTravelDottedProgressBar_travel_dot_margin, -1);
            if (integer2 != -1) {
                this.f28510c = integer2;
            }
        }
        e();
    }

    public DottedProgressBarCalendar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28515h = context;
        e();
    }

    public DottedProgressBarCalendar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f28515h = context;
        e();
    }

    private void e() {
        setOrientation(0);
        int applyDimension = (int) TypedValue.applyDimension(1, (float) this.f28511d, getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, (float) this.f28510c, getResources().getDisplayMetrics());
        for (int i2 = 0; i2 < this.f28512e; i2++) {
            View view = new View(this.f28515h.getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(applyDimension, applyDimension);
            layoutParams.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
            view.setLayoutParams(layoutParams);
            view.setBackground(f.a(this.f28515h.getResources(), R.drawable.pre_dotted_progress_bar_item_bg, (Resources.Theme) null));
            addView(view);
        }
    }

    public final void a() {
        try {
            this.f28514g = true;
            b.j();
            this.f28513f = -1;
            f28509b.removeCallbacks((Runnable) null);
            f28509b.post(new a(this.f28514g, this.f28513f, this));
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public final void b() {
        try {
            this.f28514g = false;
            b.j();
            f28509b.removeCallbacksAndMessages((Object) null);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ViewGroup> f28516a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28517b;

        /* renamed from: c  reason: collision with root package name */
        private int f28518c;

        protected a(boolean z, int i2, ViewGroup viewGroup) {
            this.f28517b = z;
            this.f28518c = i2;
            this.f28516a = new WeakReference<>(viewGroup);
        }

        public final void run() {
            if (this.f28517b) {
                try {
                    ViewGroup viewGroup = (ViewGroup) this.f28516a.get();
                    if (viewGroup != null) {
                        b.j();
                        this.f28518c = (this.f28518c + 1) % viewGroup.getChildCount();
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            viewGroup.getChildAt(i2).setSelected(false);
                        }
                        viewGroup.getChildAt(this.f28518c).setSelected(true);
                        DottedProgressBarCalendar.f28509b.postDelayed(new a(this.f28517b, this.f28518c, viewGroup), 300);
                    }
                } catch (Exception e2) {
                    String unused = DottedProgressBarCalendar.f28508a;
                    q.c(e2.getMessage());
                }
            }
        }
    }
}
