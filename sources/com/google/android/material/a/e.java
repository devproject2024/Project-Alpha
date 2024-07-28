package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.WeakHashMap;

public final class e extends Property<Drawable, Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<Drawable, Integer> f35807a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f35808b = new WeakHashMap<>();

    public final /* synthetic */ Object get(Object obj) {
        Drawable drawable = (Drawable) obj;
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f35808b.containsKey(drawable)) {
            return this.f35808b.get(drawable);
        }
        return Integer.valueOf(PriceRangeSeekBar.INVALID_POINTER_ID);
    }

    public final /* synthetic */ void set(Object obj, Object obj2) {
        Drawable drawable = (Drawable) obj;
        Integer num = (Integer) obj2;
        if (Build.VERSION.SDK_INT < 19) {
            this.f35808b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }

    private e() {
        super(Integer.class, "drawableAlphaCompat");
    }
}
