package com.paytm.android.chat.view.kpswitch.b;

import android.content.Context;
import com.paytm.utility.q;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f42609a = false;

    /* renamed from: b  reason: collision with root package name */
    private static int f42610b = 50;

    public static synchronized int a(Context context) {
        int i2;
        int identifier;
        synchronized (c.class) {
            if (!f42609a && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                f42610b = context.getResources().getDimensionPixelSize(identifier);
                f42609a = true;
                q.d(String.format("Get status bar height %d", new Object[]{Integer.valueOf(f42610b)}));
            }
            i2 = f42610b;
        }
        return i2;
    }
}
