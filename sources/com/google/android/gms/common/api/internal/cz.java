package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class cz {

    /* renamed from: a  reason: collision with root package name */
    final Map<BasePendingResult<?>, Boolean> f8566a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    final Map<f<?>, Boolean> f8567b = Collections.synchronizedMap(new WeakHashMap());

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return !this.f8566a.isEmpty() || !this.f8567b.isEmpty();
    }

    public final void b() {
        a(false, f.f8584a);
    }

    public final void c() {
        a(true, cc.f8504a);
    }

    private final void a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f8566a) {
            hashMap = new HashMap(this.f8566a);
        }
        synchronized (this.f8567b) {
            hashMap2 = new HashMap(this.f8567b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).c(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((f) entry2.getKey()).b((Exception) new ApiException(status));
            }
        }
    }
}
