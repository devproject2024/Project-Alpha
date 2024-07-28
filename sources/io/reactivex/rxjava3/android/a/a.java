package io.reactivex.rxjava3.android.a;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h<Callable<x>, x> f46627a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile h<x, x> f46628b;

    public static x a(Callable<x> callable) {
        try {
            x call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw j.a(th);
        }
    }

    public static <T, R> R a(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw j.a(th);
        }
    }
}
