package com.one97.travelpass.custom;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SlidingViewPager extends ViewPager implements ViewPager.f {

    /* renamed from: a  reason: collision with root package name */
    private float f21348a;

    /* renamed from: b  reason: collision with root package name */
    private int f21349b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21350c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21351d;

    /* renamed from: e  reason: collision with root package name */
    private float f21352e;

    public SlidingViewPager(Context context) {
        this(context, (AttributeSet) null, 2, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SlidingViewPager(Context context, AttributeSet attributeSet, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f21350c = true;
        this.f21352e = 0.5f;
        setClipChildren(false);
        setClipToPadding(false);
        setOverScrollMode(2);
        setPageTransformer(false, this);
        setOffscreenPageLimit(3);
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        k.c(resources, SubAppConfig.AppType.RESOURCE);
        this.f21349b = (int) TypedValue.applyDimension(1, 35.0f, resources.getDisplayMetrics());
        int i2 = this.f21349b;
        setPadding(i2, 0, i2, 0);
    }

    public final void setPageMargin(int i2) {
        this.f21349b = i2;
        int i3 = this.f21349b;
        setPadding(i3, i3, i3, i3);
    }

    public final void transformPage(View view, float f2) {
        k.c(view, H5Param.PAGE);
        int i2 = this.f21349b;
        if (i2 > 0 && this.f21350c) {
            view.setPadding(i2 / 3, i2 / 3, i2 / 3, i2 / 3);
            if (this.f21348a == 0.0f && f2 > 0.0f && f2 < 1.0f) {
                this.f21348a = f2;
            }
            float f3 = f2 - this.f21348a;
            float abs = Math.abs(f3);
            if (f3 <= -1.0f || f3 >= 1.0f) {
                if (this.f21351d) {
                    view.setAlpha(this.f21352e);
                }
            } else if (f3 == 0.0f) {
                view.setScaleX(this.f21348a + 1.0f);
                view.setScaleY(this.f21348a + 1.0f);
                view.setAlpha(1.0f);
            } else {
                float f4 = 1.0f - abs;
                view.setScaleX((this.f21348a * f4) + 1.0f);
                view.setScaleY((this.f21348a * f4) + 1.0f);
                if (this.f21351d) {
                    view.setAlpha(Math.max(this.f21352e, f4));
                }
            }
        }
    }
}
