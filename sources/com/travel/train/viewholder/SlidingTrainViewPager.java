package com.travel.train.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.k;

public final class SlidingTrainViewPager extends ViewPager implements ViewPager.f {

    /* renamed from: a  reason: collision with root package name */
    private float f27735a;

    /* renamed from: b  reason: collision with root package name */
    private int f27736b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27737c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27738d;

    /* renamed from: e  reason: collision with root package name */
    private float f27739e;

    public SlidingTrainViewPager(Context context) {
        this(context, (byte) 0);
    }

    private /* synthetic */ SlidingTrainViewPager(Context context, byte b2) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingTrainViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f27737c = true;
        this.f27739e = 0.5f;
        setClipChildren(false);
        setClipToPadding(false);
        setOverScrollMode(2);
        setPageTransformer(false, this);
        setOffscreenPageLimit(3);
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        k.c(resources, SubAppConfig.AppType.RESOURCE);
        this.f27736b = (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics());
        int i2 = this.f27736b;
        setPadding(i2, 0, i2, 0);
    }

    public final void setAnimationEnabled(boolean z) {
        this.f27737c = z;
    }

    public final void setFadeEnabled(boolean z) {
        this.f27738d = z;
    }

    public final void setFadeFactor(float f2) {
        this.f27739e = f2;
    }

    public final void setPageMargin(int i2) {
        this.f27736b = i2;
        int i3 = this.f27736b;
        setPadding(i3, i3, i3, i3);
    }

    public final void transformPage(View view, float f2) {
        k.c(view, H5Param.PAGE);
        int i2 = this.f27736b;
        if (i2 > 0 && this.f27737c) {
            view.setPadding(i2 / 2, i2 / 2, i2 / 2, i2 / 2);
            if (this.f27735a == 0.0f && f2 > 0.0f && f2 < 1.0f) {
                this.f27735a = f2;
            }
            float f3 = f2 - this.f27735a;
            float abs = Math.abs(f3);
            if (f3 <= -1.0f || f3 >= 1.0f) {
                if (this.f27738d) {
                    view.setAlpha(this.f27739e);
                }
            } else if (f3 == 0.0f) {
                view.setScaleX(this.f27735a + 1.0f);
                view.setScaleY(this.f27735a + 1.0f);
                view.setAlpha(1.0f);
            } else {
                float f4 = 1.0f - abs;
                view.setScaleX((this.f27735a * f4) + 1.0f);
                view.setScaleY((this.f27735a * f4) + 1.0f);
                if (this.f27738d) {
                    view.setAlpha(Math.max(this.f27739e, f4));
                }
            }
        }
    }
}
