package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.h;
import java.util.Collections;
import java.util.Set;

public abstract class g<T extends IInterface> extends c<T> implements a.f, h.a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Scope> f8836a;

    /* renamed from: i  reason: collision with root package name */
    protected final d f8837i;
    private final Account j;

    protected g(Context context, Looper looper, int i2, d dVar, e eVar, m mVar) {
        this(context, looper, i.a(context), c.a(), i2, dVar, (e) s.a(eVar), (m) s.a(mVar));
    }

    @Deprecated
    protected g(Context context, Looper looper, int i2, d dVar, e.b bVar, e.c cVar) {
        this(context, looper, i2, dVar, (com.google.android.gms.common.api.internal.e) bVar, (m) cVar);
    }

    public final Account n() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> s() {
        return this.f8836a;
    }

    public final Set<Scope> l() {
        return i() ? this.f8836a : Collections.emptySet();
    }

    public int e() {
        return super.e();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private g(android.content.Context r12, android.os.Looper r13, com.google.android.gms.common.internal.i r14, com.google.android.gms.common.c r15, int r16, com.google.android.gms.common.internal.d r17, com.google.android.gms.common.api.internal.e r18, com.google.android.gms.common.api.internal.m r19) {
        /*
            r11 = this;
            r9 = r11
            r10 = r17
            r0 = r18
            r1 = r19
            r2 = 0
            if (r0 != 0) goto L_0x000c
            r6 = r2
            goto L_0x0012
        L_0x000c:
            com.google.android.gms.common.internal.aa r3 = new com.google.android.gms.common.internal.aa
            r3.<init>(r0)
            r6 = r3
        L_0x0012:
            if (r1 != 0) goto L_0x0016
            r7 = r2
            goto L_0x001c
        L_0x0016:
            com.google.android.gms.common.internal.ab r0 = new com.google.android.gms.common.internal.ab
            r0.<init>(r1)
            r7 = r0
        L_0x001c:
            java.lang.String r8 = r10.f8821f
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.f8837i = r10
            android.accounts.Account r0 = r10.f8816a
            r9.j = r0
            java.util.Set<com.google.android.gms.common.api.Scope> r0 = r10.f8818c
            java.util.Iterator r1 = r0.iterator()
        L_0x0034:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004f
            java.lang.Object r2 = r1.next()
            com.google.android.gms.common.api.Scope r2 = (com.google.android.gms.common.api.Scope) r2
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto L_0x0047
            goto L_0x0034
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Expanding scopes is not permitted, use implied scopes instead"
            r0.<init>(r1)
            throw r0
        L_0x004f:
            r9.f8836a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.g.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.i, com.google.android.gms.common.c, int, com.google.android.gms.common.internal.d, com.google.android.gms.common.api.internal.e, com.google.android.gms.common.api.internal.m):void");
    }
}
