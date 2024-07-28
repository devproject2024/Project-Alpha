package com.paytm.network.a.a;

import android.os.Handler;
import android.os.Looper;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f42865a;

    public static void a() {
        f42865a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable runnable) {
        if (f42865a == null) {
            f42865a = new Handler(Looper.getMainLooper());
        }
        f42865a.post(runnable);
    }
}
