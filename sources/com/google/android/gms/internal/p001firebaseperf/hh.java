package com.google.android.gms.internal.p001firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.hh  reason: invalid package */
public final class hh<T> implements ec<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile ec<T> f9692a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f9693b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    private T f9694c;

    public hh(ec<T> ecVar) {
        this.f9692a = (ec) cc.a(ecVar);
    }

    public final T a() {
        if (!this.f9693b) {
            synchronized (this) {
                if (!this.f9693b) {
                    T a2 = this.f9692a.a();
                    this.f9694c = a2;
                    this.f9693b = true;
                    this.f9692a = null;
                    return a2;
                }
            }
        }
        return this.f9694c;
    }

    public final String toString() {
        Object obj = this.f9692a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f9694c);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
