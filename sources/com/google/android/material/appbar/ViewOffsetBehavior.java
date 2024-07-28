package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset = 0;
    private int tempTopBottomOffset = 0;
    private a viewOffsetHelper;

    public ViewOffsetBehavior() {
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i2) {
        layoutChild(coordinatorLayout, v, i2);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new a(v);
        }
        this.viewOffsetHelper.a();
        this.viewOffsetHelper.b();
        int i3 = this.tempTopBottomOffset;
        if (i3 != 0) {
            this.viewOffsetHelper.a(i3);
            this.tempTopBottomOffset = 0;
        }
        int i4 = this.tempLeftRightOffset;
        if (i4 == 0) {
            return true;
        }
        this.viewOffsetHelper.b(i4);
        this.tempLeftRightOffset = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.b(v, i2);
    }

    public boolean setTopAndBottomOffset(int i2) {
        a aVar = this.viewOffsetHelper;
        if (aVar != null) {
            return aVar.a(i2);
        }
        this.tempTopBottomOffset = i2;
        return false;
    }

    public boolean setLeftAndRightOffset(int i2) {
        a aVar = this.viewOffsetHelper;
        if (aVar != null) {
            return aVar.b(i2);
        }
        this.tempLeftRightOffset = i2;
        return false;
    }

    public int getTopAndBottomOffset() {
        a aVar = this.viewOffsetHelper;
        if (aVar != null) {
            return aVar.f35874b;
        }
        return 0;
    }

    public int getLeftAndRightOffset() {
        a aVar = this.viewOffsetHelper;
        if (aVar != null) {
            return aVar.f35875c;
        }
        return 0;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        a aVar = this.viewOffsetHelper;
        if (aVar != null) {
            aVar.f35876d = z;
        }
    }

    public boolean isVerticalOffsetEnabled() {
        a aVar = this.viewOffsetHelper;
        return aVar != null && aVar.f35876d;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        a aVar = this.viewOffsetHelper;
        if (aVar != null) {
            aVar.f35877e = z;
        }
    }

    public boolean isHorizontalOffsetEnabled() {
        a aVar = this.viewOffsetHelper;
        return aVar != null && aVar.f35877e;
    }
}
