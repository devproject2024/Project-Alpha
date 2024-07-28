package com.bumptech.glide.load.b;

import androidx.core.g.e;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.j;

final class u<Z> implements a.c, v<Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final e.a<u<?>> f6945a = a.a(20, new a.C0091a<u<?>>() {
        public final /* synthetic */ Object a() {
            return new u();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final b f6946b = new b.a();

    /* renamed from: c  reason: collision with root package name */
    private v<Z> f6947c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6948d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6949e;

    static <Z> u<Z> a(v<Z> vVar) {
        u<Z> uVar = (u) j.a(f6945a.a(), "Argument must not be null");
        uVar.f6949e = false;
        uVar.f6948d = true;
        uVar.f6947c = vVar;
        return uVar;
    }

    u() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e() {
        this.f6946b.a();
        if (this.f6948d) {
            this.f6948d = false;
            if (this.f6949e) {
                d();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public final Class<Z> a() {
        return this.f6947c.a();
    }

    public final Z b() {
        return this.f6947c.b();
    }

    public final int c() {
        return this.f6947c.c();
    }

    public final synchronized void d() {
        this.f6946b.a();
        this.f6949e = true;
        if (!this.f6948d) {
            this.f6947c.d();
            this.f6947c = null;
            f6945a.a(this);
        }
    }

    public final b e_() {
        return this.f6946b;
    }
}
