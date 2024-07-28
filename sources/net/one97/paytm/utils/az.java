package net.one97.paytm.utils;

import android.content.Context;
import android.content.res.TypedArray;
import net.one97.paytm.paytm_finance.R;

public final class az {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f69702a = {R.attr.colorPrimary};

    public static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f69702a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
