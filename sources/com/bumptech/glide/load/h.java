package com.bumptech.glide.load;

import com.bumptech.glide.g.j;
import java.security.MessageDigest;

public final class h<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final a<Object> f7265e = new a<Object>() {
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final T f7266a;

    /* renamed from: b  reason: collision with root package name */
    final a<T> f7267b;

    /* renamed from: c  reason: collision with root package name */
    final String f7268c;

    /* renamed from: d  reason: collision with root package name */
    volatile byte[] f7269d;

    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public static <T> h<T> a(String str) {
        return new h<>(str, (Object) null, f7265e);
    }

    public static <T> h<T> a(String str, T t) {
        return new h<>(str, t, f7265e);
    }

    public static <T> h<T> a(String str, T t, a<T> aVar) {
        return new h<>(str, t, aVar);
    }

    private h(String str, T t, a<T> aVar) {
        this.f7268c = j.a(str);
        this.f7266a = t;
        this.f7267b = (a) j.a(aVar, "Argument must not be null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f7268c.equals(((h) obj).f7268c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7268c.hashCode();
    }

    public final String toString() {
        return "Option{key='" + this.f7268c + '\'' + '}';
    }
}
