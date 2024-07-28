package com.paytmmall.clpartifact.view.decoration;

import android.graphics.Rect;

class MarginDelegate {
    private final int spaceItem;
    private final int spanCount;

    MarginDelegate(int i2, int i3) {
        this.spanCount = i2;
        this.spaceItem = i3;
    }

    /* access modifiers changed from: package-private */
    public void calculateMargin(Rect rect, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        if (i5 == 1) {
            int i6 = this.spaceItem;
            int i7 = this.spanCount;
            rect.left = (i3 * i6) / i7;
            rect.right = i6 - (((i3 + 1) * i6) / i7);
            if (z) {
                if (i2 >= i7) {
                    rect.bottom = i6;
                }
            } else if (i2 >= i7) {
                rect.top = i6;
            }
        } else if (i5 == 0) {
            int i8 = this.spaceItem;
            int i9 = this.spanCount;
            rect.top = (i3 * i8) / i9;
            rect.bottom = i8 - (((i3 + 1) * i8) / i9);
            if (z) {
                if (i2 >= i9) {
                    rect.right = i8;
                }
            } else if (i2 >= i9) {
                rect.left = i8;
            }
        }
    }
}
