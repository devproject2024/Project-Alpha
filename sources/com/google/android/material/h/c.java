package com.google.android.material.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.appcompat.widget.ac;

public final class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int color;
        int resourceId;
        ColorStateList a2;
        if (typedArray.hasValue(i2) && (resourceId = typedArray.getResourceId(i2, 0)) != 0 && (a2 = a.a(context, resourceId)) != null) {
            return a2;
        }
        if (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i2, -1)) == -1) {
            return typedArray.getColorStateList(i2);
        }
        return ColorStateList.valueOf(color);
    }

    public static ColorStateList a(Context context, ac acVar, int i2) {
        int b2;
        int g2;
        ColorStateList a2;
        if (acVar.g(i2) && (g2 = acVar.g(i2, 0)) != 0 && (a2 = a.a(context, g2)) != null) {
            return a2;
        }
        if (Build.VERSION.SDK_INT > 15 || (b2 = acVar.b(i2, -1)) == -1) {
            return acVar.e(i2);
        }
        return ColorStateList.valueOf(b2);
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable b2;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (b2 = a.b(context, resourceId)) == null) {
            return typedArray.getDrawable(i2);
        }
        return b2;
    }

    public static d c(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static int d(Context context, TypedArray typedArray, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, -1);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }
}
