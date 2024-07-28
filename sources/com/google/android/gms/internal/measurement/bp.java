package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public final class bp {
    @NonNullDecl
    public static <T> T a(@NonNullDecl T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
