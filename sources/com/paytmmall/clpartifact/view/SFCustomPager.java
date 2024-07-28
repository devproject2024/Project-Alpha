package com.paytmmall.clpartifact.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import kotlin.g.b.k;

public final class SFCustomPager extends ViewPager {
    private HashMap _$_findViewCache;
    private boolean isAutoScrollingEnabled;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SFCustomPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attributeSet");
    }

    public final boolean isAutoScrollingEnabled() {
        return this.isAutoScrollingEnabled;
    }

    public final void setAutoScrollingEnabled(boolean z) {
        this.isAutoScrollingEnabled = z;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getCurrentItem() > 0 && this.isAutoScrollingEnabled) {
            setCurrentItem(getCurrentItem() - 1);
            setCurrentItem(getCurrentItem() + 1);
        }
    }
}
