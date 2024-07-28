package com.google.android.play.core.b;

import java.io.IOException;
import java.io.InputStream;

public final class ay extends ax {

    /* renamed from: a  reason: collision with root package name */
    private final ax f37275a;

    /* renamed from: b  reason: collision with root package name */
    private final long f37276b;

    /* renamed from: c  reason: collision with root package name */
    private final long f37277c;

    public ay(ax axVar, long j, long j2) {
        this.f37275a = axVar;
        long a2 = a(j);
        this.f37276b = a2;
        this.f37277c = a(a2 + j2);
    }

    private final long a(long j) {
        if (j >= 0) {
            return j > this.f37275a.a() ? this.f37275a.a() : j;
        }
        return 0;
    }

    public final long a() {
        return this.f37277c - this.f37276b;
    }

    /* access modifiers changed from: protected */
    public final InputStream a(long j, long j2) throws IOException {
        long a2 = a(this.f37276b + j);
        return this.f37275a.a(a2, a(j2 + a2) - a2);
    }

    public final void close() throws IOException {
    }
}
