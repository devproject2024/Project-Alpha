package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import java.util.HashMap;
import java.util.Map;

final class s {

    /* renamed from: a  reason: collision with root package name */
    private final Map<g, l<?>> f6939a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<g, l<?>> f6940b = new HashMap();

    s() {
    }

    /* access modifiers changed from: package-private */
    public final Map<g, l<?>> a(boolean z) {
        return z ? this.f6940b : this.f6939a;
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar, l<?> lVar) {
        Map<g, l<?>> a2 = a(lVar.f6908b);
        if (lVar.equals(a2.get(gVar))) {
            a2.remove(gVar);
        }
    }
}
