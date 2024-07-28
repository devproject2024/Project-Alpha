package com.google.android.gms.internal.icing;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ak<T> implements ag<T>, Serializable {
    @NullableDecl
    private final T zzdu;

    ak(@NullableDecl T t) {
        this.zzdu = t;
    }

    public final T get() {
        return this.zzdu;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        T t = this.zzdu;
        T t2 = ((ak) obj).zzdu;
        if (t == t2) {
            return true;
        }
        if (t == null || !t.equals(t2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdu});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdu);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
