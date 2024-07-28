package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import java.util.List;
import java.util.Map;

final class ed implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ee f11842a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11843b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f11844c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f11845d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11846e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, List<String>> f11847f;

    private ed(String str, ee eeVar, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        s.a(eeVar);
        this.f11842a = eeVar;
        this.f11843b = i2;
        this.f11844c = th;
        this.f11845d = bArr;
        this.f11846e = str;
        this.f11847f = map;
    }

    public final void run() {
        this.f11842a.a(this.f11846e, this.f11843b, this.f11844c, this.f11845d, this.f11847f);
    }

    /* synthetic */ ed(String str, ee eeVar, int i2, Throwable th, byte[] bArr, Map map, byte b2) {
        this(str, eeVar, i2, th, bArr, map);
    }
}
