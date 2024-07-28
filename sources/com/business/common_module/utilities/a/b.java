package com.business.common_module.utilities.a;

import retrofit2.Response;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public Response<?> f7356a;

    /* renamed from: b  reason: collision with root package name */
    public e f7357b;

    /* renamed from: c  reason: collision with root package name */
    public T f7358c;

    /* renamed from: d  reason: collision with root package name */
    public String f7359d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f7360e;

    private b(Response<?> response, e eVar, T t, String str, Throwable th) {
        this.f7356a = response;
        this.f7357b = eVar;
        this.f7358c = t;
        this.f7359d = str;
        this.f7360e = th;
    }

    public static <T> b<T> a(Response<?> response, T t) {
        return new b(response, e.SUCCESS, t, (String) null, (Throwable) null);
    }

    public static <T> b<T> a(T t) {
        return new b((Response<?>) null, e.SUCCESS, t, (String) null, (Throwable) null);
    }

    public static <T> b<T> a(Response<?> response) {
        return new b(response, e.ERROR, (Object) null, (String) null, (Throwable) null);
    }

    public static <T> b<T> b(Response<?> response, T t) {
        return new b(response, e.ERROR, t, (String) null, (Throwable) null);
    }

    public static <T> b<T> a(Throwable th) {
        return new b((Response<?>) null, e.FAILURE, (Object) null, (String) null, th);
    }

    public static <T> b<T> a() {
        return new b((Response<?>) null, e.LOADING, (Object) null, (String) null, (Throwable) null);
    }

    public static <T> b<T> a(String str) {
        return new b((Response<?>) null, e.OFFLINE, (Object) null, str, (Throwable) null);
    }
}
