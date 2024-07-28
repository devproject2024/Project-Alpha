package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.internal.s;
import java.lang.ref.WeakReference;

public final class bx<R extends l> extends p<R> implements m<R> {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public o<? super R, ? extends l> f8486a;

    /* renamed from: b  reason: collision with root package name */
    volatile n<? super R> f8487b;

    /* renamed from: c  reason: collision with root package name */
    g<R> f8488c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public final Object f8489d;

    /* renamed from: e  reason: collision with root package name */
    Status f8490e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public final WeakReference<e> f8491f;

    /* renamed from: g  reason: collision with root package name */
    boolean f8492g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public bx<? extends l> f8493h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final bz f8494i;

    public final void onResult(R r) {
        synchronized (this.f8489d) {
            if (!r.a().c()) {
                b(r.a());
                b((l) r);
            } else if (this.f8486a != null) {
                bp.a().submit(new ca(this, r));
            } else if (a()) {
                n<? super R> nVar = this.f8487b;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(Status status) {
        synchronized (this.f8489d) {
            this.f8490e = status;
            a(this.f8490e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Status status) {
        synchronized (this.f8489d) {
            if (this.f8486a != null) {
                s.a(status, (Object) "onFailure must not return null");
                this.f8493h.b(status);
            } else if (a()) {
                n<? super R> nVar = this.f8487b;
            }
        }
    }

    private final boolean a() {
        return (this.f8487b == null || ((e) this.f8491f.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public static void b(l lVar) {
        if (lVar instanceof i) {
            try {
                ((i) lVar).a();
            } catch (RuntimeException unused) {
                String valueOf = String.valueOf(lVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
            }
        }
    }
}
