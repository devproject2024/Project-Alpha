package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class bv {
    public static <T> br<T> a(br<T> brVar) {
        if ((brVar instanceof bx) || (brVar instanceof bu)) {
            return brVar;
        }
        if (brVar instanceof Serializable) {
            return new bu(brVar);
        }
        return new bx(brVar);
    }

    public static <T> br<T> a(@NullableDecl T t) {
        return new bw(t);
    }
}
