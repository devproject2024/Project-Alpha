package com.google.android.gms.internal.vision;

import java.io.Serializable;

public final class ap {
    public static <T> am<T> a(am<T> amVar) {
        if ((amVar instanceof ar) || (amVar instanceof ao)) {
            return amVar;
        }
        if (amVar instanceof Serializable) {
            return new ao(amVar);
        }
        return new ar(amVar);
    }
}
