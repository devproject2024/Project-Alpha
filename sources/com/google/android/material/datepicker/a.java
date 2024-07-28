package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.core.g.f;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.h.c;
import com.google.android.material.k.h;
import com.google.android.material.k.m;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final Rect f36178a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f36179b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f36180c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f36181d;

    /* renamed from: e  reason: collision with root package name */
    private final int f36182e;

    /* renamed from: f  reason: collision with root package name */
    private final m f36183f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, m mVar, Rect rect) {
        f.a(rect.left);
        f.a(rect.top);
        f.a(rect.right);
        f.a(rect.bottom);
        this.f36178a = rect;
        this.f36179b = colorStateList2;
        this.f36180c = colorStateList;
        this.f36181d = colorStateList3;
        this.f36182e = i2;
        this.f36183f = mVar;
    }

    static a a(Context context, int i2) {
        if (i2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.MaterialCalendarItem);
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
            ColorStateList a2 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
            ColorStateList a3 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
            ColorStateList a4 = c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
            m a5 = m.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
            obtainStyledAttributes.recycle();
            return new a(a2, a3, a4, dimensionPixelSize, a5, rect);
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    /* access modifiers changed from: package-private */
    public final void a(TextView textView) {
        h hVar = new h();
        h hVar2 = new h();
        hVar.setShapeAppearanceModel(this.f36183f);
        hVar2.setShapeAppearanceModel(this.f36183f);
        hVar.g(this.f36180c);
        hVar.a((float) this.f36182e, this.f36181d);
        textView.setTextColor(this.f36179b);
        u.a((View) textView, (Drawable) new InsetDrawable(Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f36179b.withAlpha(30), hVar, hVar2) : hVar, this.f36178a.left, this.f36178a.top, this.f36178a.right, this.f36178a.bottom));
    }
}
