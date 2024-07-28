package com.bumptech.glide.b;

import com.bumptech.glide.g.k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f6432a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f6433b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6434c;

    a() {
    }

    public final void a(i iVar) {
        this.f6432a.add(iVar);
        if (this.f6434c) {
            iVar.c();
        } else if (this.f6433b) {
            iVar.a();
        } else {
            iVar.b();
        }
    }

    public final void b(i iVar) {
        this.f6432a.remove(iVar);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f6433b = true;
        for (T a2 : k.a(this.f6432a)) {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f6433b = false;
        for (T b2 : k.a(this.f6432a)) {
            b2.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f6434c = true;
        for (T c2 : k.a(this.f6432a)) {
            c2.c();
        }
    }
}
