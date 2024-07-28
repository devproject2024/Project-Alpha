package net.one97.paytm.o2o.movies.common.customui;

import android.content.Context;
import android.content.res.TypedArray;
import com.google.android.material.R;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f75111a = {R.attr.colorPrimary};

    static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f75111a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
