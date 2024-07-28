package com.alipay.mobile.nebula.util;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

public class H5DimensionUtil {
    private static final String TAG = "H5DimensionUtil";
    private static float sScale;
    private static float sScaledDensity;
    private static int sScreenHeight;
    private static int sScreenWidth;

    public static float getFontSize(float f2) {
        if (f2 == 0.875f) {
            return 14.0f;
        }
        if (f2 == 1.0f) {
            return 16.0f;
        }
        if (f2 == 1.125f) {
            return 18.0f;
        }
        if (f2 == 1.25f) {
            return 20.0f;
        }
        return f2 == 1.375f ? 22.0f : 16.0f;
    }

    public static boolean isValueEqule(float f2, float f3) {
        return ((int) f2) == ((int) f3);
    }

    public static int dip2px(Context context, float f2) {
        initScale(context);
        return (int) ((f2 * sScale) + 0.5f);
    }

    private static void initScale(Context context) {
        try {
            if (sScale == 0.0f) {
                sScale = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    public static int px2dip(Context context, float f2) {
        initScale(context);
        return (int) ((f2 / sScale) + 0.5f);
    }

    public static int getRelativeTop(View view) {
        if (view.getId() == 16908290) {
            return view.getTop();
        }
        return view.getTop() + getRelativeTop((View) view.getParent());
    }

    public static int getRelativeLeft(View view) {
        if (view.getId() == 16908290) {
            return view.getLeft();
        }
        return view.getLeft() + getRelativeLeft((View) view.getParent());
    }

    public static float px2sp(Context context, float f2) {
        initScaledDensity(context);
        return f2 / sScaledDensity;
    }

    public static int sp2px(Context context, float f2) {
        initScaledDensity(context);
        return (int) ((f2 * sScaledDensity) + 0.5f);
    }

    private static void initScaledDensity(Context context) {
        try {
            if (sScaledDensity == 0.0f) {
                sScaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    public static int getScreenWidth(Context context) {
        int i2 = sScreenWidth;
        if (i2 != 0) {
            return i2;
        }
        int width = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
        sScreenWidth = width;
        return width;
    }

    public static int getScreenHeight(Context context) {
        int i2 = sScreenHeight;
        if (i2 != 0) {
            return i2;
        }
        int height = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
        sScreenHeight = height;
        return height;
    }
}
