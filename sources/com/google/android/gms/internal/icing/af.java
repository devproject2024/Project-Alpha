package com.google.android.gms.internal.icing;

import java.io.Serializable;

public abstract class af<T> implements Serializable {
    public static <T> af<T> zzv() {
        return ad.zzdq;
    }

    public abstract T get();

    public abstract boolean isPresent();

    public static <T> af<T> zzb(T t) {
        return new ah(ae.a(t));
    }

    af() {
    }
}
