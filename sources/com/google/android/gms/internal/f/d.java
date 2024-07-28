package com.google.android.gms.internal.f;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public final class d {
    @NonNullDecl
    public static <T> T a(@NonNullDecl T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
