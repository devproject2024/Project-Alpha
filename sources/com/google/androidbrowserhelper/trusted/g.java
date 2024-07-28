package com.google.androidbrowserhelper.trusted;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

public final class g {
    public static void a(Activity activity, int i2) {
        View rootView = activity.getWindow().getDecorView().getRootView();
        rootView.setSystemUiVisibility(i2 | rootView.getSystemUiVisibility());
    }

    public static boolean a(int i2) {
        return Math.abs(1.05f / ((((a((float) Color.red(i2)) * 0.2126f) + (a((float) Color.green(i2)) * 0.7152f)) + (a((float) Color.blue(i2)) * 0.0722f)) + 0.05f)) < 3.0f;
    }

    private static float a(float f2) {
        float f3 = f2 / 255.0f;
        return f3 < 0.03928f ? f3 / 12.92f : (float) Math.pow((double) ((f3 + 0.055f) / 1.055f), 2.4000000953674316d);
    }
}
