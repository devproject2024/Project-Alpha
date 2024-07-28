package com.paytmmall.clpartifact.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SlidingViewPager extends ViewPager implements ViewPager.f {
    private float MAX_SCALE;
    private HashMap _$_findViewCache;
    private boolean animationEnabled;
    private boolean fadeEnabled;
    private float fadeFactor;
    private int mHorizontalPageMargin;
    private int mPageMargin;

    public SlidingViewPager(Context context) {
        this(context, (AttributeSet) null, 2, (g) null);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SlidingViewPager(Context context, AttributeSet attributeSet, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.animationEnabled = true;
        this.fadeFactor = 0.5f;
        setClipChildren(false);
        setClipToPadding(false);
        setOverScrollMode(2);
        setPageTransformer(false, this);
        setOffscreenPageLimit(1);
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        this.mPageMargin = dp2px(resources, 20);
        Resources resources2 = context.getResources();
        k.a((Object) resources2, "context.resources");
        this.mHorizontalPageMargin = dp2px(resources2, 32);
        int i2 = this.mHorizontalPageMargin;
        setPadding(i2, 0, i2, 0);
    }

    public final int dp2px(Resources resources, int i2) {
        k.c(resources, SubAppConfig.AppType.RESOURCE);
        return (int) TypedValue.applyDimension(1, (float) i2, resources.getDisplayMetrics());
    }

    public final void setAnimationEnabled(boolean z) {
        this.animationEnabled = z;
    }

    public final void setFadeEnabled(boolean z) {
        this.fadeEnabled = z;
    }

    public final void setFadeFactor(float f2) {
        this.fadeFactor = f2;
    }

    public final void setPageMargin(int i2) {
        this.mPageMargin = i2;
        int i3 = this.mHorizontalPageMargin;
        int i4 = this.mPageMargin;
        setPadding(i3, i4, i3, i4);
    }

    public final void transformPage(View view, float f2) {
        k.c(view, H5Param.PAGE);
        if (getAdapter() != null) {
            a adapter = getAdapter();
            if (adapter == null) {
                k.a();
            }
            k.a((Object) adapter, "adapter!!");
            if (adapter.getCount() == 1) {
                return;
            }
        }
        int i2 = this.mPageMargin;
        if (i2 > 0 && this.animationEnabled) {
            int i3 = this.mHorizontalPageMargin;
            view.setPadding(i3 / 2, i2 / 2, i3 / 2, i2 / 2);
            if (this.MAX_SCALE == 0.0f && f2 > 0.0f && f2 < 1.0f) {
                this.MAX_SCALE = f2;
            }
            float f3 = f2 - this.MAX_SCALE;
            float abs = Math.abs(f3);
            if (f3 <= -1.0f || f3 >= 1.0f) {
                if (this.fadeEnabled) {
                    view.setAlpha(this.fadeFactor);
                }
            } else if (f3 == 0.0f) {
                view.setScaleX((this.MAX_SCALE * 1.5f) + 1.0f);
                view.setScaleY((this.MAX_SCALE * 1.5f) + 1.0f);
                view.setAlpha(1.0f);
            } else {
                float f4 = 1.0f - abs;
                view.setScaleX((this.MAX_SCALE * 1.5f * f4) + 1.0f);
                view.setScaleY((this.MAX_SCALE * 1.5f * f4) + 1.0f);
                if (this.fadeEnabled) {
                    view.setAlpha(Math.max(this.fadeFactor, f4));
                }
            }
        }
    }
}
