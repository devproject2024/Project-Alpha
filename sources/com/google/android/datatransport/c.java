package com.google.android.datatransport;

public abstract class c<T> {
    public abstract Integer a();

    public abstract T b();

    public abstract d c();

    public static <T> c<T> a(T t) {
        return new a(t, d.HIGHEST);
    }
}
