package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.graphics.a;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1828a = {-16842910};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1829b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1830c = {16843518};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1831d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1832e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f1833f = {16842913};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f1834g = {-16842919, -16842908};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f1835h = new int[0];

    /* renamed from: i  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1836i = new ThreadLocal<>();
    private static final int[] j = new int[1];

    public static int a(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        ac a2 = ac.a(context, (AttributeSet) null, iArr);
        try {
            return a2.b(0, 0);
        } finally {
            a2.f1669a.recycle();
        }
    }

    public static ColorStateList b(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        ac a2 = ac.a(context, (AttributeSet) null, iArr);
        try {
            return a2.e(0);
        } finally {
            a2.f1669a.recycle();
        }
    }

    public static int c(Context context, int i2) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null && b2.isStateful()) {
            return b2.getColorForState(f1828a, b2.getDefaultColor());
        }
        TypedValue typedValue = f1836i.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f1836i.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int a2 = a(context, i2);
        return a.b(a2, Math.round(((float) Color.alpha(a2)) * f2));
    }

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
                StringBuilder sb = new StringBuilder("View ");
                sb.append(view.getClass());
                sb.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
