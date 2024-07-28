package com.google.android.gms.internal.measurement;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class bx<T> implements br<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile br<T> f10508a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f10509b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    private T f10510c;

    bx(br<T> brVar) {
        this.f10508a = (br) bp.a(brVar);
    }

    public final T zza() {
        if (!this.f10509b) {
            synchronized (this) {
                if (!this.f10509b) {
                    T zza = this.f10508a.zza();
                    this.f10510c = zza;
                    this.f10509b = true;
                    this.f10508a = null;
                    return zza;
                }
            }
        }
        return this.f10510c;
    }

    public final String toString() {
        Object obj = this.f10508a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f10510c);
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
