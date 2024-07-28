package com.paytm.android.chat.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class DensityUtil {
    public static int dp2px(float f2) {
        return (int) TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    public static int sp2px(float f2) {
        return (int) TypedValue.applyDimension(2, f2, Resources.getSystem().getDisplayMetrics());
    }

    public static float px2dp(float f2) {
        return f2 / Resources.getSystem().getDisplayMetrics().density;
    }

    public static float px2sp(float f2) {
        return f2 / Resources.getSystem().getDisplayMetrics().scaledDensity;
    }
}
