package com.google.android.gms.internal.vision;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ar<T> implements am<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile am<T> f10990a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f10991b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    private T f10992c;

    ar(am<T> amVar) {
        this.f10990a = (am) al.a(amVar);
    }

    public final T get() {
        if (!this.f10991b) {
            synchronized (this) {
                if (!this.f10991b) {
                    T t = this.f10990a.get();
                    this.f10992c = t;
                    this.f10991b = true;
                    this.f10990a = null;
                    return t;
                }
            }
        }
        return this.f10992c;
    }

    public final String toString() {
        Object obj = this.f10990a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f10992c);
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
