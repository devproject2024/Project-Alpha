package com.google.android.gms.common;

import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.j;
import java.util.concurrent.Callable;

class w {

    /* renamed from: c  reason: collision with root package name */
    private static final w f8999c = new w(true, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f9000a;

    /* renamed from: b  reason: collision with root package name */
    final Throwable f9001b;

    /* renamed from: d  reason: collision with root package name */
    private final String f9002d;

    w(boolean z, String str, Throwable th) {
        this.f9000a = z;
        this.f9002d = str;
        this.f9001b = th;
    }

    static w a() {
        return f8999c;
    }

    static w a(Callable<String> callable) {
        return new y(callable, (byte) 0);
    }

    static w a(String str) {
        return new w(false, str, (Throwable) null);
    }

    static w a(String str, Throwable th) {
        return new w(false, str, th);
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f9002d;
    }

    static String a(String str, o oVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{z2 ? "debug cert rejected" : "not whitelisted", str, j.b(a.a("SHA-1").digest(oVar.c())), Boolean.valueOf(z), "12451009.false"});
    }
}
