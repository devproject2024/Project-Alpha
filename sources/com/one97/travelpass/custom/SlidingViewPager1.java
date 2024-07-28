package com.one97.travelpass.custom;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.k;

public final class SlidingViewPager1 extends ViewPager implements ViewPager.f {

    /* renamed from: a  reason: collision with root package name */
    private float f21353a;

    /* renamed from: b  reason: collision with root package name */
    private int f21354b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21355c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21356d;

    /* renamed from: e  reason: collision with root package name */
    private float f21357e;

    public SlidingViewPager1(Context context) {
        this(context, (byte) 0);
    }

    private /* synthetic */ SlidingViewPager1(Context context, byte b2) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingViewPager1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f21355c = true;
        this.f21357e = 0.5f;
        setClipChildren(false);
        setClipToPadding(false);
        setOverScrollMode(2);
        setPageTransformer(false, this);
        setOffscreenPageLimit(3);
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        k.c(resources, SubAppConfig.AppType.RESOURCE);
        this.f21354b = (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics());
        int i2 = this.f21354b;
        setPadding(i2, 0, i2, 0);
    }

    public final void setAnimationEnabled(boolean z) {
        this.f21355c = z;
    }

    public final void setFadeEnabled(boolean z) {
        this.f21356d = z;
    }

    public final void setFadeFactor(float f2) {
        this.f21357e = f2;
    }

    public final void setPageMargin(int i2) {
        this.f21354b = i2;
        int i3 = this.f21354b;
        setPadding(i3, i3, i3, i3);
    }

    public final void transformPage(View view, float f2) {
        k.c(view, H5Param.PAGE);
        int i2 = this.f21354b;
        if (i2 > 0 && this.f21355c) {
            view.setPadding(i2 / 2, i2 / 2, i2 / 2, i2 / 2);
            if (this.f21353a == 0.0f && f2 > 0.0f && f2 < 1.0f) {
                this.f21353a = f2;
            }
            float f3 = f2 - this.f21353a;
            float abs = Math.abs(f3);
            if (f3 <= -1.0f || f3 >= 1.0f) {
                if (this.f21356d) {
                    view.setAlpha(this.f21357e);
                }
            } else if (f3 == 0.0f) {
                view.setScaleX(this.f21353a + 1.0f);
                view.setScaleY(this.f21353a + 1.0f);
                view.setAlpha(1.0f);
            } else {
                float f4 = 1.0f - abs;
                view.setScaleX((this.f21353a * f4) + 1.0f);
                view.setScaleY((this.f21353a * f4) + 1.0f);
                if (this.f21356d) {
                    view.setAlpha(Math.max(this.f21357e, f4));
                }
            }
        }
    }
}
