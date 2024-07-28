package com.google.android.gms.internal.icing;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ad<T> extends af<T> {
    static final ad<Object> zzdq = new ad<>();

    private ad() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final boolean isPresent() {
        return false;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    public final T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
