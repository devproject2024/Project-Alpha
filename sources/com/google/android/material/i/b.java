package com.google.android.material.i;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.core.graphics.a;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f36380a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    static final String f36381b = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f36382c = {16842919};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f36383d = {16843623, 16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f36384e = {16842908};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f36385f = {16843623};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f36386g = {16842913, 16842919};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f36387h = {16842913, 16843623, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f36388i = {16842913, 16842908};
    private static final int[] j = {16842913, 16843623};
    private static final int[] k = {16842913};
    private static final int[] l = {16842910, 16842919};

    private b() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f36380a) {
            return new ColorStateList(new int[][]{k, StateSet.NOTHING}, new int[]{a(colorStateList, f36386g), a(colorStateList, f36382c)});
        }
        int[] iArr = f36386g;
        int[] iArr2 = f36387h;
        int[] iArr3 = f36388i;
        int[] iArr4 = j;
        int[] iArr5 = f36382c;
        int[] iArr6 = f36383d;
        int[] iArr7 = f36384e;
        int[] iArr8 = f36385f;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, k, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(l, 0));
        }
        return colorStateList;
    }

    public static boolean a(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f36380a ? a(colorForState) : colorForState;
    }

    private static int a(int i2) {
        return a.b(i2, Math.min(Color.alpha(i2) * 2, PriceRangeSeekBar.INVALID_POINTER_ID));
    }
}
