package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.core.content.b.f;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public final TypedArray f1669a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1670b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1671c;

    public static ac a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ac(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ac a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new ac(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public static ac a(Context context, int i2, int[] iArr) {
        return new ac(context, context.obtainStyledAttributes(i2, iArr));
    }

    private ac(Context context, TypedArray typedArray) {
        this.f1670b = context;
        this.f1669a = typedArray;
    }

    public final Drawable a(int i2) {
        int resourceId;
        if (!this.f1669a.hasValue(i2) || (resourceId = this.f1669a.getResourceId(i2, 0)) == 0) {
            return this.f1669a.getDrawable(i2);
        }
        return a.b(this.f1670b, resourceId);
    }

    public final Drawable b(int i2) {
        int resourceId;
        if (!this.f1669a.hasValue(i2) || (resourceId = this.f1669a.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return f.b().b(this.f1670b, resourceId);
    }

    public final Typeface a(int i2, int i3, f.a aVar) {
        int resourceId = this.f1669a.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1671c == null) {
            this.f1671c = new TypedValue();
        }
        return f.a(this.f1670b, resourceId, this.f1671c, i3, aVar);
    }

    public final CharSequence c(int i2) {
        return this.f1669a.getText(i2);
    }

    public final String d(int i2) {
        return this.f1669a.getString(i2);
    }

    public final boolean a(int i2, boolean z) {
        return this.f1669a.getBoolean(i2, z);
    }

    public final int a(int i2, int i3) {
        return this.f1669a.getInt(i2, i3);
    }

    public final float a(int i2, float f2) {
        return this.f1669a.getFloat(i2, f2);
    }

    public final int b(int i2, int i3) {
        return this.f1669a.getColor(i2, i3);
    }

    public final ColorStateList e(int i2) {
        int resourceId;
        ColorStateList a2;
        if (!this.f1669a.hasValue(i2) || (resourceId = this.f1669a.getResourceId(i2, 0)) == 0 || (a2 = a.a(this.f1670b, resourceId)) == null) {
            return this.f1669a.getColorStateList(i2);
        }
        return a2;
    }

    public final int c(int i2, int i3) {
        return this.f1669a.getInteger(i2, i3);
    }

    public final float f(int i2) {
        return this.f1669a.getDimension(i2, -1.0f);
    }

    public final int d(int i2, int i3) {
        return this.f1669a.getDimensionPixelOffset(i2, i3);
    }

    public final int e(int i2, int i3) {
        return this.f1669a.getDimensionPixelSize(i2, i3);
    }

    public final int f(int i2, int i3) {
        return this.f1669a.getLayoutDimension(i2, i3);
    }

    public final int g(int i2, int i3) {
        return this.f1669a.getResourceId(i2, i3);
    }

    public final boolean g(int i2) {
        return this.f1669a.hasValue(i2);
    }
}
