package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class af<T> extends ai<T> {
    static final af<Object> zzlj = new af<>();

    private af() {
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
