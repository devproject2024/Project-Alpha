package com.google.android.gms.internal.icing;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ai<T> implements ag<T>, Serializable {
    @NullableDecl
    private transient T value;
    private final ag<T> zzds;
    private volatile transient boolean zzdt;

    ai(ag<T> agVar) {
        this.zzds = (ag) ae.a(agVar);
    }

    public final T get() {
        if (!this.zzdt) {
            synchronized (this) {
                if (!this.zzdt) {
                    T t = this.zzds.get();
                    this.value = t;
                    this.zzdt = true;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj;
        if (this.zzdt) {
            String valueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            obj = sb.toString();
        } else {
            obj = this.zzds;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
