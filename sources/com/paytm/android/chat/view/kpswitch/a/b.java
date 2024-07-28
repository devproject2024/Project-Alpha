package com.paytm.android.chat.view.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.paytm.android.chat.R;
import com.paytm.android.chat.view.kpswitch.a;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42592a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42593b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42594c = false;

    /* renamed from: d  reason: collision with root package name */
    private final View f42595d;

    public b(View view, AttributeSet attributeSet) {
        this.f42595d = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.f42593b = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public final boolean a(int i2) {
        if (i2 == 0) {
            this.f42592a = false;
        }
        if (i2 == this.f42595d.getVisibility()) {
            return true;
        }
        if (!this.f42594c || i2 != 0) {
            return false;
        }
        return true;
    }

    public final int[] a(int i2, int i3) {
        if (this.f42592a) {
            this.f42595d.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = makeMeasureSpec;
        }
        return new int[]{i2, i3};
    }

    public final boolean a() {
        return this.f42594c;
    }

    public final boolean b() {
        return !this.f42592a;
    }

    public final void c() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    public final void d() {
        this.f42592a = true;
    }
}
