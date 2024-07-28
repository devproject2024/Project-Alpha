package com.travel.customViews;

import android.content.res.Resources;

public final class c {
    public static int a(int i2) {
        return (int) (((float) i2) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int a() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
