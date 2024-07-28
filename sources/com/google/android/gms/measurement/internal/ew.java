package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import java.lang.Thread;

final class ew implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f11921a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ eu f11922b;

    public ew(eu euVar, String str) {
        this.f11922b = euVar;
        s.a(str);
        this.f11921a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f11922b.J_().f11828c.a(this.f11921a, th);
    }
}
