package io.reactivex.rxjava3.e.b;

import io.reactivex.rxjava3.d.d;
import java.util.Objects;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final d<Object, Object> f46681a = new a();

    public static <T> d<T, T> a() {
        return f46681a;
    }

    public static int a(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    public static long a(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j);
    }

    static final class a implements d<Object, Object> {
        a() {
        }

        public final boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }
}
