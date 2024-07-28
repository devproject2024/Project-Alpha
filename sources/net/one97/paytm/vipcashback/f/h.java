package net.one97.paytm.vipcashback.f;

public final class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f20893a;

    /* renamed from: b  reason: collision with root package name */
    public T f20894b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f20895c;

    private h(int i2, T t, Throwable th) {
        this.f20893a = i2;
        this.f20894b = t;
        this.f20895c = th;
    }

    public static <T> h<T> a(T t) {
        return new h<>(101, t, (Throwable) null);
    }

    public static <T> h<T> a(T t, Throwable th) {
        return new h<>(102, t, th);
    }

    public static <T> h<T> a() {
        return new h<>(103, (Object) null, (Throwable) null);
    }

    public static <T> h<T> b() {
        return new h<>(105, (Object) null, (Throwable) null);
    }

    public static <T> h<T> b(T t) {
        return new h<>(104, t, (Throwable) null);
    }
}
