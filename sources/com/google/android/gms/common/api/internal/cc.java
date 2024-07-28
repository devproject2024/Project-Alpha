package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.l;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class cc {

    /* renamed from: a  reason: collision with root package name */
    public static final Status f8504a = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: b  reason: collision with root package name */
    static final BasePendingResult<?>[] f8505b = new BasePendingResult[0];

    /* renamed from: c  reason: collision with root package name */
    final Set<BasePendingResult<?>> f8506c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d  reason: collision with root package name */
    private final cd f8507d = new cb(this);

    /* renamed from: e  reason: collision with root package name */
    private final Map<a.c<?>, a.f> f8508e;

    public cc(Map<a.c<?>, a.f> map) {
        this.f8508e = map;
    }

    /* access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends l> basePendingResult) {
        this.f8506c.add(basePendingResult);
        basePendingResult.a(this.f8507d);
    }

    public final void a() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f8506c.toArray(f8505b)) {
            basePendingResult.a((cd) null);
            basePendingResult.c();
            if (basePendingResult.d()) {
                this.f8506c.remove(basePendingResult);
            }
        }
    }
}
