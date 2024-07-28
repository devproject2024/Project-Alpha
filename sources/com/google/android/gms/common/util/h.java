package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class h implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final h f8976a = new h();

    public static e d() {
        return f8976a;
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    public final long c() {
        return System.nanoTime();
    }

    private h() {
    }
}
