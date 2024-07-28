package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class aq<T> implements am<T>, Serializable {
    @NullableDecl
    private final T zzlo;

    aq(@NullableDecl T t) {
        this.zzlo = t;
    }

    public final T get() {
        return this.zzlo;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof aq) {
            return aj.a(this.zzlo, ((aq) obj).zzlo);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzlo});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzlo);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
