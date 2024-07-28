package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.e.k.m;
import java.util.Objects;

public final class o<T> {

    /* renamed from: b  reason: collision with root package name */
    static final o<Object> f46610b = new o<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f46611a;

    private o(Object obj) {
        this.f46611a = obj;
    }

    public final boolean a() {
        return this.f46611a == null;
    }

    public final boolean b() {
        Object obj = this.f46611a;
        return obj != null && !m.isError(obj);
    }

    public final T c() {
        Object obj = this.f46611a;
        if (obj == null || m.isError(obj)) {
            return null;
        }
        return this.f46611a;
    }

    public final Throwable d() {
        Object obj = this.f46611a;
        if (m.isError(obj)) {
            return m.getError(obj);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return Objects.equals(this.f46611a, ((o) obj).f46611a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f46611a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.f46611a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (m.isError(obj)) {
            return "OnErrorNotification[" + m.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f46611a + "]";
    }

    public static <T> o<T> a(T t) {
        Objects.requireNonNull(t, "value is null");
        return new o<>(t);
    }

    public static <T> o<T> a(Throwable th) {
        Objects.requireNonNull(th, "error is null");
        return new o<>(m.error(th));
    }

    public static <T> o<T> e() {
        return f46610b;
    }
}
