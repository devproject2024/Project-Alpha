package com.google.android.gms.common.c;

import android.content.Context;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f8655b = new c();

    /* renamed from: a  reason: collision with root package name */
    private b f8656a = null;

    private final synchronized b b(Context context) {
        if (this.f8656a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f8656a = new b(context);
        }
        return this.f8656a;
    }

    public static b a(Context context) {
        return f8655b.b(context);
    }
}
