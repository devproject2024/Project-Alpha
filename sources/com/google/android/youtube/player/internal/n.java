package com.google.android.youtube.player.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public final class n extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final ProgressBar f37572a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f37573b;

    public n(Context context) {
        super(context, (AttributeSet) null, aa.c(context));
        q qVar = new q(context);
        setBackgroundColor(-16777216);
        this.f37572a = new ProgressBar(context);
        this.f37572a.setVisibility(8);
        addView(this.f37572a, new FrameLayout.LayoutParams(-2, -2, 17));
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 10.0f) + 0.5f);
        this.f37573b = new TextView(context);
        this.f37573b.setTextAppearance(context, 16973894);
        this.f37573b.setTextColor(-1);
        this.f37573b.setVisibility(8);
        this.f37573b.setPadding(i2, i2, i2, i2);
        this.f37573b.setGravity(17);
        this.f37573b.setText(qVar.f37576a);
        addView(this.f37573b, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    public final void a() {
        this.f37572a.setVisibility(0);
        this.f37573b.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        float f2;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (mode == 1073741824 || (mode == Integer.MIN_VALUE && mode2 == 0)) {
                size2 = (int) (((float) size) / 1.777f);
            } else {
                if (mode2 == 1073741824 || (mode2 == Integer.MIN_VALUE && mode == 0)) {
                    f2 = (float) size2;
                } else if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    f2 = (float) size2;
                    float f3 = ((float) size) / 1.777f;
                    if (f2 >= f3) {
                        size2 = (int) f3;
                    }
                } else {
                    size = 0;
                    size2 = 0;
                }
                size = (int) (f2 * 1.777f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(resolveSize(size, i2), 1073741824), View.MeasureSpec.makeMeasureSpec(resolveSize(size2, i3), 1073741824));
    }
}
