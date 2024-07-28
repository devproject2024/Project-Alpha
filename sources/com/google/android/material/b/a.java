package com.google.android.material.b;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import com.google.android.material.h.b;

public final class a {
    public static int a(Context context, int i2) {
        TypedValue a2 = b.a(context, i2);
        if (a2 != null) {
            return a2.data;
        }
        return 0;
    }

    public static int a(int i2, int i3, float f2) {
        return androidx.core.graphics.a.a(androidx.core.graphics.a.b(i3, Math.round(((float) Color.alpha(i3)) * f2)), i2);
    }
}
