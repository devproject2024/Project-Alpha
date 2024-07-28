package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ak<T> extends ai<T> {
    private final T zzll;

    ak(T t) {
        this.zzll = t;
    }

    public final boolean isPresent() {
        return true;
    }

    public final T get() {
        return this.zzll;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof ak) {
            return this.zzll.equals(((ak) obj).zzll);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzll.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzll);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
