package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35899a = (Build.VERSION.SDK_INT < 18);

    public static void a(Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }

    public static void a(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        c(badgeDrawable, view, frameLayout);
        if (f35899a) {
            frameLayout.setForeground(badgeDrawable);
        } else {
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void b(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        if (badgeDrawable != null) {
            if (f35899a) {
                frameLayout.setForeground((Drawable) null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }

    public static void c(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        (f35899a ? frameLayout : view).getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.a(view, (ViewGroup) frameLayout);
    }

    public static ParcelableSparseArray a(SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        int i2 = 0;
        while (i2 < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i2);
            BadgeDrawable valueAt = sparseArray.valueAt(i2);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.f35883a);
                i2++;
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    public static SparseArray<BadgeDrawable> a(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        int i2 = 0;
        while (i2 < parcelableSparseArray.size()) {
            int keyAt = parcelableSparseArray.keyAt(i2);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i2);
            if (savedState != null) {
                sparseArray.put(keyAt, BadgeDrawable.a(context, savedState));
                i2++;
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }
}
